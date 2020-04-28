package service;

import entity.Product;
import org.junit.Test;
import org.junit.Assert;
import java.util.List;
import java.util.ArrayList;

public class ProductServiceTest {

    @Test
    public void testGetAllProducts(){
        // is
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l, "Scarf", 2.0f, 1.0f, "green", 10));
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        //expected
        Assert.assertEquals(products,productService.getAllProducts());
    }

    @Test
    public void testHowManyProducts(){
        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Product (1l, "Scarf", 2.0f, 1.0f, "green", 10));
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        int result = productService.howManyProductsWeHave();
        //expected
        Assert.assertEquals(1l, result);
    }

    @Test
    public void testHowManyProductsIfZero() {
        //is
        List<Product> products = new ArrayList<Product>();
        //then
        ProductServiceImpl productService = new ProductServiceImpl();
        int result = productService.howManyProductsWeHave();
        //expected
        Assert.assertEquals(0, result);
    }

    @Test
    public void testGetProductByProductName(){
        //is
        List<Product> products = new ArrayList<Product>();
        Product scarf = new Product(1l, "Scarf", 2.0f, 1.0f, "green", 10);
        products.add(scarf);
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        Product result = productService.getProductByProductName("Scarf");
        //expected
        Assert.assertEquals(scarf,result);
    }

    @Test
    public void testGetProductByProductNameIfThereIsNone() {
        //is
        List<Product> products = new ArrayList<Product>();
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        Product result = productService.getProductByProductName("Scarf");
        //expected
        Assert.assertEquals(null, result);
    }

    @Test
    public void testDoWeHaveProductByNameYes(){
        //is
        List<Product> products = new ArrayList<Product>();
        Product scarf = new Product(1l, "Scarf", 2.0f, 1.0f, "green", 10);
        products.add(scarf);
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean result= productService.doWeHaveProductByName("Scarf");
        //expected
        Assert.assertTrue(result);
    }

    @Test
    public void testDoWeHaveProductByNameNo(){
        //is
        List<Product> products = new ArrayList<Product>();
        Product scarf = new Product(1l, "Scarf", 2.0f, 1.0f, "green", 0);
        products.add(scarf);
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean result= productService.doWeHaveProductByName("Scarf");
        //expected
        Assert.assertFalse(result);
    }

    @Test
    public void testDoesProductExistByNameYes(){
        //is
        List<Product> products = new ArrayList<Product>();
        Product scarf = new Product(1l, "Scarf", 2.0f, 1.0f, "green", 0);
        products.add(scarf);
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean result = productService.doesProductExistByName("Scarf");
        //expected
        Assert.assertTrue(result);
    }

    @Test
    public void testDoesProductExistByNameNo(){
        //is
        List<Product> products = new ArrayList<Product>();
        Product scarf = new Product(1l, "Scarf", 2.0f, 1.0f, "green", 0);
        products.add(scarf);
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean result = productService.doesProductExistByName("Boots");
        //expected
        Assert.assertFalse(result);
    }

    @Test
    public void testDoesProductExistByIdYes() {
        //is
        List<Product> products = new ArrayList<Product>();
        Product scarf = new Product(1l, "Scarf", 2.0f, 1.0f, "green", 0);
        products.add(scarf);
        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean result = productService.doesProductExistById(1l);
        //expected
        Assert.assertTrue(result);
    }

    @Test
    public void testDoesProductExistByIdNo(){
        //is
        List<Product> products = new ArrayList<Product>();

        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean result = productService.doesProductExistByName("Boots");
        //expected
        Assert.assertFalse(result);
    }





}

