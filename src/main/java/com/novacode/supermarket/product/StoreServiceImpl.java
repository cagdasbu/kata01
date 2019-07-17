package com.novacode.supermarket.product;

import com.novacode.supermarket.checkout.Quantity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Store service acts like an in memoryDb, keeps the product definitions and serves product
 */
public class StoreServiceImpl implements StoreService {

    private static StoreServiceImpl storeService;

    private Map<String, Product> productMap = new HashMap<>();

    private StoreServiceImpl() {
        productMap.put("B", new Product("B", "Beans", new BigDecimal(0.5), Quantity.Type.PCS));
        productMap.put("C", new Product("C", "Coke", new BigDecimal(0.7),  Quantity.Type.PCS));
        productMap.put("O", new Product("O", "Orange", new BigDecimal(1.99), Quantity.Type.KG));
    }

    public static StoreServiceImpl getInstance(){
        if(storeService == null) {
            storeService = new StoreServiceImpl();
        }
        return storeService;
    }

    public Product getProduct(String productId){
        return productMap.get(productId);
    }
}
