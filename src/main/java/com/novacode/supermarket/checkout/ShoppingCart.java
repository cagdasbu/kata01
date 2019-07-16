package com.novacode.supermarket.checkout;

import com.novacode.supermarket.product.Product;
import com.novacode.supermarket.product.StoreService;
import com.novacode.supermarket.product.StoreServiceImpl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<String, Integer> cartItems;

    private StoreService storeService;

    public ShoppingCart() {
        this.storeService = StoreServiceImpl.getInstance();
        this.cartItems = new HashMap<>(1);
    }

    public void add(Product product) {
        this.add(product, 1);
    }

    public void add(Product product, int quantity) {
         Integer cartQuantity = this.cartItems.get(product.getProductId());
        if(cartQuantity == null) {
            this.cartItems.put(product.getProductId(), quantity);
        } else {
            this.cartItems.put(product.getProductId(), cartQuantity + quantity);
        }
    }

    public BigDecimal checkout() {
        BigDecimal total  = cartItems.keySet()
                .stream()
                .map(productId -> storeService.getProduct(productId))
                .map(product -> product.getUnitCost().multiply(new BigDecimal(cartItems.get(product.getProductId()))))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return total;
    }
}
