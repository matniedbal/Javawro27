package pl.sda.rafal.zientara.programowanie2.lesson4.money;

import java.time.LocalDate;
import java.util.Objects;

public class Cost {
    final String shopName;
    final LocalDate date;
    final double price;

    public Cost(String shopName, LocalDate date, double price) {
        this.shopName = shopName;
        this.date = date;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cost cost = (Cost) o;
        return Double.compare(cost.price, price) == 0 &&
                shopName.equals(cost.shopName) &&
                date.equals(cost.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopName, date, price);
    }

    @Override
    public String toString() {
        return "Cost:" +
                "Shop name:" + shopName +
                ", date:" + date +
                ", price:" + price +
                "zl";
    }
}
