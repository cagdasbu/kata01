package com.novacode.supermarket.checkout;

public class CountableQuantity extends Quantity<Integer>{

    public CountableQuantity(Integer value, Type type) {
        super(value, type);
    }

    @Override
    public Integer incrementQuantity(Integer value) {
        this.value += value;
        return this.value;
    }

    @Override
    public String toString() {
        return String.format("x%d %s", value, getType().toString());
    }
}
