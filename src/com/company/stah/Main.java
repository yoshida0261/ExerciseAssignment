package com.company.stah;

public class Main {


    public static void main(String[] args) {


        CommandParser cmd = new CommandParser();
        cmd.Parser(args);

        DateYYYYMMDDhhmm date = new DateYYYYMMDDhhmm("201702140830");
        Event event = new Event("よろしく");


        // 予定設定　か予定検索で処理を分岐



        // 予定設定


        // dao を通して
    }


}
