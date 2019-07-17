package com.novacode.supermarket.checkout;

import com.novacode.supermarket.helper.TestItemFactory;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartItemTest {

    @Test
    public void getCost() {
        CartItem cartItem = TestItemFactory.getSampleCartItem("Beans");
        Assert.assertEquals(BigDecimal.valueOf(1), cartItem.getCost());
    }

    @Test
    public void testToString() {
        CartItem cartItem = TestItemFactory.getSampleCartItem("Beans");
        Assert.assertEquals("Beans (x1 PCS)", cartItem.toString());
    }
}