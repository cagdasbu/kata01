package com.novacode.supermarket.checkout;

import org.junit.Assert;
import org.junit.Test;

public class CountableQuantityTest {

    @Test
    public void testToString() {

        Quantity quantity = new CountableQuantity(3, Quantity.Type.PCS);
        Assert.assertEquals("x3 PCS", quantity.toString());
    }
}