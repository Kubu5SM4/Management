package api;
import entity.Product;
import java.util.List;
public interface ProductService {

    public List<Product> getAllProducts();
    public int howManyProductsWeHave();
    public Product getProductByProductName(String productName);
    public boolean doWeHaveProductByName(String productName);
    public boolean doesProductExistByName(String productName);
    public boolean doesProductExistById(Long productId);



}
