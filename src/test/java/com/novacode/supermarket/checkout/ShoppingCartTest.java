package com.novacode.supermarket.checkout;

import com.novacode.supermarket.product.Product;
import com.novacode.supermarket.product.StoreServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @Before
    public void before() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void add() {
        Product item = StoreServiceImpl.getInstance().getProduct("1");
        shoppingCart.add(item);
        shoppingCart.checkout();
    }

    /**
     * Testing basic pricing with multiple products
     */
    @Test
    public void simpleCheckout() {
        Product item = StoreServiceImpl.getInstance().getProduct("1");
        shoppingCart.add(item);
        BigDecimal total = shoppingCart.checkout().getTotal();
        Assert.assertEquals(new BigDecimal(.5), total);
    }

    /**
     * Testing basic pricing with multiple products
     */
    @Test
    public void simpleCheckout_MultipleItems() {
        Product bean = StoreServiceImpl.getInstance().getProduct("1");
        Product coke = StoreServiceImpl.getInstance().getProduct("2");

        shoppingCart.add(bean);
        shoppingCart.add(coke);

        BigDecimal total = shoppingCart.checkout().getTotal();
        MathContext mathContext = new MathContext(2);
        Assert.assertEquals(new BigDecimal(1.2).round(mathContext), total.round(mathContext));
    }


}