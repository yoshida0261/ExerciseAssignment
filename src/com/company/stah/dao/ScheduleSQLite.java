package com.company.stah.dao;

import com.company.stah.Date;
import com.company.stah.Event;

import java.util.Map;

public class ScheduleSQLite extends ScheduleDao {
    @Override
    public void createSchedule(Date date, Event event) {

    }

    @Override
    public Map<Date, Event> findEvent(Date start, Date end) {
        return null;
    }
}
