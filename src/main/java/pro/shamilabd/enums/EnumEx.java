package pro.shamilabd.enums;

import java.util.Arrays;

import static pro.shamilabd.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 04.06.2023
 */
public class EnumEx {
    public static void main(String[] args) {
        badMethodParam(5);
        badMethodParam(50);
        badMethodParam('A');
//        goodMethodParam(5); // incompatible types
//        goodMethodParam(50);
//        goodMethodParam('A');
        goodMethodParam(WeekDays.FRIDAY); // OK
        line();

        Today today = new Today(WeekDays.WEDNESDAY);
        today.dayInfo();
        today = new Today(WeekDays.SATURDAY);
        today.dayInfo();

        WeekDays w1 = WeekDays.FRIDAY;
        WeekDays w2 = WeekDays.FRIDAY;
        WeekDays w3 = WeekDays.MONDAY;
        WeekDays2 w4 = WeekDays2.MONDAY;

        System.out.println(w1 == w2);
        System.out.println(w1 == w3);
//        System.out.println(w3 == w4); // incomparable types
        System.out.println(w3.equals(w4)); // false

        WeekDays monday = WeekDays.valueOf("MONDAY"); // для создания из строки.
        WeekDays[] weekDays = WeekDays.values();
        System.out.println(Arrays.toString(weekDays));
    }

    public static void badMethodParam(int weekDay) {
        System.out.println("badMethodParam: " + weekDay);
    }

    public static void goodMethodParam(WeekDays weekDay) {
        System.out.println("badMethodParam: " + weekDay);
    }
}

class Today {
    WeekDays weekDay;

    public Today(WeekDays weekDay) {
        this.weekDay = weekDay;
    }

    public void dayInfo() {
        switch (weekDay) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                System.out.println("Иди на работу! " + weekDay.getMood());
                break;
            case SUNDAY:
            case SATURDAY:
                System.out.println("Можно отдохнуть. " + weekDay.getMood());
                break;
            default:
                System.out.println("Какая-то ошибка. " + weekDay.getMood());
                break;
        }
    }
}

enum WeekDays {
    MONDAY(":-("),
    TUESDAY(":-("),
    WEDNESDAY(":-("),
    THURSDAY(":-|"),
    FRIDAY(":-)"),
    SATURDAY(":D"),
    SUNDAY(":-)");

    private String mood;

    private WeekDays(String mood) {
        this.mood = mood;
    }

    public String getMood() {
        return mood;
    }
}

// Один в один, для сравнения.
enum WeekDays2 {
    MONDAY(":-("),
    TUESDAY(":-("),
    WEDNESDAY(":-("),
    THURSDAY(":-|"),
    FRIDAY(":-)"),
    SATURDAY(":D"),
    SUNDAY(":-)");

    private String mood;

    private WeekDays2(String mood) {
        this.mood = mood;
    }

    public String getMood() {
        return mood;
    }
}
