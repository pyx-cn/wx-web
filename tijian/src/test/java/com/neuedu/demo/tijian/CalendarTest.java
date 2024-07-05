package com.neuedu.demo.tijian;


import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarTest {
    @Test
    public void test() {
        int year = 2024;
        int month = 6;
        int[] daysOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        int totalDaysOfY = (year-1900)*365 + (year-1900)/4 - (year-1900)/100 + (year-2000)/400;
        if((year%4==0 && year%100!=0) || (year%400==0)){
            totalDaysOfY--;
        }

        for(int i=0;i<month-1;i++){
            if(i == 1) totalDaysOfY++;
            totalDaysOfY += daysOfMonth[i];
        }

        totalDaysOfY +=31;

        int currentDay = totalDaysOfY%7+1;
        System.out.println(currentDay);
    }

    @Test
    public void test1() {
        LocalDate date = LocalDate.now();
        System.out.println(date.getDayOfWeek().getValue());
        System.out.println(date.getDayOfMonth());
    }

    @Test
    public void test2() {
        LocalDate date = LocalDate.now();
        System.out.println(date.getDayOfWeek().getValue());
        System.out.println(date.getDayOfMonth());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();

        //做一个临时集合，作为去Orders表中查询的参数
        for(int i=0;i<30;i++) {
            if(i>0)calendar.add(Calendar.DATE, 1); //计算1天后的时间
            System.out.println(sdf.format(calendar.getTime()));
            System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        }

    }

}
