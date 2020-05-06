package api;
import entity.Product;
import java.util.List;
public interface ProductService {

    public List<Product> getAllProducts();
    public Integer howManyProductsWeHave();
    public Product getProductByProductName(String productName);
    public boolean doWeHaveProductByName(String productName);
    public boolean doesProductExistByName(String productName);
    public boolean doesProductExistById(Long productId);



}
