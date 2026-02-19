package co.edu.uptc.interfaces;

import co.edu.uptc.pojo.Product;
import co.edu.uptc.util.Constants;

public interface ProductList {
    public Product createProduct(String value);
    public Product returnLastProduct();
    public void addEnd(String value);
    public String deleteProduct(String key);
    public String sortList();
    public String showInfo();
    public int returnLength();

    default  String getProductInfo(Product product){
        return Constants.NAME + product.getName() + "\n" + Constants.DESCRIPTION + product.getDescription() + "\n" + Constants.PRICE + product.getPrice()+"/"+product.getMeasurementType();
    }
}
