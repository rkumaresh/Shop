import com.self.shopping.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rangak on 06/01/2017.
 */
@RunWith(JUnit4.class)
public class TestShoppingCart {

    @Test
    public void testAddingNullLineItemDoNotAddToShoppingCartOrThrowException(){
        ShoppingCart sc = getShoppingCartWithEmptyPricers();
        sc.addItem(null);
        Assert.assertEquals(Integer.valueOf(0), Integer.valueOf(sc.getTotalItems()) );

    }
    @Test
    public void testAddingLineItemAddsToShoppingCart(){
        ShoppingCart sc = getShoppingCartWithEmptyPricers();
        Item item = new Apple(1);
        Item item2 = new Orange(2);
        sc.addItem(item);
        sc.addItem(item2);
        Assert.assertEquals(Integer.valueOf(2), Integer.valueOf(sc.getTotalItems()) );
    }

    @Test
    public void testEmptyShoppingCart(){
        ShoppingCart sc = getShoppingCartWithEmptyPricers();
        TotalCost tp = sc.calculatePrice();

        Assert.assertEquals(BigDecimal.valueOf(0), tp.getTotalAmount() );
    }

    @Test
    public void testShoppingCartReturnsCorrectPrice(){
        List<ItemPricer> pricers = new ArrayList<ItemPricer>();
        pricers.add(new AppleItemPricer());
        ShoppingCart sc = new ShoppingCart(pricers);
        sc.addItem(createApple());
        sc.addItem(createApple());
        TotalCost tp = sc.calculatePrice();
        Assert.assertEquals(BigDecimal.valueOf(1.20), tp.getTotalAmount() );

        pricers = new ArrayList<ItemPricer>();
        pricers.add(new OrangeItemPricer());
        sc = new ShoppingCart(pricers);
        sc.addItem(createOrange());
        sc.addItem(createOrange());
        tp = sc.calculatePrice();
        Assert.assertEquals(new BigDecimal(".50"), tp.getTotalAmount() );

        pricers = new ArrayList<ItemPricer>();
        pricers.add(new AppleItemPricer());
        pricers.add(new OrangeItemPricer());
        sc = new ShoppingCart(pricers);
        sc.addItem(createApple());
        sc.addItem(createApple());
        sc.addItem(createOrange());
        sc.addItem(createApple());
        tp = sc.calculatePrice();
        Assert.assertEquals(BigDecimal.valueOf(2.05), tp.getTotalAmount() );
    }

    @Test
    public void testBuyOneGetOneOfferOnApples(){
        ShoppingCart sc = new ShoppingCart(getItemPricers());
        
        sc.addItem(createApple());
        sc.addItem(createApple());
        TotalCost tp = sc.calculatePrice();
        Assert.assertEquals(BigDecimal.valueOf(.6), tp.getTotalAmount() );

    }

       private Apple createApple() {
           Apple apple = new Apple(1);
           apple.setName("Apple");
           return apple;
    }

    private Item createOrange() {
        Orange orange = new Orange(2);
        orange.setName("Orange");
        return orange;
    }

    private ShoppingCart getShoppingCartWithEmptyPricers() {
        return new ShoppingCart(null);
    }

    private ArrayList<ItemPricer> getItemPricers() {
        ArrayList<ItemPricer> itemPricers = new ArrayList<ItemPricer>(2);
        itemPricers.add(new AppleItemPricer());
        itemPricers.add(new OrangeItemPricer());
        return itemPricers;
    }

}
