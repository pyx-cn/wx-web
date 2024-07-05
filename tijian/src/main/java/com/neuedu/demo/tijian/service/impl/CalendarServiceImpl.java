package com.neuedu.demo.tijian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neuedu.demo.tijian.mapper.HospitalMapper;
import com.neuedu.demo.tijian.mapper.OrdersMapper;
import com.neuedu.demo.tijian.pojo.Orders;
import com.neuedu.demo.tijian.pojo.calendar.CalendarResponse;
import com.neuedu.demo.tijian.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    private HospitalMapper hospitalMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    private static final int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    @Override
    public List<CalendarResponse> getCalendar(Integer year, Integer month, Integer hpId) {

        List<CalendarResponse> calendarResponses = new ArrayList<>();
        List<CalendarResponse> reservationCalendar = getReservationCalendar(hpId); // 与hpId关联的预约日历

        LocalDate firstDate = LocalDate.of(year, month, 1);

        //月初到第一天不需要预约信息，赋空值
        for (int i = 0; i < firstDate.getDayOfWeek().getValue(); i++) {
            calendarResponses.add(new CalendarResponse());
        }

        //判断今年是否是闰年
        int isRUN = 0;
        if (month == 2 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
            isRUN = 1;
        }

        int x, y = 31;
        boolean isFind = false; // 查找第一个预约日期

        //找到第一个预约日期
        for (x = 1; x <= daysOfMonth[month - 1] + isRUN; x++) { // 遍历当月所有日期
            for (y = 0; y < reservationCalendar.size(); y++) { // 遍历预约日历, 判断是否是预约日期
                if (reservationCalendar.get(y).getYmd().equals(String.format("%04d-%02d-%02d", year, month, x))) {
                    isFind = true;
                    break;
                }
            }
            if (isFind) break;
        }

        // 构造返回的日历
        for (int i = 1; i <= daysOfMonth[month - 1] + isRUN; i++) {
            String date = String.format("%04d-%02d-%02d", year, month, i);
            CalendarResponse calendar;
            if (i == x && isFind && y < reservationCalendar.size()) {
                calendar = reservationCalendar.get(y);
                y++;
                x++;
            } else {
                calendar = new CalendarResponse(date, 0, 0, 0);
            }
            calendarResponses.add(calendar);
        }

        return calendarResponses;
    }


    //未来30天的预约日历
    public List<CalendarResponse> getReservationCalendar(Integer hpId) {
        List<CalendarResponse> calendarResponsesList = new ArrayList<>();

        //获取医院每天的预约上限
        String[] hospitalRules = hospitalMapper.selectById(hpId).getRule().split(",");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < 30; i++) {
            if (i > 0) calendar.add(Calendar.DATE, 1); //所求预约人数的日期，除第一天，每次循环递增一天
            CalendarResponse calendarResponse = new CalendarResponse();
            calendarResponse.setYmd(sdf.format(calendar.getTime()));
            calendarResponse.setTotal(Integer.parseInt(hospitalRules[calendar.get(Calendar.DAY_OF_WEEK) - 1]));

            //获取当天已预约人数
            QueryWrapper<Orders> wrapper = new QueryWrapper<Orders>().eq("orderDate", calendarResponse.getYmd())
                    .eq("hpId", hpId).eq("state", 1);
            calendarResponse.setExisting(Math.toIntExact(ordersMapper.selectCount(wrapper)));
            calendarResponse.setRemainder(calendarResponse.getTotal() - calendarResponse.getExisting());
            calendarResponsesList.add(calendarResponse);
        }
        return calendarResponsesList;
    }


}
