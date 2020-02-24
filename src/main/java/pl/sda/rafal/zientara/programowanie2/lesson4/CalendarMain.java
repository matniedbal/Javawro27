package pl.sda.rafal.zientara.programowanie2.lesson4;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class CalendarMain {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();

        LocalDate firstDay = date.minusDays(date.getDayOfMonth()-1);

        LocalDate currentDay = firstDay;

        for(int i = 0 ; i < firstDay.getDayOfWeek().getValue()-1; i++){
                System.out.print("   ");
        }
        while(currentDay.getMonth() == date.getMonth()){
            System.out.printf("%2d ",currentDay.getDayOfMonth());

            if (currentDay.getDayOfWeek() == DayOfWeek.SUNDAY){
                System.out.println();
            }
            currentDay = currentDay.plusDays(1);
        }
        System.out.println();


    }
}
