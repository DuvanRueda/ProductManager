package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.PresenterManager;
import co.edu.uptc.interfaces.ProductList;
import co.edu.uptc.interfaces.ViewManager;
import co.edu.uptc.model.ProductListManual;
import co.edu.uptc.util.Constants;
import co.edu.uptc.view.IOManager;

public class Presenter implements PresenterManager {

    private ProductList list;
    private ViewManager io;
    private boolean isFiniseh;

    public Presenter() {
        list = new ProductListManual();
        io = new IOManager();
        isFiniseh = false;
    }

    //    @Override
    public String menu(String option) {
        return switch (option) {
            case "1"->showProducts();
            case "2"->addProduct();
            case "3"->deleteProduct();
            case "4"->closeApp();
            default -> Constants.TYPING_ERROR;
        };
    }

    @Override
    public String showProducts() {
        return list.showInfo();
    }

    @Override
    public String addProduct() {
        String values = io.inputData(Constants.ENTRANCE_EXAMPLE);
        list.addEnd(values);
        return Constants.SUCCESSFUL_PROCESS;
    }

    @Override
    public String deleteProduct() {
        return Constants.SUCCESSFUL_PROCESS;
    }

    @Override
    public String closeApp() {
        isFiniseh = true;
        return Constants.CLOSE_APP;
    }

    @Override
    public void init() {
        while (!isFiniseh){
            String result = io.inputData(Constants.STR_MENU);
            result = menu(result);
            io.showData(result);
        }
    }
}
