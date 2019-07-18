package com.novacode.supermarket.campaign;

import com.novacode.supermarket.checkout.*;
import com.novacode.supermarket.product.Product;
import com.novacode.supermarket.product.StoreServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

public class QuantityForPriceCampaignImplTest {

    private Campaign campaign;

    @Test
    public void apply() {
        Product product = StoreServiceImpl.getInstance().getProduct("C");
        campaign = new QuantityForPriceCampaignImpl(product, 2 , BigDecimal.ONE);
        CheckoutItem checkoutItem = campaign.apply(new CartItem(product, new CountableQuantity(5, Quantity.Type.PCS)));
        Assert.assertEquals(new BigDecimal(-0.8).round(new MathContext(2)), checkoutItem.getAmount().round(new MathContext(2)));
    }

    @Test
    public void apply_largeVal() {
        Product product = StoreServiceImpl.getInstance().getProduct("C");
        campaign = new QuantityForPriceCampaignImpl(product, 2 , BigDecimal.ONE);
        CheckoutItem checkoutItem = campaign.apply(new CartItem(product, new CountableQuantity(150, Quantity.Type.PCS)));
        Assert.assertEquals(new BigDecimal(-30).round(new MathContext(2)), checkoutItem.getAmount().round(new MathContext(2)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void apply_KG() {
        Product product = StoreServiceImpl.getInstance().getProduct("C");
        campaign = new QuantityForPriceCampaignImpl(product, 2 , BigDecimal.ONE);
        CheckoutItem checkoutItem = campaign.apply(new CartItem(product, new ScalableQuantity(new Double(150), Quantity.Type.KG)));
    }
}