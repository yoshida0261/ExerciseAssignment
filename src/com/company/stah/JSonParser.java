package com.company.stah;

import com.company.stah.model.ScheduleJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JSonParser {

    public String SchedulePrinter(ScheduleJson json){
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String output = null;
        try {
            output = mapper.writeValueAsString(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(output);

        return output;
    }
}
