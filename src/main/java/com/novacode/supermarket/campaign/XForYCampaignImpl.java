package com.novacode.supermarket.campaign;

import com.novacode.supermarket.checkout.CartItem;
import com.novacode.supermarket.checkout.CheckoutItem;
import com.novacode.supermarket.product.Product;

import java.math.BigDecimal;

/**
 *  Campaign for pricing a definite (pricedQty) quantity of items free when campaignQty has been added to cart
 *
 *  ie: 3 apples for 2 apple price.
 */
public class XForYCampaignImpl implements Campaign {

    private Product product;

    private int campaignQty;

    private BigDecimal discount;

    /**
     * Constructor
     * @param product which is registering to the campaign
     * @param campaignQty quantity of the product needs to be purchased to activate campaign
     * @param pricedQty quantity of the products to be paid
     */
    public XForYCampaignImpl(Product product, int campaignQty, int pricedQty) {
        this.product = product;
        this.campaignQty = campaignQty;
        this.discount = product.getUnitCost().multiply(new BigDecimal(campaignQty - pricedQty)).negate();
    }

    public CheckoutItem apply(CartItem cartItem) {
        Integer campaignBundle = (int)(cartItem.getQuantity().getValue() / new Double(campaignQty));
        return new CheckoutItem(this.product.getProductName(), discount.multiply(new BigDecimal(campaignBundle)));
    }

}
