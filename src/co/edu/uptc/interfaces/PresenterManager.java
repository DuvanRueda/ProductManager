package co.edu.uptc.interfaces;

public interface PresenterManager {
//    void menu(String option);
    String showProducts();
    String addProduct();
    String deleteProduct();
    String closeApp();
    void init();

    public void setView(ViewManager view);
    public void setModel(ProductListInterface list);

}
