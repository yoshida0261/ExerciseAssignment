package com.company.stah;

import com.company.stah.model.Date;
import com.company.stah.model.Event;
import com.company.stah.model.ScheduleJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.HashMap;

public class Debug {
    public static void debugSqlite()
    {

    }


    public static void debugJackson(){
        ScheduleJson hoge = new ScheduleJson();
        hoge.schedule = new HashMap<Date, Event>();
        hoge.schedule.put(new Date("201702100114"), new Event("aaa"));
        hoge.schedule.put(new Date("201702021115"), new Event("aac2"));

        JSonParser json = new JSonParser();
        json.SchedulePrinter(hoge);


    }

}
