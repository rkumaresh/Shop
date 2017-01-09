package com.self.shopping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rangak on 08/01/2017.
 */
public class BuyOneGetOneOffer implements Offers {
    List<String> offerItems = new ArrayList<String>(1);

    public BuyOneGetOneOffer(List<String> offerItems){
        this.offerItems = offerItems;
    }

    public BigDecimal calculateOfferPrice(Item item, ItemPricer itemPricer) {
        if(item == null || itemPricer == null || offerItems == null || !offerItems.contains(item.getClass().getName())){
            return BigDecimal.ZERO;
        }
        int discountTotal = item.getQuantity() / 2;
        return itemPricer.getPrice().multiply(BigDecimal.valueOf(discountTotal));
    }
}
