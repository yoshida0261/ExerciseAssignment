package com.company.stah;

public class ScheduleManager {

    private int max;

    public void setDebugMode(){
        // logger をdebugレベルに設定
    }

    public ScheduleManager(int max){

    }

    public void setSchedule(Date date, Event event)
    {
        //event数がmaxを超えたらエラー
    }

    public String findEvent(Date start, Date end)
    {
        //登録されたeventを全て取得

        //範囲内に絞込

        // jsonに整形して返す
        return null;
    }
}
