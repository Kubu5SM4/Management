package api;

import entity.Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ProductDao {

    public void saveProductToFile(Product product) throws IOException;
    public void saveProductsToFile(List<Product> products) throws FileNotFoundException;
    public void removeProductByIdFromFile(Long productId) throws IOException;
    public void removeProductByNameFromFile(String productName) throws IOException;
    public List<Product> getAllProductsFromFile() throws IOException;
    public Product getProductByIdFromFile(Long productId) throws IOException;
    public Product getProductByNameFromFile(String productName) throws IOException;

}
