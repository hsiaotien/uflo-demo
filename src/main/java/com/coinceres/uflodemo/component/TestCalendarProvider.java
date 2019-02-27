package com.coinceres.uflodemo.component;

import com.bstek.uflo.process.node.reminder.CalendarInfo;
import com.bstek.uflo.process.node.reminder.CalendarProvider;
import org.quartz.Calendar;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestCalendarProvider implements CalendarProvider {
    @Override
    public Calendar getCalendar(String s) {

        return null;
    }

    @Override
    public List<CalendarInfo> getCalendarInfos() {
        List<CalendarInfo> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CalendarInfo calendarInfo = new CalendarInfo();
            calendarInfo.setId("1"+i);
            calendarInfo.setName("shiyi-" + i);
            list.add(calendarInfo);
        }
        return list;
    }
}
