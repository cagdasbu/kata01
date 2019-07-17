package com.novacode.supermarket.checkout;

public abstract class Quantity<T extends Number> {

    public enum Type  {
        PCS, KG;
    };

    final T value;

    private Type type;

    public Quantity(T value, Type type) {
        this.value = value;
        this.type = type;
    }

    public T getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }

    public abstract Quantity incrementQuantity(T value);

}
