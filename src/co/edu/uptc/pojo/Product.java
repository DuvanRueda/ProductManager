package co.edu.uptc.pojo;

import co.edu.uptc.util.Constants;

public class Product {
    String name;
    String description;
    String measurementType;
    int price;
    public Product sig; //Está bien poner este parametro como public o deberiamos usar un get?


    public Product(String name, String description, String measurementType, int price) {
        this.description = description;
        this.measurementType = measurementType;
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public String getMeasurementType(){
        return measurementType;
    }

    public int getPrice(){
        return price;
    }
}
