package pl.sda.rafal.zientara.programowanie2.lesson4.money;

import java.time.LocalDate;
import java.util.List;

public class MoneyContract {

    public interface View{
        void refreshList(List<Cost> date);

    }

    public interface Presenter {
        void prepareData();
        void initData();

        void onWordChange(String word);
        void onFromPrice(double price);
        void onToPrice(double price);
        void onFromDate(LocalDate fromDate);
        void onToDate(LocalDate fromDate);
        List<Cost> getLastResult();
    }
}
