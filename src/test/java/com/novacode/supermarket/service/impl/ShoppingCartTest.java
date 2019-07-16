package com.novacode.supermarket.service.impl;

import com.novacode.supermarket.checkout.ShoppingCart;
import com.novacode.supermarket.product.Product;
import com.novacode.supermarket.product.StoreService;
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
        Product item = StoreService.getInstance().getProduct("1");
        shoppingCart.add(item);
        shoppingCart.checkout();
    }

    /**
     * Testing basic pricing with multiple products
     */
    @Test
    public void simpleCheckout() {
        Product item = StoreService.getInstance().getProduct("1");
        shoppingCart.add(item);
        BigDecimal total = shoppingCart.checkout();
        Assert.assertEquals(new BigDecimal(.5), total);
    }

    /**
     * Testing basic pricing with multiple products
     */
    @Test
    public void simpleCheckout_MultipleItems() {
        Product bean = StoreService.getInstance().getProduct("1");
        Product coke = StoreService.getInstance().getProduct("2");

        shoppingCart.add(bean);
        shoppingCart.add(coke);
        shoppingCart.add(coke);

        BigDecimal total = shoppingCart.checkout();
        MathContext mathContext = new MathContext(2);
        Assert.assertEquals(new BigDecimal(1.9).round(mathContext).round(MathContext.DECIMAL32), total.round(mathContext));
    }


}