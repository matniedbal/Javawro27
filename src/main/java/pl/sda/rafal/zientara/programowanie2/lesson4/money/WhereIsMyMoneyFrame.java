package pl.sda.rafal.zientara.programowanie2.lesson4.money;

import javax.swing.*;
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

        presenter.initData();
    }


    private  JTextField shopInput (){
        shopInput = new JTextField();
        shopInput.setBounds(50,50,300,50);
        return shopInput;
    }

    private  JTextField dateFrom (){
        dateFrom = new JTextField();
        dateFrom.setBounds(50,125,130,50);
        return dateFrom;
    }

    private  JTextField dateTo (){
        dateTo = new JTextField();
        dateTo.setBounds(220,125,130,50);
        return dateTo;
    }

    private  JTextField costFrom (){
        costFrom = new JTextField();
        costFrom.setBounds(50,200,130,50);
        return costFrom;
    }

    private  JTextField costTo (){
        costTo = new JTextField();
        costTo.setBounds(220,200,130,50);
        return costTo;
    }

    private  JList result (){
        result = new JList();
        result.setBounds (50,275,500,250);
        return result;
    }

    @Override
    public void refreshList(List<Cost> data) {
        //TODO
        DefaultListModel<Cost> list = new DefaultListModel<>();
        for(Cost cost : data) {
            list.addElement(cost);
        }
        result.setModel(list);
    }


}
