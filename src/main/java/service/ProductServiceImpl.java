package service;
import entity.Product;
import java.util.List;
import java.util.ArrayList;

public class ProductServiceImpl {
    List<Product> products;

    public ProductServiceImpl(){
        this.products = new ArrayList<Product>();
    }

    public ProductServiceImpl(List<Product> products){
        this.products = products;
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public int howManyProductsWeHave(){
        return products.size();
    }

    public Product getProductByProductName(String productName){
        for(Product product:products){
            if(product.getProductName() == productName){
                return product;
            }
        }
        return null;
    }

    public boolean doWeHaveProductByName(String productName){
        for(Product product:products){
            if(product.getProductName() == productName){
                if(product.getProductCount()>0){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean doesProductExistByName(String productName){
        for(Product product:products){
            if(product.getProductName() == productName){
                return true;
            }
        }
        return false;
    }

    public boolean doesProductExistById(Long id){
        for(Product product:products){
            if(product.getId() == id){
                return true;
            }
        }
        return false;
    }



}
