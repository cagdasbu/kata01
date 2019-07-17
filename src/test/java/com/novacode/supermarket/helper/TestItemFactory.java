package com.novacode.supermarket.helper;

import com.novacode.supermarket.checkout.CartItem;
import com.novacode.supermarket.checkout.CountableQuantity;
import com.novacode.supermarket.checkout.Quantity;
import com.novacode.supermarket.product.Product;

import java.math.BigDecimal;

public class TestItemFactory {

    public static Product getSampleProduct(String productId) {
        return new Product(productId,productId, BigDecimal.ONE, Quantity.Type.PCS);
    }

    public static CartItem getSampleCartItem(String productId) {
        Product product = getSampleProduct(productId);
        return new CartItem(product, new CountableQuantity(1, product.getQuantityType()));
    }


}
