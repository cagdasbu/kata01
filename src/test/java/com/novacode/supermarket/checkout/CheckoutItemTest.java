package com.novacode.supermarket.checkout;

import com.novacode.supermarket.helper.TestItemFactory;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CheckoutItemTest {

    @Test
    public void toStringFormatTest() {
        CheckoutItem item = new CheckoutItem(TestItemFactory.getSampleCartItem("Beans"), BigDecimal.ONE);
        Assert.assertEquals("Beans (x1 PCS)\t\t\t\t1.00", item.toString());
    }
}