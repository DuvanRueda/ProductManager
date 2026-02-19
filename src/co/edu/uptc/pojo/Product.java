package co.edu.uptc.pojo;

import co.edu.uptc.util.Constants;

public class Product {
    String name;
    String description;
    String measurementType;
    int price;
    public Product sig; //Está bien poner este parametro como public o deberiamos usar un get?


    public Product(String description, String measurementType, int price, String name) {
        this.description = description;
        this.measurementType = measurementType;
        this.price = price;
        this.name = name;
    }

    



    @Override
    public String toString(){

            return Constants.DESCRIPTION + description + "\n" + Constants.PRICE + price + "/" + measurementType;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
