package model;

import pojo.Product;

public class ProductList implements interfaces.ProductList {

    Product header = null;

    @Override
    public Product createProduct(String value) {
        String[] values = value.split(" ");
        String description = values[0];
        String measurementType = values[1];
        int price = Integer.valueOf(values[2]);
        return new Product(description, measurementType, price);
    }

    @Override
    public Product returnLastProduct() {
        return null;
    }

    @Override
    public void addInit() {

    }

    @Override
    public void addEnd() {

    }

    @Override
    public void showInfo() {

    }
}
