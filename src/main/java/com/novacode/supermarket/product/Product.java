package com.novacode.supermarket.product;

import com.novacode.supermarket.checkout.Quantity;

import java.math.BigDecimal;

public final class Product {

    private final String productId;

    private final String productName;

    private final BigDecimal unitCost;

    private final Quantity.Type quantityType;

    public Product(String productId, String productName, BigDecimal unitCost, Quantity.Type type) {
        this.productId = productId;
        this.productName = productName;
        this.unitCost = unitCost;
        this.quantityType = type;
    }

    public String getProductId() {
        return productId;
    }


    public String getProductName() {
        return productName;
    }


    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public Quantity.Type getQuantityType() {
        return quantityType;
    }
}
