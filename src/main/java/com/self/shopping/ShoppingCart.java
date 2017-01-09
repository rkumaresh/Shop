package com.self.shopping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rangak on 06/01/2017.
 */
public class ShoppingCart{
    private int totalItems;
    private Map<Item, Item> items = new HashMap<Item, Item>();
    private List<? extends ItemPricer> itemPricers = new ArrayList<ItemPricer>();

    public ShoppingCart(List<? extends ItemPricer> pricers){
        itemPricers = pricers;
    }

    /**
     * Adds {@link Item} to the shopping cart and increments total item count.
     *
     * @param item Item to be added to the shopping cart. If null is passed then it gets ignored.
     */
    public void addItem(Item item) {
        if(item == null){
            return;
        }

        Item foundItem = items.get(item);
        if(foundItem == null){
            items.put(item, item);
            foundItem = item;
        }
        foundItem.incrementQuantity();
        totalItems++;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public TotalCost calculatePrice() {
        if(totalItems <= 0){
            return new TotalCost();
        }

        TotalCost tc = new TotalCost();
        BigDecimal total = BigDecimal.ZERO;
        for (Item item : items.keySet()) {
            total = total.add(PricerFactory.getPricer(item).calculatePrice(item));
        }
        tc.setTotalAmount(total);


        return tc;
    }

}
