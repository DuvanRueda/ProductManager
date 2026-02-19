package co.edu.uptc.model;

import co.edu.uptc.pojo.Product;

public class ProductListManual implements co.edu.uptc.interfaces.ProductList {

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
        sortList();
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

                Product nextProduct = current.sig;

                if (current.getName()
                        .compareToIgnoreCase(nextProduct.getName()) > 0) {

                    String tempName = current.getName();
                    String tempDescription = current.getDescription();
                    String tempMeasurementType = current.getMeasurementType();
                    int tempPrice = current.getPrice();

                    current.setName(nextProduct.getName());
                    current.setDescription(nextProduct.getDescription());
                    current.setMeasurementType(nextProduct.getMeasurementType());
                    current.setPrice(nextProduct.getPrice());

                    nextProduct.setName(tempName);
                    nextProduct.setDescription(tempDescription);
                    nextProduct.setMeasurementType(tempMeasurementType);
                    nextProduct.setPrice(tempPrice);
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
        while (aux != null) {
            info += getProductInfo(aux) + "\n\n";
            aux = aux.sig;
        }
        return info;
    }


}
