package pl.sda.rafal.zientara.programowanie2.lesson4.money;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.util.List;

public class WhereIsMyMoneyFrame implements MoneyContract.View{

    private JFrame frame;
    private JTextField shopInput;
    private JTextField dateTo;
    private JTextField dateFrom;
    private JTextField costTo;
    private JTextField costFrom;
    private JList result;

    private MoneyContract.Presenter presenter = new MoneyPresenter(this );

    WhereIsMyMoneyFrame() {
        frame();
    }

    private void frame(){
        frame = new JFrame();
        frame.setSize(700,600);
        frame.setResizable(false);
        frame.setTitle("WHERE IS MY MONEY !!!");

        frame.add(shopInput());
        frame.add(dateFrom());
        frame.add(dateTo());
        frame.add(costFrom());
        frame.add(costTo());
        frame.add(result());
        frame.setLayout(null);
        frame.setVisible(true);

        presenter.prepareData();
        presenter.initData();
    }


    private  JTextField shopInput (){
        shopInput = new JTextField();
        JLabel lab = new JLabel();
        lab.setBounds(50,20,300,30);
        lab.setText("Name:");
        frame.add(lab);
        shopInput.setBounds(50,50,300,50);
        shopInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                presenter.onWordChange(shopInput.getText());
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        return shopInput;
    }

    private  JTextField dateFrom (){
        dateFrom = new JTextField();
        JLabel lab = new JLabel();
        lab.setBounds(50,100,130,30);
        lab.setText("Date from:");
        frame.add(lab);
        dateFrom.addKeyListener(new DateListener(dateFrom) {
            @Override
            public void onDateUpdate(LocalDate date) {
                presenter.onFromDate(date);
            }
        });
        dateFrom.setBounds(50,125,130,50);
        return dateFrom;
    }

    private  JTextField dateTo (){
        dateTo = new JTextField();
        JLabel lab = new JLabel();
        lab.setBounds(220,100,130,30);
        lab.setText("Date to:");
        frame.add(lab);
        dateTo.addKeyListener(new DateListener(dateTo) {
            @Override
            public void onDateUpdate(LocalDate date) {
                presenter.onToDate(date);
            }
        });
        dateTo.setBounds(220,125,130,50);
        return dateTo;
    }

    private  JTextField costFrom (){
        costFrom = new JTextField();
        JLabel lab = new JLabel();
        lab.setBounds(50,175,130,30);
        lab.setText("Cost from:");
        frame.add(lab);
        costFrom.addKeyListener(new DoubleListener(costFrom) {
            @Override
            public void onDoubleUpdate(Double doubleNum) {
                presenter.onFromPrice(doubleNum);
            }
        });
        costFrom.setBounds(50,200,130,50);
        return costFrom;
    }

    private  JTextField costTo (){
        costTo = new JTextField();
        JLabel lab = new JLabel();
        lab.setBounds(220,175,130,30);
        lab.setText("Cost to:");
        frame.add(lab);
        costTo.addKeyListener(new DoubleListener(costTo) {
            @Override
            public void onDoubleUpdate(Double doubleNum) {
                presenter.onToPrice(doubleNum);
            }
        });
        costTo.setBounds(220,200,130,50);
        return costTo;
    }

    private  JList result (){
        result = new JList();
        result.setBounds (50,275,600,250);
        return result;
    }

    @Override
    public void refreshList(List<Cost> data) {
        //TODO
        DefaultListModel<String> list = new DefaultListModel<>();
        for(Cost cost : data) {
            list.addElement(cost.toString());
        }
        result.setModel(list);
    }

}
