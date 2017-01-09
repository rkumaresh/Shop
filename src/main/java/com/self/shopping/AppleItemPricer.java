package com.self.shopping;

import java.math.BigDecimal;

/**
 * Created by rangak on 06/01/2017.
 */
public class AppleItemPricer implements ItemPricer<Apple> {
    private BigDecimal price = BigDecimal.valueOf(.60);

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal calculatePrice(Apple item) {
        if(item == null){
            BigDecimal itemCost = BigDecimal.ZERO;
        }
        return getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
    }

}
