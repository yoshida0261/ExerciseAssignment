package com.company.stah;

import com.company.stah.dao.ScheduleDao;
import com.company.stah.dao.ScheduleSQLite;
import com.company.stah.dao.ScheduleStub;
import com.company.stah.model.Date;
import com.company.stah.model.Event;
import com.company.stah.model.ScheduleJson;

public class ScheduleManager {

    private int max;

    public void setDebugMode(){
        // logger をdebugレベルに設定
    }

    public ScheduleManager(int max){

    }

    public void setSchedule(Date date, Event event)
    {
        //event数がmaxを超えたらエラー
        //ScheduleDao schedule = new ScheduleSQLite();
        ScheduleDao schedule = new ScheduleStub();
        schedule.createSchedule(date, event);
    }

    public String findEvent(Date start, Date end)
    {
        ScheduleJson json = new ScheduleJson();

        ScheduleDao schedule = new ScheduleStub();
        json.schedule = schedule.findEvent(start, end);

        JSonParser parser = new JSonParser();
        return parser.SchedulePrinter(json);
    }
}
