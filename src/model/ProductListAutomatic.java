package model;

import interfaces.ProductList;
import pojo.Product;

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
    public String showInfo() {
        return "";
    }
}
