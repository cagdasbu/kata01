package com.novacode.supermarket.product;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StoreServiceImplTest {

    @Test
    public void getProduct_Bean() {
        Product product = StoreServiceImpl.getInstance().getProduct("1");
        Assert.assertEquals("1", product.getProductId());
        Assert.assertEquals("Bean", product.getProductName());
    }

    @Test
    public void getProduct_NotFound() {
       Product nillProduct = StoreServiceImpl.getInstance().getProduct("5");
       Assert.assertNull(nillProduct);
    }

}