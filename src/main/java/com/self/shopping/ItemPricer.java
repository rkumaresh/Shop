package com.self.shopping;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by rangak on 06/01/2017.
 */
public interface ItemPricer<T extends Item> {
    public BigDecimal getPrice();
    public BigDecimal calculatePrice(T item);

}
