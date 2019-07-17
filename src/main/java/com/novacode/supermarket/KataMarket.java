package com.novacode.supermarket;

import com.novacode.supermarket.checkout.*;
import com.novacode.supermarket.product.Product;
import com.novacode.supermarket.product.StoreService;
import com.novacode.supermarket.product.StoreServiceImpl;

import java.util.logging.Logger;

/**
 *
 */
public class KataMarket {

    private static Logger logger = Logger.getLogger(KataMarket.class.getName());

    public static void main(String[] args) {
        if(args.length == 0) {
            logger.info("No Order Acquired ");
            System.exit(0);
        }

        logger.info("Kata Market Order Acquired ");

        ShoppingCart cart = new ShoppingCart();
        StoreService storeService = StoreServiceImpl.getInstance();

        for(String order : args){
            String[] ordersDetails = order.split(":");
            if(ordersDetails.length != 2) {
                logger.warning(String.format("Incorrect order format %s",order));
            }
            Product product = storeService.getProduct(ordersDetails[0]);
            Quantity quantity;
            if(product.getQuantityType() == Quantity.Type.PCS) {
                quantity = new CountableQuantity(Integer.parseInt(ordersDetails[1]), Quantity.Type.PCS);
            } else {
                quantity = new ScalableQuantity(Double.parseDouble(ordersDetails[1]), Quantity.Type.PCS);

            }
            cart.add(storeService.getProduct(ordersDetails[0]), quantity);
        }

        logger.info("Checking out...");

        Bill bill = cart.checkout();
        System.out.println(bill);
    }
}
