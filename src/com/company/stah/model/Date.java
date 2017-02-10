package com.company.stah.model;


public class Date {
    private String yyyymmddhhmm;

    public Date(String date){
        yyyymmddhhmm = date;

    }

    @Override
    public String toString(){
        return this.yyyymmddhhmm;
    }


    public String getDate()
    {
        StringBuilder sb1 = new StringBuilder(yyyymmddhhmm);
        sb1.append(":00.000");
        sb1.insert(10, ':');
        sb1.insert(8, ' ');
        sb1.insert(6, '-');
        sb1.insert(4, '-');
        return sb1.toString();
    }

    public boolean Validate(){

        // dateで変換がおかしいなど。

        return  false;
    }


}
