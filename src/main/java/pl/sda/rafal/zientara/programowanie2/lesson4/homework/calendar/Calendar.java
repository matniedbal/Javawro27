package pl.sda.rafal.zientara.programowanie2.lesson4.homework.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

class Calendar {

    private static final String ANSI_RESET = "\u001B[0m";

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";

    private DayOfWeek dayToSign;

    private LocalDate firstDayOfMonth_Date;

    Calendar(DayOfWeek dayToSign) {
        this.dayToSign = dayToSign;
    }

    void calendar(int month, int year) {
        firstDayOfMonth_Date = LocalDate.of(year,month,1);
        System.out.println("CALENDAR FOR MONTH: \n"+ANSI_YELLOW+firstDayOfMonth_Date.getMonth()+" "+year+ANSI_RESET);
        printMonth();
        System.out.println();
    }

    void calendar(int year){
        System.out.println("CALENDAR FOR YEAR: \n"+ANSI_RED+year+ANSI_RESET);
        for(int i = 1; i <=12; i++) {
            System.out.println(ANSI_YELLOW+ Month.of(i) +ANSI_RESET);
            firstDayOfMonth_Date = LocalDate.of(year, i, 1);
            printMonth();
            System.out.println();
        }
        System.out.println();
    }



    private void printMonth(){

        LocalDate currentDay = firstDayOfMonth_Date;
        signedDay();

        for(int i = 0; i < firstDayOfMonth_Date.getDayOfWeek().getValue()-1; i++){
            System.out.print("   ");
        }
        while(currentDay.getMonth() == firstDayOfMonth_Date.getMonth()){
            if(currentDay.getDayOfWeek() == DayOfWeek.SUNDAY)
                System.out.print(ANSI_RED);
            if(currentDay.getDayOfWeek() == dayToSign)
                System.out.print(ANSI_GREEN);
            System.out.printf("%2d ",currentDay.getDayOfMonth());
            System.out.print(ANSI_RESET);

            if (currentDay.getDayOfWeek() == DayOfWeek.SUNDAY){
                System.out.println();
            }
            currentDay = currentDay.plusDays(1);
        }
        System.out.println();
    }

    private void signedDay(){
        switch (dayToSign){
            case MONDAY:
                System.out.println(ANSI_GREEN+"Mo"+ANSI_RESET+" Tu We Th Sa "+ANSI_RED+"Su"+ANSI_RESET);
                break;
            case TUESDAY:
                System.out.println("Mo "+ANSI_GREEN+"Tu"+ANSI_RESET+" We Th Fr Sa "+ANSI_RED+"Su"+ANSI_RESET);
                break;
            case WEDNESDAY:
                System.out.println("Mo Tu "+ANSI_GREEN+"We"+ANSI_RESET+" Th Fr Sa "+ANSI_RED+"Su"+ANSI_RESET);
                break;
            case THURSDAY:
                System.out.println("Mo Tu We "+ANSI_GREEN+"Th"+ANSI_RESET+" Fr Sa "+ANSI_RED+"Su"+ANSI_RESET);
                break;
            case FRIDAY:
                System.out.println("Mo Tu We Th "+ANSI_GREEN+"Fr"+ANSI_RESET+" Sa "+ANSI_RED+"Su"+ANSI_RESET);
                break;
            case SATURDAY:
                System.out.println("Mo Tu We Th Fr "+ANSI_GREEN+"Sa"+ANSI_RED+"Su"+ANSI_RESET);
                break;
            default:
                System.out.println("Mo Tu We Th Fr Sa "+ANSI_RED+"Su"+ANSI_RESET);
                break;

        }
    }



}
