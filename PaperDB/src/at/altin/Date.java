package at.altin;

/***
 * This class is used to create a date object.
 * It contains the year, month and day.
 * @author Altin
 * @version 1.0
 */
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