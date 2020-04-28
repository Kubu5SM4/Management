package dao;

import entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ProductDaoImpl implements api.ProductDao {

    String fileName;
    //String productType;

    public ProductDaoImpl(String fileName) throws IOException {
        this.fileName = fileName;
        //this.productType=productType;
        //File.createNewFile(fileName);
    }

    public List<Product> getAllProductsFromFile() throws IOException {

        List<Product> products = new ArrayList<Product>();
        FileReader productsFileReader = new FileReader(fileName);
        BufferedReader productsReader = new BufferedReader(productsFileReader);
        //  typowy produkt: 1l-buty-14.50-2.5-red-5
        String readOneLine = productsReader.readLine();
        while(readOneLine!=null) {

            String holder[] = readOneLine.split("-");

            Long id = Long.parseLong(holder[0]);
            String name = holder[1];
            Float price = Float.parseFloat(holder[2]);
            Float weight = Float.parseFloat(holder[3]);
            String color = holder[4];
            Integer productCount = Integer.parseInt(holder[5]);

            products.add(new Product(id, name, price, weight, color, productCount));
            readOneLine = productsReader.readLine();
        }
        productsReader.close();
        return products;

    }

    public void saveProductToFile (Product product) throws IOException {
        FileOutputStream productOutputStream = new FileOutputStream(fileName);
        PrintWriter productWriter = new PrintWriter(productOutputStream);
        productWriter.write(product.toString());
        productWriter.close();
    }

    public void saveProductsToFile(List<Product> products) throws IOException {
        //FileOutputStream productsOutputStream = new FileOutputStream(fileName);
        PrintWriter productsWriter = new PrintWriter(fileName);
        for(Product product:products){
            productsWriter.write(product.toString());
        }
        productsWriter.close();
    }

    public void removeProductByIdFromFile(Long productId) throws IOException {
        List<Product> products = getAllProductsFromFile();
        for(Product productx:products){
            if(productx.getId() == productId){
                products.remove(productx);
            }
            saveProductsToFile(products);
        }
    }

    public void removeProductByNameFromFile (String productName) throws IOException {
        List<Product> products = getAllProductsFromFile();
        for(Product product:products){
            if(product.getProductName().equals(productName)){
            products.remove(product);
            }
            saveProductsToFile(products);
        }
    }

    public Product getProductByIdFromFile (Long productId) throws IOException{
        List<Product> products = getAllProductsFromFile();
        for(Product product:products){
            if(product.getId().equals(productId)){
                return product;
            }
        }
        return null;
    }

    public Product getProductByNameFromFile (String productName) throws IOException{
        List<Product> products = getAllProductsFromFile();
        for(Product product:products){
            if(product.getProductName().equals(productName)){
                return product;
            }
        }
        return null;
    }


}

