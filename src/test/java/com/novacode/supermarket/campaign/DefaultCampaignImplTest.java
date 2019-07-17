package com.novacode.supermarket.campaign;

import com.novacode.supermarket.checkout.CartItem;
import com.novacode.supermarket.product.Product;
import com.novacode.supermarket.product.StoreServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

public class DefaultCampaignImplTest {

    @Test
    public void apply(){
        Product product = StoreServiceImpl.getInstance().getProduct("1");
        Campaign campaign = new DefaultCampaignImpl(product);
        BigDecimal campaignPrice = campaign.apply(new CartItem(product.getProductId(), 5));
        Assert.assertEquals(new BigDecimal(2.5).round(new MathContext(2)), campaignPrice.round(new MathContext(2)));
    }
}