package com.novacode.supermarket.product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Store service acts like an in memoryDb, keeps the product definitions and serves product
 */
public class StoreService {

    private static StoreService storeService;

    private Map<String, Product> productMap = new HashMap<>();

    private StoreService() {
        productMap.put("1", new Product("1", "Beans", new BigDecimal(0.5)));
        productMap.put("2", new Product("2", "Coke", new BigDecimal(0.7)));
        productMap.put("3", new Product("3", "Orange", new BigDecimal(1.99)));
    }

    public static StoreService getInstance(){
        if(storeService == null) {
            storeService = new StoreService();
        }
        return storeService;
    }

    public Product getProduct(String productId){
        return productMap.get(productId);
    }
}
