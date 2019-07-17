package com.novacode.supermarket.checkout;

import java.math.BigDecimal;

public final class CheckoutItem {

    private final CartItem cartItem;

    private final BigDecimal amount;

    public CheckoutItem(CartItem cartItem, BigDecimal amount) {
        this.cartItem = cartItem;
        this.amount = amount;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("%s\t\t\t\t%.2f", cartItem, amount);
    }
}
