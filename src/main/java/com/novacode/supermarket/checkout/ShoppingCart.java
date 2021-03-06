package com.novacode.supermarket.checkout;

import com.novacode.supermarket.campaign.Campaign;
import com.novacode.supermarket.campaign.CampaignManager;
import com.novacode.supermarket.campaign.CampaignManagerImpl;
import com.novacode.supermarket.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

    private Map<String, CartItem> cartItems;

    private CampaignManager campaignManager;

    public ShoppingCart() {
        this.campaignManager = CampaignManagerImpl.getInstance();
        this.cartItems = new HashMap<>(1);
    }

    public void add(Product product, Quantity quantity) {
        if (product.getQuantityType() != quantity.getType()) {
            throw new IllegalArgumentException(String.format("Type %s cannot be added to %s", quantity.getType().toString(), product.getProductName()));
        }

        CartItem cartItem = this.cartItems.get(product.getProductId());
        if (cartItem == null) {
            this.cartItems.put(product.getProductId(), new CartItem(product, quantity));
        } else {
            Quantity increasedQty = cartItem.getQuantity().incrementQuantity(quantity.getValue());
            this.cartItems.put(product.getProductId(), new CartItem(product, increasedQty));
        }
    }

    public Bill checkout() {

        BigDecimal subtotal = BigDecimal.ZERO;

        List<CheckoutItem> checkoutItems = new ArrayList<>();
        List<CheckoutItem> discounts = new ArrayList<>();

        for (Map.Entry<String, CartItem> cartItem : cartItems.entrySet()) {
            CheckoutItem checkoutItem = new CheckoutItem(cartItem.getValue(), cartItem.getValue().getCost());
            subtotal = subtotal.add(checkoutItem.getAmount());
            checkoutItems.add(checkoutItem);
        }

        BigDecimal total = subtotal.add(BigDecimal.ZERO);
        for (Map.Entry<String, CartItem> cartItem : cartItems.entrySet()) {
            Campaign campaign = campaignManager.getCampaign(cartItem.getKey());
            if (campaign != null) {
                CheckoutItem checkoutItem = campaign.apply(cartItem.getValue());
                total = total.add(checkoutItem.getAmount());
                discounts.add(checkoutItem);
            }
        }
        return new Bill(checkoutItems, discounts);
    }
}
