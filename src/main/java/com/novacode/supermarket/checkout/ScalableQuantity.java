package com.novacode.supermarket.checkout;

public class ScalableQuantity extends Quantity<Double> {

    public ScalableQuantity(Double value, Type type) {
        super(value, type);
    }

    @Override
    public Double incrementQuantity(Double value) {
        this.value += value;
        return value;
    }

    @Override
    public String toString() {
        return String.format("x%.2f %s", value, getType().toString());
    }
}
