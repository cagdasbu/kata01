package com.novacode.supermarket.checkout;

import org.junit.Assert;
import org.junit.Test;

public class ScalableQuantityTest {
    @Test
    public void testToString() {

        Quantity quantity = new ScalableQuantity(new Double(2.5), Quantity.Type.KG);
        Assert.assertEquals("x2.50 KG", quantity.toString());
    }
}