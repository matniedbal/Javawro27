package pl.sda.rafal.zientara.programowanie2.lesson4.money;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import sun.util.resources.cldr.nyn.CalendarData_nyn_UG;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

class MoneyPresenterTest {


    private  MoneyContract.Presenter presenter;
    private MoneyContract.View view;

    @BeforeEach
    public void setup(){
        view = Mockito.mock(MoneyContract.View.class);
        presenter = new MoneyPresenter(view);
        presenter.prepareData();
    }

    @Test
    public  void initPresenter(){
        presenter.initData();
        Mockito.verify(view).refreshList(any());
    }

    @Test
    public void whenQueryChangedRefreshResult(){
        List<Cost> expected = Arrays.asList(
                new Cost("test",
                        LocalDate.of(2020,1,1),
                        1));
        presenter.onWordChange("test");
        Mockito.verify(view,Mockito.times(1)).refreshList(expected);
    }

    @Test
    public void findAllZapkaz(){
        List<Cost> expected = Arrays.asList(
                new Cost("zabka", LocalDate.of(2020,1,16), 12),
                new Cost("zabka", LocalDate.of(2020,1,23), 53.23),
                new Cost("zabka", LocalDate.of(2020,1,16), 12),
                new Cost("zabka", LocalDate.of(2020,1,23), 700.01));
        presenter.onWordChange("zab");
        Mockito.verify(view).refreshList(expected);
    }


   @Test
    public void  findCostByNameAndPrice(){

        presenter.onWordChange("zab");
        presenter.onFromPrice(50.0);
        Mockito.verify(view, Mockito.times(2)).refreshList(any());

        List<Cost> lastResult = presenter.getLastResult();
        assertEquals(2,lastResult.size());
    }
    @Test

    public void  findCostFromTo(){

        presenter.onToPrice(200);
        presenter.onFromPrice(100.0);
        Mockito.verify(view, Mockito.times(2)).refreshList(any());

        List<Cost> lastResult = presenter.getLastResult();
        assertEquals(4,lastResult.size());
    }

    @Test
    public void  findCostFromDate(){

        presenter.onFromDate(LocalDate.of(2020,2,1));
        Mockito.verify(view, Mockito.times(1)).refreshList(any());

        List<Cost> lastResult = presenter.getLastResult();
        assertEquals(2,lastResult.size());
    }


    @Test
    public void  findCostFromToDate(){

        presenter.onFromDate(LocalDate.of(2020,1,16));
        presenter.onToDate(LocalDate.of(2020,2,1));
        Mockito.verify(view, Mockito.times(2)).refreshList(any());

        List<Cost> lastResult = presenter.getLastResult();
        assertEquals(8,lastResult.size());
    }


}