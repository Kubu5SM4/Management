package entity.parser;

import entity.Boots;
import entity.Cloth;
import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductParser {
    public static Product stringToProduct(String productStr, String productType) {
        if (productType.equals("PRODUCT")) {
            return convertToProduct(productStr);
        } else if (productType.equals("CLOTH")) {
            return convertToCloth(productStr);
        } else if (productType.equals("BOOTS")) {
            return convertToBoots(productStr);
        }
        return null;

    }

    public static Product convertToProduct(String productLine){
        String [] productInfo = productLine.split("-");
        Long id = Long.parseLong(productInfo[0]);
        String productName = productInfo[1];
        Float price = Float.parseFloat(productInfo[2]);
        Float weight = Float.parseFloat(productInfo[3]);
        String color = productInfo[4];
        Integer productCount = Integer.parseInt(productInfo[5]);

        return new Product(id,productName,price,weight,color,productCount);
    }

    public static Cloth convertToCloth(String productLine){
        String [] productInfo = productLine.split("-");
        Long id = Long.parseLong(productInfo[0]);
        String productName = productInfo[1];
        Float price = Float.parseFloat(productInfo[2]);
        Float weight = Float.parseFloat(productInfo[3]);
        String color = productInfo[4];
        Integer productCount = Integer.parseInt(productInfo[5]);
        String size = productInfo[6];
        String material = productInfo[7];

        return new Cloth(id,productName,price,weight,color,productCount,size,material);
    }

    public static Boots convertToBoots (String productLine){
        String [] productInfo = productLine.split("-");
        Long id = Long.parseLong(productInfo[0]);
        String productName = productInfo[1];
        Float price = Float.parseFloat(productInfo[2]);
        Float weight = Float.parseFloat(productInfo[3]);
        String color = productInfo[4];
        Integer productCount = Integer.parseInt(productInfo[5]);
        Integer size = Integer.parseInt(productInfo[6]);
        Boolean isNaturalSkin = Boolean.parseBoolean(productInfo[7]);

        return new Boots(id,productName,price,weight,color,productCount,size,isNaturalSkin);
    }

}
