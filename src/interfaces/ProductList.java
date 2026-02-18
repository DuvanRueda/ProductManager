package interfaces;

import pojo.Product;

public interface ProductList {
    public Product createProduct(String value);
    public Product returnLastProduct();
    public void addInit();
    public void addEnd();
    public void showInfo();
}
