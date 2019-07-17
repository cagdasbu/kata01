package com.novacode.supermarket.checkout;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

public class BillTest {

    @Test
    public void getSubtotal() {
        CheckoutItem item1 = new CheckoutItem("item1", BigDecimal.ONE);
        CheckoutItem item2 = new CheckoutItem("item2", BigDecimal.TEN);
        CheckoutItem item3 = new CheckoutItem("item3", new BigDecimal(.5));

        Bill bill = new Bill(Arrays.asList(item1,item2, item3), null);
        BigDecimal subtotal = bill.getSubtotal();
        Assert.assertEquals(new BigDecimal(11.5).round(new MathContext(2)), subtotal.round(new MathContext(2)));
    }

    @Test
    public void getSubtotal_withDiscounts() {
        CheckoutItem item1 = new CheckoutItem("item1", BigDecimal.ONE);
        CheckoutItem item2 = new CheckoutItem("item2", BigDecimal.TEN);
        CheckoutItem item3 = new CheckoutItem("item3", new BigDecimal(.5));

        CheckoutItem disc1 = new CheckoutItem("item1-disc", new BigDecimal(2).negate() );

        Bill bill = new Bill(Arrays.asList(item1,item2, item3), Arrays.asList(disc1));
        BigDecimal subtotal = bill.getSubtotal();
        Assert.assertEquals(new BigDecimal(11.5).round(new MathContext(2)), subtotal.round(new MathContext(2)));
    }

    @Test
    public void getSubtotal_withNoCheckoutItem() {
        CheckoutItem disc1 = new CheckoutItem("item1-disc", new BigDecimal(2).negate() );

        Bill bill = new Bill(null, Arrays.asList(disc1));
        BigDecimal subtotal = bill.getSubtotal();
        Assert.assertEquals(BigDecimal.ZERO, subtotal.round(new MathContext(2)));
    }

    @Test
    public void getDiscountAmount_NoDiscount() {
        CheckoutItem item1 = new CheckoutItem("item1", BigDecimal.ONE);
        CheckoutItem item2 = new CheckoutItem("item2", BigDecimal.TEN);
        CheckoutItem item3 = new CheckoutItem("item3", new BigDecimal(.5));

        Bill bill = new Bill(Arrays.asList(item1,item2, item3), null);
        BigDecimal discountAmount = bill.getDiscountAmount();
        Assert.assertEquals(BigDecimal.ZERO, discountAmount.round(new MathContext(2)));
    }

    @Test
    public void getDiscountAmount_WithDiscount() {
        CheckoutItem item1 = new CheckoutItem("item1", BigDecimal.ONE);
        CheckoutItem item2 = new CheckoutItem("item2", BigDecimal.TEN);
        CheckoutItem item3 = new CheckoutItem("item3", new BigDecimal(.5));

        CheckoutItem disc1 = new CheckoutItem("item1-disc", new BigDecimal(2).negate() );
        CheckoutItem disc2 = new CheckoutItem("item2-disc", new BigDecimal(2.5).negate() );

        Bill bill = new Bill(Arrays.asList(item1,item2, item3), Arrays.asList(disc1,disc2));
        BigDecimal discountAmount = bill.getDiscountAmount();
        Assert.assertEquals(new BigDecimal(4.5).round(new MathContext(2)).negate(), discountAmount.round(new MathContext(2)));
    }

    @Test
    public void getTotal() {
        CheckoutItem item1 = new CheckoutItem("item1", BigDecimal.ONE);
        CheckoutItem item2 = new CheckoutItem("item2", BigDecimal.TEN);
        CheckoutItem item3 = new CheckoutItem("item3", new BigDecimal(.5));

        CheckoutItem disc1 = new CheckoutItem("item1-disc", new BigDecimal(2).negate() );
        CheckoutItem disc2 = new CheckoutItem("item2-disc", new BigDecimal(2.5).negate() );
        CheckoutItem disc3 = new CheckoutItem("item3-disc", new BigDecimal(2.5).negate() );

        Bill bill = new Bill(Arrays.asList(item1,item2, item3), Arrays.asList(disc1,disc2, disc3));
        BigDecimal total = bill.getTotal();
        Assert.assertEquals(0, new BigDecimal(4.5).compareTo(total.round(new MathContext(2))));
    }
}