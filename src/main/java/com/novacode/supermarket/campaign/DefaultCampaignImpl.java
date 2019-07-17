package com.novacode.supermarket.campaign;

import com.novacode.supermarket.checkout.CartItem;
import com.novacode.supermarket.product.Product;

import java.math.BigDecimal;

public class DefaultCampaignImpl implements Campaign {

    private Product product;

    public DefaultCampaignImpl(Product product) {
        this.product = product;
    }

    @Override
    public BigDecimal apply(CartItem cartItem) {
        BigDecimal total = product.getUnitCost().multiply(new BigDecimal(cartItem.getQuantity()));
        return total;
    }
}
