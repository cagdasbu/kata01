package com.novacode.supermarket.service;

import com.novacode.supermarket.entity.Product;

import java.math.BigDecimal;

public interface CartService {

    public boolean add(Product product);

    public boolean remove(Product product);

    public BigDecimal checkout();

}
