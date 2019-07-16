package com.novacode.supermarket.entity;

import java.math.BigDecimal;

public class Product {

    private String productId;

    private String productName;

    private BigDecimal unitCost;

    public Product(String productId, String productName, BigDecimal unitCost) {
        this.productId = productId;
        this.productName = productName;
        this.unitCost = unitCost;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }
}
