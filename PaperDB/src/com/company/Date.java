package com.company;

public class Date {
    int year;
    int month;
    int day;

    public static Date create(int year, int month, int day){
        Date d= new Date();
        d.day=day;
        d.month=month;
        d.year=year;
        return d;
    }
}