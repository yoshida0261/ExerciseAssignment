package com.company.stah.dao;

import com.company.stah.DBManager;
import com.company.stah.model.Date;
import com.company.stah.model.Event;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class ScheduleSQLite extends ScheduleDao {
    private DBManager manager = null;
    public ScheduleSQLite(){
        manager = new DBManager();
        manager.setConnect("todo");

    }

    @Override
    public void createSchedule(Date date, Event event) {

    }



    @Override
    public Map<Date, Event> findEvent(Date start, Date end) {



        return null;
    }

    public void selectFrom(Connection connection, String sql){
        Statement statement = null;
        try{
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            ResultSet rs = statement.executeQuery(sql);
            manager.printDBTable(rs);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println(e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

}
