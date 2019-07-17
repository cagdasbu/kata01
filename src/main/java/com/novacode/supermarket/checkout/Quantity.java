package com.novacode.supermarket.checkout;

public class Quantity {

    public enum Type  {
        PCS, KG;
    };

    private Double value;

    private Type type;

    public Quantity(double value, Type type) {
        this.value = value;
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }

    public Double incrementQuantity(double value) {
        this.value += value;
        return this.value;
    }
}
