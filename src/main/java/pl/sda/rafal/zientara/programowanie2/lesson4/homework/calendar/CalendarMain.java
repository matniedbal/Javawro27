package pl.sda.rafal.zientara.programowanie2.lesson4.homework.calendar;

import java.time.DayOfWeek;
import java.time.ZoneId;
import java.util.Set;

public class CalendarMain {
    public static void main(String[] args) {

        Calendar c = new Calendar(DayOfWeek.SATURDAY);
        c.calendar(2,2020);
        c.calendar(2020);

//        Set<String> availableZ = ZoneId.getAvailableZoneIds();
//        for(String zone: availableZ){
//            ZoneId z = ZoneId.of(zone);
//            System.out.println(z);
//        }

    }
}
