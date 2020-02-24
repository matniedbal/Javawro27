package pl.sda.rafal.zientara.programowanie2.lesson4.money;

import java.util.List;

public class MoneyContract {

    public interface View{
        void refreshList(List<Cost> date);

    }

    public interface Presenter {
        void initData();
        void onWordChange(String word);

    }
}
