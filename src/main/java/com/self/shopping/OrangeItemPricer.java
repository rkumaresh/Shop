package com.self.shopping;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by rangak on 06/01/2017.
 */
public class OrangeItemPricer implements ItemPricer<Orange> {
    private BigDecimal price = BigDecimal.valueOf(.25);

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal calculatePrice(Orange item) {
        return getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
    }


}
