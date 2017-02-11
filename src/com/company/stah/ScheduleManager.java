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

    /**
     *
     * 予定の最大登録件数を設定
     * @param max
     */
    public ScheduleManager(int max){

        this.max = max;
    }

    /**
     *
     *
     * @param date
     * @param event
     */
    public void setSchedule(Date date, Event event)
    {
        ScheduleDao schedule = new ScheduleSQLite();
        //ScheduleDao schedule = new ScheduleStub();
        schedule.createSchedule(date, event);
    }

    /**
     *
     * @param start
     * @param end
     * @return
     */
    public String findEvent(Date start, Date end)
    {
        ScheduleJson json = new ScheduleJson();

        //ScheduleDao schedule = new ScheduleStub();
        ScheduleDao schedule = new ScheduleSQLite();
        json.schedule = schedule.findEvent(start, end);

        JSonParser parser = new JSonParser();
        return parser.SchedulePrinter(json);
    }
}
