package co.edu.uptc.model;

import co.edu.uptc.interfaces.ProductListInterface;
import co.edu.uptc.pojo.Product;
import co.edu.uptc.util.Constants;
import java.util.ArrayList;
import java.util.Comparator;

public class ProductListAutomatic implements ProductListInterface{
    ArrayList<Product> list = new ArrayList<>();

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
        return null;
    }

    @Override
    public void addEnd(String value) {
        Product aux = createProduct(value);
        list.addLast(aux);
    }

    @Override
    public String deleteProduct(String key) {
        for (Product product : list) {
            if (product.getName().contains(key)) {
                list.remove(list.indexOf(product));
            }
        }
        return Constants.SUCCESSFULLY_REMOVED;
    }

    @Override
    public Product[] sortList() {
        ArrayList<Product> aux = list;
        aux.sort(Comparator.comparing(Product::getName));
        return aux.toArray(new Product[0]);
    }

    @Override
    public String showInfo(){
        if(returnLength()<=0){
            return Constants.SIZE_ERROR;
        }
        Product[] aux = sortList();
        
        String info = "";
        for (int i = 0; i < returnLength(); i++) {
            info += aux[i].getName()+"   "+ aux[i].getDescription()+"   "+aux[i].getMeasurementType()+"   "+ aux[i].getPrice()+"\n";
        }
        return info;
    }

    @Override
    public int returnLength() {
        return list.size();
    }
}
