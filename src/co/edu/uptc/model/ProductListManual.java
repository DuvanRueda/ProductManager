package co.edu.uptc.model;

import co.edu.uptc.pojo.Product;

public class ProductListManual implements co.edu.uptc.interfaces.ProductList {

    Product header;

    public ProductListManual(){
        header = null;
    }

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
    public String deleteProduct(String key) {
        Product aux = null;
        return null;
    }

    @Override
    public void sortList() {

    }

    @Override
    public String showInfo() {
        Product aux = header;
        String info = "";
        while (aux != null){
            info += aux.toString() + "\n\n";
            aux = aux.sig;
        }
        return info;
    }
}
