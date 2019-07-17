package com.novacode.supermarket.campaign;

import com.novacode.supermarket.checkout.CartItem;
import com.novacode.supermarket.checkout.CheckoutItem;
import com.novacode.supermarket.checkout.Quantity;
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

    private BigDecimal discount;

    /**
     * Constructor
     * @param product which is registering to the campaign
     * @param campaignQty quantity of the product needs to be purchased to activate campaign
     * @param campaignPrice price of the products to be paid in total
     */
    public QuantityForPriceCampaignImpl(Product product, int campaignQty, BigDecimal campaignPrice) {
        this.product = product;
        this.campaignQty = campaignQty;
        this.discount = product.getUnitCost().multiply(new BigDecimal(campaignQty)).subtract(campaignPrice).negate();
    }

    @Override
    public CheckoutItem apply(CartItem cartItem) {
        if(Quantity.Type.PCS != cartItem.getQuantity().getType()){
            throw new IllegalArgumentException("Non PCS Quantities are not applicable for QuantityForPriceCampaign");
        }

        Integer campaignBundle = (int) (cartItem.getQuantity().getValue() / campaignQty);
        return new CheckoutItem(this.product.getProductName(), this.discount.multiply(new BigDecimal(campaignBundle)));
    }

}
