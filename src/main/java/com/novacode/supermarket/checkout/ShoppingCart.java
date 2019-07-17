package com.novacode.supermarket.checkout;

import com.novacode.supermarket.campaign.Campaign;
import com.novacode.supermarket.campaign.CampaignManager;
import com.novacode.supermarket.campaign.CampaignManagerImpl;
import com.novacode.supermarket.product.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<String, Integer> cartItems;

    private CampaignManager campaignManager;

    public ShoppingCart() {
        this.campaignManager = CampaignManagerImpl.getInstance();
        this.cartItems = new HashMap<>(1);
    }

    public void add(Product product) {
        this.add(product, 1);
    }

    public void add(Product product, int quantity) {
        Integer cartQuantity = this.cartItems.get(product.getProductId());
        if (cartQuantity == null) {
            this.cartItems.put(product.getProductId(), quantity);
        } else {
            this.cartItems.put(product.getProductId(), cartQuantity + quantity);
        }
    }

    public BigDecimal checkout() {

        BigDecimal total = BigDecimal.ZERO;
        for (Map.Entry<String, Integer> cartItem : cartItems.entrySet()) {
            Campaign campaign = campaignManager.getCampaign(cartItem.getKey());
            BigDecimal cartItemAmount = campaign.apply(new CartItem(cartItem.getKey(), cartItem.getValue()));
            total = total.add(cartItemAmount);
        }

        return total;
    }
}
