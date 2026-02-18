package pojo;

public class Product {
    String description;
    String measurementType;
    int price;
    Product sig;


    public Product(String description, String measurementType, int price) {
        this.description = description;
        this.measurementType = measurementType;
        this.price = price;
    }
}
