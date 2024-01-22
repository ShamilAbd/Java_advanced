package com.shamilabd.basics;

import com.shamilabd.elementary.Utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import static com.shamilabd.elementary.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 22.04.2023
 */
public class DateAndTime {
    public static void main(String[] args) {
//        simpleTest();
//        createTest();
//        dateTimeMethods();
//        comparingTest();
//        periodTest();
//        durationTest();
//        getTest();
        formatTest();
    }

    public static void formatTest() {
        LocalDateTime date = LocalDateTime.of(2023, Month.JANUARY,5,12,15,8);
        DateTimeFormatter dtf;
        System.out.println(date);
        Utils.line();

        dtf = DateTimeFormatter.BASIC_ISO_DATE;
        System.out.println(date.format(dtf));
        Utils.line();
        dtf = DateTimeFormatter.ISO_LOCAL_DATE;
        System.out.println(date.format(dtf));
        Utils.line();
        dtf = DateTimeFormatter.ISO_DATE; // default
        System.out.println(date.format(dtf));
        Utils.line();
        dtf = DateTimeFormatter.ISO_LOCAL_TIME;
        System.out.println(date.format(dtf));
        Utils.line();
        dtf = DateTimeFormatter.ISO_TIME;
        System.out.println(date.format(dtf));
        Utils.line();
        dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        System.out.println(date.format(dtf));
        Utils.line();
        dtf = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println(date.format(dtf));
        Utils.line();
        dtf = DateTimeFormatter.ISO_ORDINAL_DATE;
        System.out.println(date.format(dtf));
        Utils.line();
        dtf = DateTimeFormatter.ISO_WEEK_DATE;
        System.out.println(date.format(dtf));
        Utils.line();

        /* Unsupported
        dtf = DateTimeFormatter.ISO_OFFSET_DATE;
        System.out.println(date.format(dtf));
        line();
        dtf = DateTimeFormatter.ISO_OFFSET_TIME;
        System.out.println(date.format(dtf));
        line();
        dtf = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        System.out.println(date.format(dtf));
        line();
        dtf = DateTimeFormatter.ISO_ZONED_DATE_TIME;
        System.out.println(date.format(dtf));
        line();
        dtf = DateTimeFormatter.ISO_INSTANT;
        System.out.println(date.format(dtf));
        line();
        dtf = DateTimeFormatter.RFC_1123_DATE_TIME;
        System.out.println(date.format(dtf));
        line();*/

        dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(date.format(dtf));
        Utils.line();

        dtf = DateTimeFormatter.ofPattern("YYYY.MM.dd, hh:mm:ss"); // My format
        System.out.println(date.format(dtf));
        Utils.line();

        dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd"); // My format
        LocalDate ld1 = LocalDate.parse("2023.01.05", dtf);
        System.out.println(ld1);
        Utils.line();

        LocalDate ld2 = LocalDate.parse("2023-01-05"); // standard format
        System.out.println(ld2);
        line();
    }

