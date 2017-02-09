package com.company.stah;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.ArrayList;

public class Debug {
    private static void debugSqlite()
    {

    }


    private static void debugJackson(){
        ScheduleJson hoge = new ScheduleJson();
        hoge.id = 10;
        hoge.name = "Hoge";
        hoge.list = new ArrayList();
        String str[] = new String[2];
        str[0] = "aaa";
        str[1] = "bbb";
        String str2[] = new String[2];
        str2[0] = "aaa2";
        str2[1] = "bbb2";

        hoge.list.add(str);
        hoge.list.add(str2);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String json = null;
        try {
            json = mapper.writeValueAsString(hoge);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(json);

    }

}
