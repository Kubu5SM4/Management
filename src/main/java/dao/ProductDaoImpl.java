package dao;

import entity.Product;
import entity.parser.ProductParser;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ProductDaoImpl implements api.ProductDao {

    String fileName;
    String productType;

    public ProductDaoImpl(String fileName, String productType) throws IOException {
        this.fileName = fileName;
        this.productType=productType;
        FileUtils.createNewFile(fileName);
    }

    public List<Product> getAllProductsFromFile() throws IOException {

        List<Product> products = new ArrayList<Product>();
        FileReader productsFileReader = new FileReader(fileName);
        BufferedReader productsReader = new BufferedReader(productsFileReader);
        //  typowy produkt: 1l-buty-14.50-2.5-red-5
        String readLine = productsReader.readLine();
        while(readLine != null) {
            Product product = ProductParser.stringToProduct(readLine, productType);
            if(product!=null){
                products.add(product);
            }
            readLine=productsReader.readLine();
        }
        productsReader.close();
        return products;
    }

    public void saveProductToFile (Product product) throws IOException {
        List<Product> products = getAllProductsFromFile();
        products.add(product);
        saveProductsToFile(products);
    }

    public void saveProductsToFile(List<Product> products) throws FileNotFoundException {
        //FileOutputStream productsOutputStream = new FileOutputStream(fileName);
        FileUtils.clearFile(fileName);
        PrintWriter productsWriter = new PrintWriter(fileName);
        for(Product product:products){
            productsWriter.write(product.toString());
        }
        productsWriter.close();
    }

    public void removeProductByIdFromFile(Long productId) throws IOException {
        List<Product> products = getAllProductsFromFile();
        for(Product productX:products){
            if(productX.getId() == productId){
                products.remove(productX);
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

