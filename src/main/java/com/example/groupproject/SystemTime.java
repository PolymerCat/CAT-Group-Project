package com.example.groupproject;
import java.time.LocalDate;
public class SystemTime {

    LocalDate currentDate = LocalDate.now();

    String getDay(){
        String day = String.valueOf(currentDate.getDayOfWeek());
        day = day.substring(0, 1).toUpperCase() + day.substring(1).toLowerCase();
        //System.out.println(day);
        return day;
    }
    String getMonth(){
        String date = String.valueOf(currentDate.getMonth());
        date = date.substring(0, 1).toUpperCase() + date.substring(1).toLowerCase();
        return date;
    }
    String getDate(){
        return String.valueOf(currentDate.getDayOfMonth());
    }
    String getYear(){
        return String.valueOf(currentDate.getYear());
    }
}
