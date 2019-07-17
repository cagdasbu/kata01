package com.novacode.supermarket.campaign;

import com.novacode.supermarket.checkout.CartItem;

import java.math.BigDecimal;

/**
 * Campaign Interface represents the pricing logic of the product
 */
public interface Campaign {

    BigDecimal apply(CartItem cartItem);

}
