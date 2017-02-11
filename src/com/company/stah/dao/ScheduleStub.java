package com.company.stah.dao;

import com.company.stah.model.Date;
import com.company.stah.model.Event;

import java.util.HashMap;
import java.util.Map;

public class ScheduleStub extends ScheduleDao {

    private Date date;
    private Event event;
    @Override
    public void createSchedule(Date date, Event event) {

        this.date = date;
        this.event = event;
        System.out.println("create Schedule...");
        System.out.println(date.getDate());
        System.out.println(event.getEvent());
    }

    @Override
    public Map<Date,Event> findEvent(Date start, Date end) {

        //search
        System.out.println("find Event...");
        System.out.println("  start :" + start.getDate());
        System.out.println("  end   :" + end.getDate());

        Map<Date, Event> map = new HashMap<Date, Event>();
        map.put(start, new Event("test Event"));

        return map;
    }
}
