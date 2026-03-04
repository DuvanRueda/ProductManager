package co.edu.uptc.model;

import co.edu.uptc.interfaces.ProductListInterface;
import co.edu.uptc.pojo.Product;
import co.edu.uptc.util.Constants;
import co.edu.uptc.util.Helper;

public class ProductListManual implements ProductListInterface {

    Product header;

    public ProductListManual() {
        header = null;
    }

    @Override
    public Product createProduct(String name, String description, String measurementType, int price) {
        return new Product(name, description, measurementType, price);
    }

    @Override
    public void addEnd(String name, String description, String measurementType, int price) {
        Product aux = createProduct(name, description, measurementType, price);
        if (header == null) {
            header = aux;
        } else {
            Product last = returnLastProduct();
            last.sig = aux;
        }
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
    public String deleteProduct(String key) {
        for (Product current = header, previous = null; current != null; previous = current, current = current.sig) {
            if (current.getName().contains(key)) {
                if (previous == null) header = current.sig;
                else previous.sig = current.sig;
                return Constants.SUCCESSFULLY_REMOVED;
            }
        }
        return Constants.NON_PRODUCT;
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
    public Product[] sortList() {
        int length = returnLength();
        Product[] aux = toList(new Product[length]);
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                    swap(aux,i,j);
            }
        }
        return aux;
    }

    private void swap(Product[] array, int i, int j) {
        Product temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }



    @Override
    public String showInfo() {
        if(header == null)
            return Constants.SIZE_ERROR;
        Product[] aux = sortList();
        String info = "";
        for (int i = 0; i < aux.length; i++) {
            info += getProductInfo(aux[i]);
        }
        return info;
    }


}