    public static void getTest() {
        LocalDateTime date = LocalDateTime.of(2023, Month.JANUARY,5,12,15,8);
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.getDayOfYear());
        line();
        date = LocalDateTime.of(1991, Month.AUGUST,7,12,15,8);
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.getDayOfYear());
        line();
        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getHour());
        System.out.println(date.getMinute());
        System.out.println(date.getSecond());
        System.out.println(date.getNano());
        System.out.println(date.getChronology());
        System.out.println(date.getMonthValue());
        System.out.println(date.getLong(ChronoField.HOUR_OF_DAY));
        line();
    }

    public static void durationTest() {
        LocalDateTime date = LocalDateTime.of(1991, Month.AUGUST,7,12,15,8);
        System.out.println("Так выглядят длительности:");
        Duration dur1 = Duration.of(2, ChronoUnit.NANOS);
        System.out.println(dur1);
        Duration dur2 = Duration.ofDays(1);
        System.out.println(dur2);
        Duration dur3 = Duration.ofHours(2);
        System.out.println(dur3);
        Duration dur4 = Duration.ofMinutes(30);
        System.out.println(dur4);
        Duration dur5 = Duration.ofSeconds(45);
        System.out.println(dur5);
        Duration dur6 = Duration.ofMillis(999);
        System.out.println(dur6);
        Duration dur7 = Duration.ofNanos(500999555);
        System.out.println(dur7);
        line();
        line();

        System.out.println("Start from:");
        System.out.println(date);
        line();
        System.out.println("add dur1:");
        System.out.println(date.plus(dur1));
        line();
        System.out.println("add dur2:");
        System.out.println(date.plus(dur2));
        line();
        System.out.println("add dur3:");
        System.out.println(date.plus(dur3));
        line();
        System.out.println("add dur4:");
        System.out.println(date.plus(dur4));
        line();
        System.out.println("add dur5:");
        System.out.println(date.plus(dur5));
        line();
        System.out.println("add dur6:");
        System.out.println(date.plus(dur6));
        line();
        System.out.println("add dur7:");
        System.out.println(date.plus(dur7));
        line();
        line();

        System.out.println("subtract dur1:");
        System.out.println(date.minus(dur1));
        line();
        System.out.println("subtract dur2:");
        System.out.println(date.minus(dur2));
        line();
        System.out.println("subtract dur3:");
        System.out.println(date.minus(dur3));
        line();
        System.out.println("subtract dur4:");
        System.out.println(date.minus(dur4));
        line();
        System.out.println("subtract dur5:");
        System.out.println(date.minus(dur5));
        line();
        System.out.println("subtract dur6:");
        System.out.println(date.minus(dur6));
        line();
        System.out.println("subtract dur7:");
        System.out.println(date.minus(dur7));
        line();
    }

    public static void periodTest() {
        LocalDateTime date = LocalDateTime.of(1991, Month.AUGUST,7,12,15,8);
        System.out.println("Так выглядят периоды:");
        Period somePeriod1 = Period.of(2,5,3); // private constructor
        System.out.println(somePeriod1);
        Period somePeriod2 = Period.ofDays(5);
        System.out.println(somePeriod2);
        Period somePeriod3 = Period.ofWeeks(3);
        System.out.println(somePeriod3);
        Period somePeriod4 = Period.ofMonths(4);
        System.out.println(somePeriod4);
        Period somePeriod5 = Period.ofYears(2);
        System.out.println(somePeriod5);

        System.out.println("Start from:");
        System.out.println(date);
        line();
        System.out.println("add somePeriod1:");
        System.out.println(date.plus(somePeriod1));
        line();
        System.out.println("add somePeriod2:");
        System.out.println(date.plus(somePeriod2));
        line();
        System.out.println("add somePeriod3:");
        System.out.println(date.plus(somePeriod3));
        line();
        System.out.println("add somePeriod4:");
        System.out.println(date.plus(somePeriod4));
        line();
        System.out.println("add somePeriod5:");
        System.out.println(date.plus(somePeriod5));
        line();
        line();
        System.out.println("subtract somePeriod1:");
        System.out.println(date.minus(somePeriod1));
        line();
        System.out.println("subtract somePeriod2:");
        System.out.println(date.minus(somePeriod2));
        line();
        System.out.println("subtract somePeriod3:");
        System.out.println(date.minus(somePeriod3));
        line();
        System.out.println("subtract somePeriod4:");
        System.out.println(date.minus(somePeriod4));
        line();
        System.out.println("subtract somePeriod5:");
        System.out.println(date.minus(somePeriod5));
        line();
    }

    public static void comparingTest() {
        LocalDateTime date1 = LocalDateTime.of(1991, Month.AUGUST,7,12,15,8);
        LocalDateTime date2 = LocalDateTime.of(1991, Month.AUGUST,7,12,15,8);
        System.out.println("If dates equals:");
        System.out.println("date1 is before date2? " + date1.isBefore(date2));
        System.out.println("date1 is after date2? " + date1.isAfter(date2));
        System.out.println("date1 == date2? " + (date1 == date2));
        System.out.println("date1 equals date2? " + (date1.equals(date2)));
        line();
        // change date2
        date2 = LocalDateTime.of(2005, Month.AUGUST,17,5,4,8);
        System.out.println("If dates NOT equals:");
        System.out.println("date1 is before date2? " + date1.isBefore(date2));
        System.out.println("date1 is after date2? " + date1.isAfter(date2));
        System.out.println("date1 == date2? " + (date1 == date2));
        System.out.println("date1 equals date2? " + (date1.equals(date2)));
        line();
        // again change date2
        date2 = LocalDateTime.of(1885, Month.AUGUST,17,5,4,8);
        System.out.println("If dates NOT equals:");
        System.out.println("date1 is before date2? " + date1.isBefore(date2));
        System.out.println("date1 is after date2? " + date1.isAfter(date2));
        System.out.println("date1 == date2? " + (date1 == date2));
        System.out.println("date1 equals date2? " + (date1.equals(date2)));
        line();
    }

    public static void dateTimeMethods() {
        // Для LocalDateTime и LocalDate
        LocalDateTime myBirthday = LocalDateTime.of(1991, Month.AUGUST,7,12,15,8,314159265); // :-) find Easter Egg
        System.out.println("Исходная дата:");
        System.out.println(myBirthday);
        line();
        myBirthday = myBirthday.plusDays(10);
        System.out.println("Добавили 10 дней:");
        System.out.println(myBirthday);
        line();
        myBirthday = myBirthday.minusDays(10);
        System.out.println("Убавили 10 дней:");
        System.out.println(myBirthday);
        line();
        myBirthday = myBirthday.plusWeeks(10);
        System.out.println("Добавили 10 недель:");
        System.out.println(myBirthday);
        line();
        myBirthday = myBirthday.minusWeeks(10);
        System.out.println("Убавили 10 недель:");
        System.out.println(myBirthday);
        line();
        myBirthday = myBirthday.plusMonths(10);
        System.out.println("Добавили 10 месяцев:");
        System.out.println(myBirthday);
        line();
        myBirthday = myBirthday.minusMonths(10);
        System.out.println("Убавили 10 месяцев:");
        System.out.println(myBirthday);
        line();
        myBirthday = myBirthday.plusYears(10);
        System.out.println("Добавили 10 лет:");
        System.out.println(myBirthday);
        line();
        myBirthday = myBirthday.minusYears(10);
        System.out.println("Убавили 10 лет:");
        System.out.println(myBirthday);
        line();
        line();

        // Для LocalDateTime и LocalTime
        myBirthday = myBirthday.plusHours(10);
        System.out.println("Добавили 10 часов:");
        System.out.println(myBirthday);
        line();
        myBirthday = myBirthday.minusHours(10);
        System.out.println("Убавили 10 часов:");
        System.out.println(myBirthday);
        line();
        myBirthday = myBirthday.plusMinutes(10);
        System.out.println("Добавили 10 минут:");
        System.out.println(myBirthday);
        line();
        myBirthday = myBirthday.minusMinutes(10);
        System.out.println("Убавили 10 минут:");
        System.out.println(myBirthday);
        line();
        myBirthday = myBirthday.plusSeconds(10);
        System.out.println("Добавили 10 секунд:");
        System.out.println(myBirthday);
        line();
        myBirthday = myBirthday.minusSeconds(10);
        System.out.println("Убавили 10 секунд:");
        System.out.println(myBirthday);
        line();
        myBirthday = myBirthday.plusNanos(10);
        System.out.println("Добавили 10 наносекунд:");
        System.out.println(myBirthday);
        line();
        myBirthday = myBirthday.minusNanos(10);
        System.out.println("Убавили 10 наносекунд:");
        System.out.println(myBirthday);
        line();
    }

    public static void createTest() {
        LocalDate today = LocalDate.now(); // they have private constructor
        LocalTime nowTime = LocalTime.now();
        LocalDateTime todayAndNow = LocalDateTime.now();
        System.out.println(today);
        System.out.println(nowTime);
        System.out.println(todayAndNow);
        line();
        LocalDate someDay = LocalDate.of(2023, 7, 13);
//        someTime = LocalTime.of(235, 22, 59);//DateTimeException
        LocalTime someTime = LocalTime.of(15, 22, 59);
        LocalDateTime someDayAndNow = LocalDateTime.of(2025, Month.AUGUST,7,12,15,8,6);
        System.out.println(someDay);
        System.out.println(someTime);
        System.out.println(someDayAndNow);
        line();
    }

    public static void simpleTest() {
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
    }
}
