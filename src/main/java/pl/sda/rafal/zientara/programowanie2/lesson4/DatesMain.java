package pl.sda.rafal.zientara.programowanie2.lesson4;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class DatesMain {
    public static void main(String[] args) {

        System.out.println(dateNow());
        fridaysFromNow(7);


    }




    private static  void fridaysFromNow(int count) {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Piateczki nadchodze. Juz niedlugo:");
        int fridaysCount = 0;
        while (fridaysCount < count) {
            DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
            if (dayOfWeek != DayOfWeek.FRIDAY) {
                currentDate = currentDate.plusDays(1);
            } else {
                System.out.println(currentDate);
                currentDate = currentDate.plusWeeks(1);
                fridaysCount++;
            }
        }
    }


    private static void input(){
        String input = "12-02-2020";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(input,formatter);
        System.out.println(date);
        System.out.println(date.format(formatter));
        System.out.println(LocalDate.now().plusDays(1).format(formatter));



    }

    private static String dateNow(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.now();
        return localDate.format(formatter);
    }

    private static void firstPart_ByRafa(){
        LocalDate localDate = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        ZonedDateTime.now();
        System.out.println(localDate);
        System.out.println(dateTime);
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime.withZoneSameInstant(ZoneId.of("Canada/Atlantic")));

        Set<String> allZones = ZoneId.getAvailableZoneIds();
        for(String zone: allZones) {
            System.out.println(zone);
        }
    }

}
