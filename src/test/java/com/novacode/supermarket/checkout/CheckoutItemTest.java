package com.novacode.supermarket.checkout;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CheckoutItemTest {

    @Test
    public void toStringFormatTest() {
        CheckoutItem item = new CheckoutItem("Beans", BigDecimal.ONE);
        Assert.assertEquals("Beans\t\t\t\t1.00", item.toString());
    }
}