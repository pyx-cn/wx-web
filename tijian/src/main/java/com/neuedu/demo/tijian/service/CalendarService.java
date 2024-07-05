package com.neuedu.demo.tijian.service;

import com.neuedu.demo.tijian.pojo.calendar.CalendarResponse;

import java.util.List;

public interface CalendarService {
    public List<CalendarResponse> getCalendar(Integer year, Integer month, Integer hpId);
}
