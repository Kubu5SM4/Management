package dao;

import entity.Product;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ProductDaoImpl {

    public List<Product> getAllProducts() throws IOException {

        List<Product> products = new ArrayList<Product>();
        String productsFileName = "products.txt";
        FileReader productsFileReader = new FileReader(productsFileName);
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
    }

