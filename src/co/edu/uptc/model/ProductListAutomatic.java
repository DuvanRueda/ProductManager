package co.edu.uptc.model;

import co.edu.uptc.interfaces.ProductList;
import co.edu.uptc.pojo.Product;

public class ProductListAutomatic implements ProductList {
    @Override
    public Product createProduct(String value) {
        return null;
    }

    @Override
    public Product returnLastProduct() {
        return null;
    }

    @Override
    public void addEnd(String value) {

    }

    @Override
    public String deleteProduct(String key) {

        return null;
    }

    @Override
    public void sortList() {

    }

    @Override
    public String showInfo() {
        return "";
    }
}
