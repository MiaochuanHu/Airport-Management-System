package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author limingxia
 * @Description DateUtils
 * @date 2022/11/27-15:49
 */
public class DateUtils {

    public static final String DATE_FORMAT = "MM/dd/yyyy";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm"; // 2022-12-06 00:00
    public static final String DATE_TIME_FORMAT = "yyyyMMddHHmmss";
    public static final String DATETIME_TIME_FORMAT = "yyyyMMddHHmm";

    public static String getCurrentDate() {
        String dateStr = null;
        SimpleDateFormat df = new SimpleDateFormat(DateUtils.DATE_FORMAT);
        dateStr = df.format(new Date());

        return dateStr;
    }

    public static String getCurrentDateTime() {
        String dateStr = null;
        SimpleDateFormat df = new SimpleDateFormat(DateUtils.DATE_TIME_FORMAT);
        dateStr = df.format(new Date());

        return dateStr;
    }

    public static String getCurrentDateTime(String dateFormat) {
        String dateStr = null;
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        dateStr = df.format(new Date());

        return dateStr;
    }

    public static String dateToString(Date date) {
        String dateStr = null;
        SimpleDateFormat df = new SimpleDateFormat(DateUtils.DATE_FORMAT);
        dateStr = df.format(date);

        return dateStr;
    }

    public static String datetimeToString(Date date) {
        String dateStr = null;
        SimpleDateFormat df = new SimpleDateFormat(DateUtils.DATETIME_FORMAT);
        dateStr = df.format(date);

        return dateStr;
    }

    public static Date stringToDate(String dateStr) {
        Date date = null;
        SimpleDateFormat df = new SimpleDateFormat(DateUtils.DATE_FORMAT);
        try {
            date = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public static Date stringToDatetime(String dateStr) {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat(DateUtils.DATETIME_FORMAT);
        try {
            date = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public static java.sql.Date stringToSqlDate(String dateStr) {
        Date date = new Date();

        SimpleDateFormat df = new SimpleDateFormat(DateUtils.DATE_FORMAT);
        try {
            date = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new java.sql.Date(date.getTime());
    }

    public static int getWeekOfDate(Date date) {
        int wd = 0;
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        wd = cd.get(Calendar.DAY_OF_WEEK) - 1;

        return wd;
    }

    public static Date addHour(Date date, int i) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR_OF_DAY, i);
        Date newDate = c.getTime();
        return newDate;
    }

    public static Date addDay(Date date, int day) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        cd.add(Calendar.DAY_OF_MONTH, day);

        return cd.getTime();
    }

    public static Date addMonth(Date date, int month) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        cd.add(Calendar.MONTH, month);

        return cd.getTime();
    }

    public static Date addYear(Date date, int year) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        cd.add(Calendar.YEAR, year);

        return cd.getTime();
    }

    public static String getSerialDate() {
        String dateStr = null;
        SimpleDateFormat df = new SimpleDateFormat(DateUtils.DATE_TIME_FORMAT);
        dateStr = df.format(new Date());

        return dateStr;
    }

    public static String getSerialDateTime() {
        String dateStr = null;
        SimpleDateFormat df = new SimpleDateFormat(DateUtils.DATETIME_TIME_FORMAT);
        dateStr = df.format(new Date());
        return dateStr;
    }

    public static String getBoardingTime(String departTime) {
        Date departDate = stringToDatetime(departTime);
        Date boardingtime = addHour(departDate, -1);

        return datetimeToString(boardingtime);
    }
}
