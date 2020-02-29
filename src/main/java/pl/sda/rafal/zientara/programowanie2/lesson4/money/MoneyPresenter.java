package pl.sda.rafal.zientara.programowanie2.lesson4.money;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoneyPresenter implements
        MoneyContract.Presenter {

    private List<Cost> costs = new LinkedList<>();;
    private final MoneyContract.View view;
    private List<Cost> lastResult = new ArrayList<>();
    private String word;
    private double fromPrice;
    private double toPrice;
    private LocalDate fromDate;
    private LocalDate toDate;

    public MoneyPresenter(MoneyContract.View view) {
        this.view = view;
    }

    @Override
    public void prepareData() {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initData() {
        view.refreshList(costs);
    }

    private Cost parseCost(String row) {
        String shopName = row.split(";")[0];
        double price = Double.parseDouble(row.split(";")[1]
                .replace(",",".")
                .replace("\"",""));
        String input = row.split(";")[2];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(input,formatter);
        return new Cost(shopName,date,price);
    }

    @Override
    public void onWordChange(String word) {
        this.word = word;
        refreshAndShow();

    }

    @Override
    public void onToPrice(double toPrice) {
        this.toPrice = toPrice;
        refreshAndShow();
    }

    @Override
    public void onFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
        refreshAndShow();
    }

    @Override
    public void onToDate(LocalDate toDate) {
        this.toDate = toDate;
        refreshAndShow();
    }


    @Override
    public void onFromPrice(double fromPrice) {
        this.fromPrice = fromPrice;
        refreshAndShow();
    }



    private void refreshAndShow() {
        refreshResults();
        view.refreshList(lastResult);
    }

    private void refreshResults(){
        Stream<Cost> stream = costs.stream();
        if(word != null) {
                stream = stream.filter(cost -> cost.shopName.contains(word));
        }
        if(fromPrice > 0 ) {
            stream = stream.filter(cost -> cost.price >= fromPrice);
        }
        if(toPrice > 0 ) {
            stream = stream.filter(cost -> cost.price <= toPrice);
        }
        if(fromDate != null ) {
            stream = stream.filter(cost -> !cost.date.isBefore(this.fromDate));
        }
        if(toDate != null ) {
            stream = stream.filter(cost -> !cost.date.isAfter(this.toDate));
        }
        lastResult = stream.collect(Collectors.toList());
    }

    @Override
    public List<Cost> getLastResult() {
        return lastResult;
    }
}
