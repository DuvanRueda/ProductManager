package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.PresenterManager;
import co.edu.uptc.interfaces.ProductListInterface;
import co.edu.uptc.interfaces.ViewManager;
import co.edu.uptc.model.ProductListManual;
import co.edu.uptc.view.IOManager;

public class Runner {
    PresenterManager presenter;
    ProductListInterface list;
    ViewManager view;

    private void makeMVP(){
         presenter = new Presenter();
         list = new ProductListManual();
         view = new IOManager();

        presenter.setModel(list);
        presenter.setView(view);
        view.setPresenter(presenter);
    }

    public void start(){
        makeMVP();
        view.start();
    }
}
