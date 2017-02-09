package com.company.stah;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        CommandParser cmd = new CommandParser();
        cmd.parser(args);
        ScheduleManager manager = new ScheduleManager(cmd.getMax());

        if(cmd.isSet()){
            manager.setSchedule(cmd.getDate(), cmd.getEvent());
        }
        if(cmd.isFind()){
            String event = manager.findEvent(cmd.getStart(), cmd.getEnd());
            System.out.println(event);
        }
    }


}
