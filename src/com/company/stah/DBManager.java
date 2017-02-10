package com.company.stah;

import java.sql.*;

public class DBManager {

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


    public void printDBTable(ResultSet rs) throws SQLException
    {
        ResultSetMetaData rsmd = rs.getMetaData();
        while (rs.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.print(rs.getString(i));
                System.out.print(i < rsmd.getColumnCount() ? "," : "");
            }
            System.out.print(System.getProperty("line.separator"));
        }
    }

    // curd

}
