package api;

import entity.Product;

import java.util.List;

public interface ProductDao {

    public void saveProduct(Product product);
    public void saveProducts(List<Product> products);
    public void removeProductsById(Long productId);
    public void removeProductByName(String productName);
    public List<Product> getAllProductsFromFile();
    public Product getProductByIdFromFile(Long productId);
    public Product getProductByNameFromFile(String productName);

}
