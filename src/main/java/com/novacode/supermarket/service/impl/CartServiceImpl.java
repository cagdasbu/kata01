package com.novacode.supermarket.service.impl;

import com.novacode.supermarket.entity.Product;
import com.novacode.supermarket.service.CartService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements CartService {

    private List<Product> products;

    public CartServiceImpl() {
        this.products = new ArrayList<>(1);
    }

    @Override
    public boolean add(Product product) {
        return this.products.add(product);
    }

    @Override
    public boolean remove(Product product) {
        return this.products.remove(product);
    }

    @Override
    public BigDecimal checkout() {
        BigDecimal total  = products.stream()
                .map(Product::getUnitCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return total;
    }
}
