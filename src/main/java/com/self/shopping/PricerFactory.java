package com.self.shopping;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rangak on 08/01/2017.
 */
public class PricerFactory {
    static Map<String, ItemPricer> pricerMap = new HashMap<String, ItemPricer>();

    static {
        String apple = Apple.class.getName();
        String orange = Orange.class.getName();
        pricerMap.put(apple, new AppleItemPricer());
        pricerMap.put(orange, new OrangeItemPricer());
    }
    public static ItemPricer getPricer(Item item) {
        if(item == null || pricerMap.get(item.getClass().getName()) == null ){
            throw new RuntimeException("Pricer not found for item : " + item);
        }
        return pricerMap.get(item.getClass().getName());
    }
}
