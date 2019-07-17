package com.novacode.supermarket.checkout;

import com.novacode.supermarket.product.Product;

import java.math.BigDecimal;

public final class CartItem {

    private final Product product;

    private final Quantity quantity;

    public CartItem(Product product, Quantity quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String getProductId() {
        return product.getProductId();
    }

    public Product getProduct() {
        return product;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public BigDecimal getCost(){
        if (product.getQuantityType() == Quantity.Type.PCS) {
            return product.getUnitCost().multiply( new BigDecimal((Integer) quantity.getValue()));
        } else {
            return product.getUnitCost().multiply( new BigDecimal((Double) quantity.getValue()));
        }
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", product, quantity.toString());
    }
}
