package com.novacode.supermarket.campaign;

import com.novacode.supermarket.checkout.CartItem;
import com.novacode.supermarket.checkout.CheckoutItem;
import com.novacode.supermarket.checkout.Quantity;
import com.novacode.supermarket.product.Product;
import com.novacode.supermarket.product.StoreServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.Assert.*;

public class XForYCampaignImplTest {

    private Campaign campaign;

    @Test
    public void apply() {
        Product product = StoreServiceImpl.getInstance().getProduct("1");
        campaign = new XForYCampaignImpl(product, 3, 2);
        CheckoutItem checkoutItem = campaign.apply(new CartItem(product.getProductId(), new Quantity(5, Quantity.Type.PCS)));
        Assert.assertEquals(new BigDecimal(-0.5).round(new MathContext(2)), checkoutItem.getAmount().round(new MathContext(2)));
    }

    @Test
    public void apply_highVolume() {
        Product product = StoreServiceImpl.getInstance().getProduct("1");
        campaign = new XForYCampaignImpl(product, 3, 2);
        CheckoutItem checkoutItem = campaign.apply(new CartItem(product.getProductId(), new Quantity(10, Quantity.Type.PCS)));
        Assert.assertEquals(new BigDecimal(-1.5).round(new MathContext(2)), checkoutItem.getAmount().round(new MathContext(2)));
    }
}