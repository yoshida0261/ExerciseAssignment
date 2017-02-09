package com.company.stah;

import java.util.Date;

public class DateYYYYMMDDhhmm {
    private String yyyymmddhhmm;

    public DateYYYYMMDDhhmm(String date){
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
