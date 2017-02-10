package com.company.stah.dao;

import com.company.stah.Date;
import com.company.stah.Event;

import java.util.HashMap;
import java.util.Map;

public class ScheduleStub extends ScheduleDao {

    private Date date;
    private Event event;
    @Override
    public void createSchedule(Date date, Event event) {

        this.date = date;
        this.event = event;
    }

    @Override
    public Map<Date,Event> findEvent(Date start, Date end) {

        //search
        System.out.println(start.getDate());
        System.out.println(end.getDate());

        Map<Date, Event> map = new HashMap<Date, Event>();
        map.put(this.date, this.event);

        return map;
    }
}
