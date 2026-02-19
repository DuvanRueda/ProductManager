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
        String name = values[3];
        return new Product(description, measurementType, price, name);
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
    public int returnLength() {
        Product last = header;
        int length = 1;
        while (last.sig!=null){
            last = last.sig;
            length++;
        }
        return length;
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
    public String sortList() {//pasar esto a String y mandarlo a la vista
        
    if (header == null || header.sig == null) {
        return header.toString();
    }

    int length = returnLength();

    for (int i = 0; i < length - 1; i++) {

        Product current = header;

        for (int j = 0; j < length - 1 - i; j++) {

            Product nextNode = current.sig;

            if (current.getName()
                    .compareToIgnoreCase(nextNode.getName()) > 0) {

                String tempName = current.getName();
                current.setName(nextNode.getName());
                nextNode.setName(tempName);
            }

            current = current.sig;
        }
    }
    StringBuilder result = new StringBuilder();
    Product temp = header;

    while (temp != null) {
        result.append(temp.toString()).append("\n");
        temp = temp.sig;
    }

    return result.toString();
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
