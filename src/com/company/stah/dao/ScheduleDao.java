package com.company.stah.dao;

import com.company.stah.DateYYYYMMDDhhmm;
import com.company.stah.Event;

import javax.xml.crypto.Data;
import java.util.Map;

public abstract class ScheduleDao {

    abstract public void createSchedule(DateYYYYMMDDhhmm date, Event event);
    abstract public Map<DateYYYYMMDDhhmm,Event> findEvent(DateYYYYMMDDhhmm start, DateYYYYMMDDhhmm end);



}
