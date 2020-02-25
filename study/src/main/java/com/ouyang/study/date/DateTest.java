package com.ouyang.study.date;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ouyangxu
 * @Date: 2019年07月13日 下午 03:20
 */
public class DateTest {
    @Test
    public void test () {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(sf.format(1561709185000L));
    }

    @Test
    public void test2 () throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sf.parse("20190131"));
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        System.out.println(sf.format(calendar.getTime()));
    }

    @Test
    public void test3 () {
        long time = System.currentTimeMillis();
        System.out.println(time);

        time = time / 1000 * 1000;
        System.out.println(time);

        time += 999;
        System.out.println(time);

    }

    @Test
    public void test4() throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sf.parse("2019-01-01");
        System.out.println(date);
        System.out.println(date.getTime());
    }

    @Test
    public void test5() {
        Date date = new Date(1420041600000L);
        System.out.println(date);
    }

    @Test
    public void test6() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println(sf.format(calendar.getTime()));
    }

    @Test
    public void test7() {
        String[] hour = {"zero", "one", "two", "three", "four", "fives", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "twentyOne", "twentyTwo", "twentyThree"};
        String day = "day";
        String bg = "Bg";
        String ed = "Ed";
        Map<String, Date> hourMap = new HashMap<>();

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        hourMap.put(day + bg, calendar.getTime());
        for (int i = 0; i < hour.length; i++) {
            hourMap.put(hour[i] + bg, calendar.getTime());
            calendar.add(Calendar.HOUR_OF_DAY, 1);
            hourMap.put(hour[i] + ed, calendar.getTime());
        }
        hourMap.put(day + ed, calendar.getTime());

        System.out.println(JSON.toJSONString(hourMap));
    }

    @Test
    public void test8() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_MONTH, 1);
        calendar.set(Calendar.DAY_OF_WEEK, 2);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        System.out.println(sf.format(calendar.getTime()));
    }

    @Test
    public void test9() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getActualMaximum(Calendar.DAY_OF_WEEK));
        calendar.add(Calendar.DAY_OF_WEEK, 1);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.add(Calendar.DATE, 1);
        calendar.add(Calendar.MILLISECOND, -1);

        System.out.println(sf.format(calendar.getTime()));
    }

    @Test
    public void test10() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(sf.format(new Date(1569925980495L)));
    }

    @Test
    public void test11() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Calendar calendar = Calendar.getInstance();
        System.out.println(sf.format(calendar.getTime()));
    }
}
