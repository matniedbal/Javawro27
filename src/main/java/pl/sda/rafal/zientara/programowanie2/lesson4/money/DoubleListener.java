package pl.sda.rafal.zientara.programowanie2.lesson4.money;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class DoubleListener implements KeyListener {

    private final JTextField field;

    DoubleListener(JTextField field) {
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
        try {
            Double doubleNum = Double.parseDouble(input);
            onDoubleUpdate(doubleNum);
        }catch(Exception ex){
            field.setText("");
        }
    }

    abstract void onDoubleUpdate(Double doubleNum);

}