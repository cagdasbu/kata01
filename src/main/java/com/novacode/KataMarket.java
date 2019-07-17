package com.novacode;

import com.novacode.supermarket.checkout.Bill;
import com.novacode.supermarket.checkout.ShoppingCart;
import com.novacode.supermarket.product.StoreService;
import com.novacode.supermarket.product.StoreServiceImpl;

import java.util.logging.Logger;

/**
 *
 */
public class KataMarket {

    private static Logger logger = Logger.getLogger(KataMarket.class.getName());

    public static void main(String[] args) {
        logger.info("Kata Market Order Acquired");

        ShoppingCart cart = new ShoppingCart();
        StoreService storeService = StoreServiceImpl.getInstance();
        cart.add(storeService.getProduct("1"));
        cart.add(storeService.getProduct("1"));
        cart.add(storeService.getProduct("2"));
        cart.add(storeService.getProduct("2"));
        cart.add(storeService.getProduct("3"));

        logger.info("Checking out...");

        Bill bill = cart.checkout();
        System.out.println(bill);
    }
}
