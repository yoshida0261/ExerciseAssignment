package com.company.stah.dao;

import com.company.stah.Date;
import com.company.stah.Event;

import java.util.Map;

public abstract class ScheduleDao {

    abstract public void createSchedule(Date date, Event event);
    abstract public Map<Date,Event> findEvent(Date start, Date end);



}
