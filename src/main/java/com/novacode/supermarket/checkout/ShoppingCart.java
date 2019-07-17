package com.novacode.supermarket.checkout;

import com.novacode.supermarket.campaign.Campaign;
import com.novacode.supermarket.campaign.CampaignManager;
import com.novacode.supermarket.campaign.CampaignManagerImpl;
import com.novacode.supermarket.product.Product;
import com.novacode.supermarket.product.StoreServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public Bill checkout() {

        BigDecimal subtotal = BigDecimal.ZERO;

        List<CheckoutItem> checkoutItems = new ArrayList<>();
        List<CheckoutItem> discounts = new ArrayList<>();

        for (Map.Entry<String, Integer> cartItem : cartItems.entrySet()) {
            Product product = StoreServiceImpl.getInstance().getProduct(cartItem.getKey());
            CheckoutItem checkoutItem = new  CheckoutItem(product.getProductName(),
                    product.getUnitCost().multiply(new BigDecimal(cartItem.getValue())));
            subtotal = subtotal.add(checkoutItem.getAmount());
            checkoutItems.add(checkoutItem);
        }

        BigDecimal total = subtotal.add(BigDecimal.ZERO);
        for (Map.Entry<String, Integer> cartItem : cartItems.entrySet()) {
            Campaign campaign = campaignManager.getCampaign(cartItem.getKey());
            if(campaign != null) {
                CheckoutItem checkoutItem = campaign.apply(new CartItem(cartItem.getKey(), cartItem.getValue()));
                total = total.add(checkoutItem.getAmount());
                discounts.add(checkoutItem);
            }
        }
        return new Bill(checkoutItems, discounts);
    }
}
