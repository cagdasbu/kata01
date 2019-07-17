package com.novacode.supermarket.campaign;

import com.novacode.supermarket.checkout.CartItem;
import com.novacode.supermarket.checkout.CheckoutItem;
import com.novacode.supermarket.product.Product;
import com.novacode.supermarket.product.StoreServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.Assert.*;

public class XForYCampaignImplTest {

    @Test
    public void apply() {
        Product product = StoreServiceImpl.getInstance().getProduct("1");
        Campaign campaign = new XForYCampaignImpl(product, 3, 2);
        CheckoutItem checkoutItem = campaign.apply(new CartItem(product.getProductId(), 5));
        Assert.assertEquals(new BigDecimal(-0.5).round(new MathContext(2)), checkoutItem.getAmount().round(new MathContext(2)));
    }

    @Test
    public void apply_highVolume() {
        Product product = StoreServiceImpl.getInstance().getProduct("1");
        Campaign campaign = new XForYCampaignImpl(product, 3, 2);
        CheckoutItem checkoutItem = campaign.apply(new CartItem(product.getProductId(), 10));
        Assert.assertEquals(new BigDecimal(-1.5).round(new MathContext(2)), checkoutItem.getAmount().round(new MathContext(2)));
    }
}