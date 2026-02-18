package model;

import pojo.Product;

public class ProductListManual implements interfaces.ProductList {

    Product header = null;

    @Override
    public Product createProduct(String value) {
        String[] values = value.split(" ");
        String description = values[0];
        String measurementType = values[1];
        int price = Integer.parseInt(values[2]);
        return new Product(description, measurementType, price);
    }

    @Override
    public Product returnLastProduct() {
        Product last = header;
        while (last.sig!=null){
            last = last.sig;
        }
        return last;
    }

    @Override
    public void addEnd(String value) {
        Product aux = createProduct(value);

        if(header == null){
            header = aux;
        }else{
            Product last = returnLastProduct();
            last.sig = aux;
        }
    }

    @Override
    public String showInfo() {
        Product aux = header;
        String info = "";
        while (aux != null){
            info += toString() + "\n\n";
        }
        return info;
    }
}
