package com.self.shopping;

import java.math.BigDecimal;

/**
 * Created by rangak on 08/01/2017.
 */
public interface Offers<T extends Item> {
    BigDecimal calculateOfferPrice(T item, ItemPricer<T> pricer);
}
