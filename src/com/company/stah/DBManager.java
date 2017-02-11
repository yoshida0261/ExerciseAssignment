package com.company.stah;

import com.company.stah.model.*;
import com.company.stah.model.Date;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DBManager {

    public enum Dbctrl{
        Insert,
        SelectTbl,
    }

    private Connection connection = null;
    public Connection setConnect(String dbFilePath) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbFilePath);
            return connection;
        }catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            return  null;
        }catch (SQLException ex){
            System.out.println(ex.getErrorCode());
            return  null;
        }
    }

    public Map<Date, Event> executeQuery(Dbctrl dbctrl, String query){
        Statement statement = null;

        Map<Date, Event> map = null;
        try{
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            if(dbctrl == Dbctrl.Insert){
                statement.executeUpdate(query);
                ResultSet rs = statement.executeQuery("select * from schedule;");
                printDBTable(rs);

            }
            if(dbctrl == Dbctrl.SelectTbl){
                map = new HashMap<Date, Event>();

                ResultSet rs = statement.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();
                while (rs.next()) {
                    Date  date = new Date(rs.getString(1));
                    Event ev = new Event(rs.getString(2));
                    map.put(date, ev);
                }
            }

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
        return map;
    }


    public void printDBTable(ResultSet rs) throws SQLException
    {
        System.out.print(System.getProperty("line.separator"));
        System.out.println("print table ");
        ResultSetMetaData rsmd = rs.getMetaData();
        while (rs.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.print(rs.getString(i));
                System.out.print(i < rsmd.getColumnCount() ? "," : "");
            }
            System.out.print(System.getProperty("line.separator"));
        }
    }
}
