package com.self.shopping;

import java.math.BigDecimal;

/**
 * Created by rangak on 06/01/2017.
 */
public class Apple extends Item {
    public Apple(int id) {
        super(id);
    }

    public BigDecimal accept(ItemPricer pricer) {
        if(pricer instanceof AppleItemPricer){
            return ((AppleItemPricer) pricer).calculatePrice(this);
        }
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal acceptOffers(Offers offers) {
     offers.calculateOfferPrice(this)
    }
}
