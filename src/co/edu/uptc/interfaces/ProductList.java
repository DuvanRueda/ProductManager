package co.edu.uptc.interfaces;

import co.edu.uptc.pojo.Product;

public interface ProductList {
    public Product createProduct(String value);
    public Product returnLastProduct();
    public void addEnd(String value);
    public String deleteProduct(String key);
    public String sortList();
    public String showInfo();
    public int returnLength();
}
