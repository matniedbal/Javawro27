package pl.sda.rafal.zientara.programowanie2.lesson4.money;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public abstract class DateListener implements KeyListener {

    private static final List<DateTimeFormatter> FORMATS = Arrays.asList(
            DateTimeFormatter.ofPattern("dd-MM-yyyy"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("dd MM yyyy"),
            DateTimeFormatter.ofPattern("yyyy MM dd"),
            DateTimeFormatter.ofPattern("ddMMyyyy"),
            DateTimeFormatter.ofPattern("yyyyMMdd"),
            DateTimeFormatter.ofPattern("dd,MM,yyyy"),
            DateTimeFormatter.ofPattern("yyyy,MM,dd"),
            DateTimeFormatter.ofPattern("dd.MM.yyyy"),
            DateTimeFormatter.ofPattern("yyyy.MM.dd"));

    private final JTextField field;

    DateListener(JTextField field) {
        this.field = field;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
        String input = field.getText();
        LocalDate date = parseDate(input);
        onDateUpdate(date);
    }

    public abstract void onDateUpdate(LocalDate date);

    private LocalDate parseDate(String input) {
        for(DateTimeFormatter el: FORMATS){
            try{
                return LocalDate.parse(input,el);
            }catch(Exception ignored){
            }
        }
        return null;

    }


}