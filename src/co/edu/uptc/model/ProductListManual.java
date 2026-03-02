package co.edu.uptc.model;

import co.edu.uptc.interfaces.ProductListInterface;
import co.edu.uptc.pojo.Product;
import co.edu.uptc.util.Constants;

public class ProductListManual implements ProductListInterface {

    Product header;

    public ProductListManual() {
        header = null;
    }

    @Override
    public Product createProduct(String value) {
        String[] values = value.split(" ");
        String name = values[0];
        String description = values[1];
        String measurementType = values[2];
        int price = Integer.parseInt(values[3]);
        return new Product(name, description, measurementType, price);
    }

    @Override
    public Product returnLastProduct() {
        Product last = header;
        while (last.sig != null) {
            last = last.sig;
        }
        return last;
    }

    @Override
    public int returnLength() {
        Product last = header;
        int length = 1;
        while (last.sig != null) {
            last = last.sig;
            length++;
        }
        return length;
    }

    @Override
    public void addEnd(String value) {
        Product aux = createProduct(value);

        if (header == null) {
            header = aux;
        } else {
            Product last = returnLastProduct();
            last.sig = aux;
        }
    }

    @Override
    public String deleteProduct(String key) {
        Product previusProduct = null;
        Product current = header;
        while (current!=null){
            if (current.getName().contains(key) && current.equals(header)){
                header = current.sig;
                return Constants.SUCCESSFULLY_REMOVED;
            } else if (current.getName().contains(key)){
                previusProduct.sig = current.sig;
                return Constants.SUCCESSFULLY_REMOVED;
            }
            previusProduct = current;
            current = current.sig;
        }
        return Constants.SUCCESSFULLY_REMOVED;
    }

    private Product[] toList(Product[] list){
        Product current = header;
        for (int i = 0; i < list.length; i++) {
            list[i] = current;
            current = current.sig;
        }
        return list;
    }

    @Override
    public Product[] sortList() {//pasar esto a String y mandarlo a la vista
        int length = returnLength();
        Product[] aux = toList(new Product[length]);
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (aux[j].getName().compareTo(aux[j + 1].getName()) < 0) {
                    Product temp = aux[j];
                    aux[j] = aux[j + 1];
                    aux[j + 1] = temp;
                }
            }
        }
        return aux;
    }

    @Override
    public String showInfo() {
        if(header == null){
            return Constants.SIZE_ERROR;
        }
        Product[] aux = sortList();

        String info = "";
        for (int i = 0; i < aux.length; i++) {
            info += getProductInfo(aux[i]);
        }
        return info;
    }


}