package com.novacode.supermarket.campaign;

import com.novacode.supermarket.checkout.CartItem;
import com.novacode.supermarket.checkout.CheckoutItem;
import com.novacode.supermarket.product.Product;
import com.novacode.supermarket.product.StoreServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

public class QuantityForPriceCampaignImplTest {

    @Test
    public void apply() {
        Product product = StoreServiceImpl.getInstance().getProduct("2");
        Campaign campaign = new QuantityForPriceCampaignImpl(product, 2 , BigDecimal.ONE);
        CheckoutItem checkoutItem = campaign.apply(new CartItem(product.getProductId(), 5));
        Assert.assertEquals(new BigDecimal(-0.8).round(new MathContext(2)), checkoutItem.getAmount().round(new MathContext(2)));
    }

    @Test
    public void apply_largeVal() {
        Product product = StoreServiceImpl.getInstance().getProduct("2");
        Campaign campaign = new QuantityForPriceCampaignImpl(product, 2 , BigDecimal.ONE);
        CheckoutItem checkoutItem = campaign.apply(new CartItem(product.getProductId(), 150));
        Assert.assertEquals(new BigDecimal(-30).round(new MathContext(2)), checkoutItem.getAmount().round(new MathContext(2)));
    }
}