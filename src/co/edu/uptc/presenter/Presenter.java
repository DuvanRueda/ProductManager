package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.PresenterManager;
import co.edu.uptc.interfaces.ProductListInterface;
import co.edu.uptc.interfaces.ViewManager;
import co.edu.uptc.util.Constants;
import co.edu.uptc.util.Helper;

public class Presenter implements PresenterManager {

    private ProductListInterface list;
    private ViewManager io;
    private boolean isFinished;

    public Presenter() {
        isFinished = false;
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
        String name = requestValidString(Constants.INPUT_NAME);
        String description = requestValidString(Constants.INPUT_DESCRIPTION);
        String measurementType = requestValidString(Constants.INPUT_MEASUREMENT_TYPE);
        int price = requestValidInt(Constants.INPUT_PRICE);
        list.addEnd(name,description,measurementType,price);
        return Constants.SUCCESSFUL_PROCESS;
    }

    private String requestValidString(String message) {
        while (true) {
            try {
                return Helper.isBlank(io.inputData(message));
            } catch (IllegalArgumentException e) {
                io.showData(e.getMessage());
            }
        }
    }

    private int requestValidInt(String message) {
        while (true) {
            try {
                return Helper.toInt(io.inputData(message));
            } catch (IllegalArgumentException e) {
                io.showData(e.getMessage());
            }
        }
    }

    @Override
    public String deleteProduct() {
        try {
            String value = Helper.isBlank(io.inputData(Constants.DELETE_PRODUCT));
            return list.deleteProduct(value);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String closeApp() {
        isFinished = true;
        return Constants.CLOSE_APP;
    }

    @Override
    public void init() {
        while (!isFinished){
            String result = io.inputData(Constants.STR_MENU);
            result = menu(result);
            io.showData(result);
        }
    }

    @Override
    public void setView(ViewManager view) {
       io = view;
    }

    @Override
    public void setModel(ProductListInterface list) {
        this.list = list;
    }
}
