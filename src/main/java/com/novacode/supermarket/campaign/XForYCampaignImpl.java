package com.novacode.supermarket.campaign;

import com.novacode.supermarket.checkout.CartItem;
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

    private int pricedQty;

    /**
     * Constructor
     * @param product which is registering to the campaign
     * @param campaignQty quantity of the product needs to be purchased to activate campaign
     * @param pricedQty quantity of the products to be paid
     */
    public XForYCampaignImpl(Product product, int campaignQty, int pricedQty) {
        this.product = product;
        this.campaignQty = campaignQty;
        this.pricedQty = pricedQty;
    }

    public BigDecimal apply(CartItem cartItem) {

        Integer campaignBundle = cartItem.getQuantity() / campaignQty;
        Integer defaultBundle = cartItem.getQuantity() % campaignQty;

        BigDecimal campaignCost = product.getUnitCost().multiply(new BigDecimal(pricedQty)).multiply(new BigDecimal(campaignBundle));
        BigDecimal defaultCost = product.getUnitCost().multiply(new BigDecimal(defaultBundle));

        return campaignCost.add(defaultCost);
    }

}
