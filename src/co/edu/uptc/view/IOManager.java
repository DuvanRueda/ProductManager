package co.edu.uptc.view;

import co.edu.uptc.interfaces.PresenterManager;
import co.edu.uptc.interfaces.ViewManager;
import java.util.Scanner;

public class IOManager implements ViewManager {

    private PresenterManager presenterManager;
    public IOManager(){
        
    }

    @Override
    public void showData(String productList) {
        System.out.println(productList);
    }

    @Override
    public String inputData(String smg) {
        Scanner sc = new Scanner(System.in);
        System.out.println(smg);
        return sc.nextLine();
    }

    @Override
    public void setPresenter(PresenterManager presenter) {
        this.presenterManager = presenter;
    }

    @Override
    public void start() {
        presenterManager.init();
    }

}
