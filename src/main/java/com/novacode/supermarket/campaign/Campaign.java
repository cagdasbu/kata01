package com.novacode.supermarket.campaign;

import com.novacode.supermarket.checkout.CartItem;
import com.novacode.supermarket.checkout.CheckoutItem;

/**
 * Campaign Interface represents the discount logic of the product
 */
public interface Campaign {

    CheckoutItem apply(CartItem cartItem);

}
