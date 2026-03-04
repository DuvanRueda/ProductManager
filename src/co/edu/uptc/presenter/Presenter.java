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
        try {
            return switch (option) {
                case "1"->showProducts();
                case "2"->addProduct();
                case "3"->deleteProduct();
                case "4"->closeApp();
                default -> Constants.TYPING_ERROR;
            };
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String showProducts() {
        return list.showInfo();
    }

    @Override
    public String addProduct() {
        String name = Helper.isBlank(io.inputData(Constants.INPUT_NAME));
        String description = Helper.isBlank(io.inputData(Constants.INPUT_DESCRIPTION));
        String measurementType = Helper.isBlank(io.inputData(Constants.INPUT_MEASUREMENT_TYPE));
        int price = Helper.toInt(io.inputData(Constants.INPUT_PRICE));
        list.addEnd(name,description,measurementType,price);
        return Constants.SUCCESSFUL_PROCESS;
    }

    @Override
    public String deleteProduct() {
            String value = Helper.isBlank(io.inputData(Constants.DELETE_PRODUCT));
            return list.deleteProduct(value);
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
