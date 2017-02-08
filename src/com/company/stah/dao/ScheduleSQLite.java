package com.company.stah.dao;

import com.company.stah.DateYYYYMMDDhhmm;
import com.company.stah.Event;

import java.util.Map;

public class ScheduleSQLite extends ScheduleDao {
    @Override
    public void createSchedule(DateYYYYMMDDhhmm date, Event event) {

    }

    @Override
    public Map<DateYYYYMMDDhhmm, Event> findEvent(DateYYYYMMDDhhmm start, DateYYYYMMDDhhmm end) {
        return null;
    }
}
