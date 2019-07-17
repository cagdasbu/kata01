package com.novacode.supermarket.checkout;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

public final class Bill {

    private List<CheckoutItem> checkoutItems;

    private List<CheckoutItem> discounts;

    public Bill(List<CheckoutItem> checkoutItems, List<CheckoutItem> discounts) {
        this.checkoutItems = checkoutItems;
        this.discounts = discounts;
    }

    BigDecimal getSubtotal(){
        return checkoutItems.stream()
                .map(CheckoutItem::getAmount)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    BigDecimal getDiscountAmount(){
        return discounts.stream()
                .map(CheckoutItem::getAmount)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    BigDecimal getTotal(){
        return getSubtotal().subtract(getDiscountAmount());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        checkoutItems.forEach(c -> sb.append(c.toString()).append("\n"));
        sb.append("---------------------").append("\n");
        sb.append("Subtotal:\t\t\t" + getSubtotal().round(new MathContext(2))).append("\n\n");
        sb.append("Savings").append("\n\n");
        discounts.forEach(d -> sb.append(d.toString()).append("\n"));
        sb.append("---------------------").append("\n");
        sb.append("Total Savings:\t\t" + getDiscountAmount().round(new MathContext(2))).append("\n\n");
        sb.append("---------------------").append("\n");
        sb.append("Total:\t\t\t\t" + getTotal().round(new MathContext(2))).append("\n");
        return sb.toString();
    }
}
