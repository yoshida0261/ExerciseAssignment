package com.company.stah.dao;

import com.company.stah.DateYYYYMMDDhhmm;
import com.company.stah.Event;

import java.util.HashMap;
import java.util.Map;

public class ScheduleStub extends ScheduleDao {

    private DateYYYYMMDDhhmm date;
    private Event event;
    @Override
    public void createSchedule(DateYYYYMMDDhhmm date, Event event) {

        this.date = date;
        this.event = event;
    }

    @Override
    public Map<DateYYYYMMDDhhmm,Event> findEvent(DateYYYYMMDDhhmm start, DateYYYYMMDDhhmm end) {

        //search
        System.out.println(start.toString());
        System.out.println(end.toString());

        Map<DateYYYYMMDDhhmm, Event> map = new HashMap<DateYYYYMMDDhhmm, Event>();
        map.put(this.date, this.event);

        return map;
    }
}
