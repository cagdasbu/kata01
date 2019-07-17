package com.novacode.supermarket.checkout;

public final class CountableQuantity extends Quantity<Integer>{

    public CountableQuantity(Integer value, Type type) {
        super(value, type);
    }

    @Override
    public CountableQuantity incrementQuantity(Integer value) {
        return new CountableQuantity(this.value + value, getType());
    }

    @Override
    public String toString() {
        return String.format("x%d %s", value, getType().toString());
    }
}
