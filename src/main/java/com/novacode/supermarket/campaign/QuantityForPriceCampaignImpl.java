package com.novacode.supermarket.campaign;

import com.novacode.supermarket.checkout.CartItem;
import com.novacode.supermarket.product.Product;

import java.math.BigDecimal;

/**
 *  Campaign for pricing a definite quantity of item
 *
 *  ie: 1 apple £5  -> 2 apples £9
 */
public class QuantityForPriceCampaignImpl implements Campaign {

    private Product product;

    private int campaignQty;

    private BigDecimal campaignPrice;

    /**
     * Constructor
     * @param product which is registering to the campaign
     * @param campaignQty quantity of the product needs to be purchased to activate campaign
     * @param campaignPrice price of the products to be paid in total
     */
    public QuantityForPriceCampaignImpl(Product product, int campaignQty, BigDecimal campaignPrice) {
        this.product = product;
        this.campaignQty = campaignQty;
        this.campaignPrice = campaignPrice;
    }

    @Override
    public BigDecimal apply(CartItem cartItem) {

        Integer campaignBundle = cartItem.getQuantity() / campaignQty;
        Integer defaultBundle = cartItem.getQuantity() % campaignQty;

        BigDecimal bundlePrice = campaignPrice.multiply(new BigDecimal(campaignBundle));
        BigDecimal defaultPrice = product.getUnitCost().multiply(new BigDecimal(defaultBundle));
        return bundlePrice.add(defaultPrice);
    }
}
