package com.novacode.supermarket.checkout;

public class ScalableQuantity extends Quantity<Double> {

    public ScalableQuantity(Double value, Type type) {
        super(value, type);
    }

    @Override
    public Quantity incrementQuantity(Double value) {
        return new ScalableQuantity(this.value + value, getType());
    }

    @Override
    public String toString() {
        return String.format("x%.2f %s", value, getType().toString());
    }
}
