package com.novacode.supermarket.product;

import java.math.BigDecimal;

public final class Product {

    private final String productId;

    private final String productName;

    private final BigDecimal unitCost;

    public Product(String productId, String productName, BigDecimal unitCost) {
        this.productId = productId;
        this.productName = productName;
        this.unitCost = unitCost;
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

}
