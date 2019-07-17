package com.novacode.supermarket.checkout;

public final class CartItem {

    private final String productId;

    private final Quantity quantity;

    public CartItem(String productId, Quantity quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public Quantity getQuantity() {
        return quantity;
    }
}
