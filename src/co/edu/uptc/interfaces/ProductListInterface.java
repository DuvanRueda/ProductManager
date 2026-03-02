package co.edu.uptc.interfaces;

import co.edu.uptc.pojo.Product;
import co.edu.uptc.util.Constants;

public interface ProductListInterface {
    public Product createProduct(String value);
    public Product returnLastProduct();
    public void addEnd(String value);
    public String deleteProduct(String key);
    public Product[] sortList();
    public String showInfo();
    public int returnLength();

    default String getProductInfo(Product product){
        return Constants.NAME + product.getName() + "\n" + Constants.DESCRIPTION + product.getDescription() + "\n" + Constants.PRICE + product.getPrice()+"/"+product.getMeasurementType();
    }
}
