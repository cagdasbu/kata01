package com.novacode.supermarket.service.impl;

import com.novacode.supermarket.entity.Product;
import com.novacode.supermarket.service.CartService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class CartServiceImplTest {

    private CartService cartService;

    @Before
    public void before() {
        cartService = new CartServiceImpl();
    }

    @Test
    public void crud() {
        Product apple = new Product("1", "apple",  new BigDecimal(5));
        assert cartService.add(apple);
        assert cartService.remove(apple);
        assert !cartService.remove(apple);
    }

    @Test
    public void simpleCheckout() {
        Product apple = new Product("1", "apple", new BigDecimal(5));
        cartService.add(apple);
        BigDecimal total = cartService.checkout();
        Assert.assertEquals(new BigDecimal(5), total);
    }

}