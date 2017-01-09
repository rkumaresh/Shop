package com.self.shopping;

import java.math.BigDecimal;

/**
 * Created by rangak on 06/01/2017.
 */
public class Orange extends Item {
    public Orange(int id) {
        super(id);
    }

    public BigDecimal accept(ItemPricer pricer) {
        if(pricer instanceof OrangeItemPricer){
            return ((OrangeItemPricer) pricer).calculatePrice(this);
        }
        return BigDecimal.ZERO;
    }

}
