package com.company.stah.dao;

import com.company.stah.DBManager;
import com.company.stah.model.Date;
import com.company.stah.model.Event;

import java.sql.*;
import java.util.Map;

public class ScheduleSQLite extends ScheduleDao {
    private DBManager manager = null;
    public ScheduleSQLite(){
        manager = new DBManager();
        manager.setConnect("schedule.db");

    }

    @Override
    public void createSchedule(Date date, Event event) {
        //insert into schedule values('2017-02-11:22:00.000', "ev");

        String sql = "insert into schedule values('"+date.toString() + "', '" + event.getEvent()+ "');";
        manager.executeQuery(DBManager.Dbctrl.Insert, sql);


    }


    /**
     * start-endで範囲を絞り照準した結果を返す
     * @param start　開始範囲
     * @param end    終端範囲
     * @return
     */
    @Override
    public Map<Date, Event> findEvent(Date start, Date end) {


        //select * from schedule where column between datetime('2017-02-10 11:22:00.000') and
        // datetime('2017-02-12 11:22:00.000') order by column;
        String sql = "select * from schedule where date between ";
        String startdate = "datetime('" + start.getDate() + "') and ";
        String enddate = "datetime('" + end.getDate() + "') ";
        String orderby = "order by date;";
        return manager.executeQuery(DBManager.Dbctrl.SelectTbl, sql + startdate + enddate + orderby);
    }





}
