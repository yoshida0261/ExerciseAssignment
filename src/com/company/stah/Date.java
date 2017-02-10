package com.company.stah;

import java.util.Date;

public class Date {
    private String yyyymmddhhmm;

    public Date(String date){
        yyyymmddhhmm = date;
    }

    public String getDate()
    {
        return yyyymmddhhmm;
    }

    public boolean Validate(){

        // dateで変換がおかしいなど。

        return  false;
    }


}
