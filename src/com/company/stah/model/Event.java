package com.company.stah.model;

public class Event {
    private String event;

    public  Event(String event)
    {
        this.event = event;
    }

    @Override
    public String toString(){
        return this.event;
    }

    public String getEvent()
    {
        return event;
    }

    public void Validate()
    {
        // 256文字以下

        // 全角であるか
    }
}
