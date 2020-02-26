package pl.sda.rafal.zientara.programowanie2.lesson4.homework.calendar;

import java.time.DayOfWeek;

public class CalendarMain {
    public static void main(String[] args) {

        Calendar c = new Calendar(DayOfWeek.THURSDAY);
        c.calendar(2,2020);
        c.calendar(2030);

    }
}
