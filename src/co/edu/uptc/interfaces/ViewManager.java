package co.edu.uptc.interfaces;

public interface ViewManager {
    public void showData(String productList);
    public String inputData(String msg);

    void setPresenter(PresenterManager presenter);
    void start();
}
