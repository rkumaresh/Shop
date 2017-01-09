package com.self.shopping;

import java.math.BigDecimal;

/**
 * Created by rangak on 06/01/2017.
 */
public abstract class Item {
    private String name;
    private int id;
    private int quantity;
    private double price = Double.valueOf(0);

    protected Item(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract BigDecimal accept(ItemPricer pricer);

    //Override in subclass to set any offers.
    public BigDecimal acceptOffers(Offers offers){
        return BigDecimal.ONE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return id == item.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public void incrementQuantity() {
        quantity++;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
