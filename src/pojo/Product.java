package pojo;

public class Product {
    String description;
    String measurementType;
    int price;
    public Product sig; //Está bien poner este parametro como public o deberiamos usar un get?


    public Product(String description, String measurementType, int price) {
        this.description = description;
        this.measurementType = measurementType;
        this.price = price;
    }

    @Override
    public String toString(){

        return "Descripción: " + description + "\n" + "Precio: " + price + "/" + measurementType;


    }
}
