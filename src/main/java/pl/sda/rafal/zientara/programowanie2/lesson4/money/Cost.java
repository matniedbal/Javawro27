package pl.sda.rafal.zientara.programowanie2.lesson4.money;

import java.time.LocalDate;

public class Cost {
    private final String shopName;
    private final LocalDate date;
    private final double price;

    public Cost(String shopName, LocalDate date, double price) {
        this.shopName = shopName;
        this.date = date;
        this.price = price;
    }
}
