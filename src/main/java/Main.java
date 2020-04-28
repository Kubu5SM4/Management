import dao.ProductDaoImpl;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        String productsFile = "products.txt";
        PrintWriter w1 = new PrintWriter(productsFile);
        w1.write(new Product(1l, "tshirt",14.50f,0.20f,"pink",24).toString());
        w1.write(new Product(2l, "shorts",19.50f,0.80f,"blue",14).toString());
        w1.write(new Product(3l, "scarf",32.00f,0.30f,"black",5).toString());
        w1.write(new Product(4l, "vest",58.30f,1.10f,"yellow",40).toString());
        w1.write(new Product(5l, "socks",7.50f,0.50f,"white",100).toString());
        w1.close();


        ProductDaoImpl dao1 = new ProductDaoImpl(productsFile);
        dao1.getAllProductsFromFile();
        dao1.removeProductByNameFromFile("socks");
        ProductDaoImpl dao2 = new ProductDaoImpl(productsFile);
        dao2.removeProductByIdFromFile(3l);
    }
}
