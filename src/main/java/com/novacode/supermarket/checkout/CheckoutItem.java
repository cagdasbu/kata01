package com.novacode.supermarket.checkout;

import java.math.BigDecimal;

public final class CheckoutItem {

    private String itemDesc;

    private BigDecimal amount;

    public CheckoutItem(String itemDesc, BigDecimal amount) {
        this.itemDesc = itemDesc;
        this.amount = amount;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("%s\t\t\t\t%.2f", itemDesc, amount);
    }
}
