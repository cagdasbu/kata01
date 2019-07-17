package com.novacode.supermarket.campaign;

import com.novacode.supermarket.checkout.CartItem;
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
        BigDecimal campaignPrice = campaign.apply(new CartItem(product.getProductId(), 5));
        Assert.assertEquals(0, new BigDecimal(2).compareTo(campaignPrice.round(new MathContext(2))));
    }
}