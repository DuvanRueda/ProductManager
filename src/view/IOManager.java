package view;

import interfaces.ViewManager;
import java.util.Scanner;

public class IOManager implements ViewManager {
    public IOManager(){
        
    }

    @Override
    public void showList(String productList) {
        System.out.println(productList);
    }

    @Override
    public String fetchProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto:");
        return sc.nextLine();
    }

}
