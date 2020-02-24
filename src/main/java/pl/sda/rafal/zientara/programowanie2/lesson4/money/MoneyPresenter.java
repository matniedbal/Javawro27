package pl.sda.rafal.zientara.programowanie2.lesson4.money;

import javax.annotation.processing.Filer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MoneyPresenter implements
        MoneyContract.Presenter {

    private final MoneyContract.View view;

    public MoneyPresenter(MoneyContract.View view) {
        this.view = view;
    }

    @Override
    public void initData() {
        //TODO

        List<Cost> costs = new LinkedList<>();
        File file = new File("C:\\Users\\matni\\IdeaProjects\\Javawro27\\src\\main\\resources\\zakupy.csv");

        try {
            FileReader reader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);
            String row = buffer.readLine();
            boolean firstIgnored = false;
            while(row != null){
                if(!firstIgnored){
                    firstIgnored = true;
                }
                else {
                    Cost cost = parseCost(row);
                    costs.add(cost);
                }
                row = buffer.readLine();

            }
            //TODO Czytamuy linijka po linijce
        } catch (IOException e) {
            e.printStackTrace();
        }
        view.refreshList(costs);

    }

    private Cost parseCost(String row) {
        String shopName = row.split(";")[0];
        double price = Double.parseDouble(row.split(";")[1].replace(",",".").replace("\"",""));
        String input = row.split(";")[2];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(input,formatter);
        return new Cost(shopName,date,price);
    }

    @Override
    public void onWordChange(String word) {
        //TODO

    }
}
