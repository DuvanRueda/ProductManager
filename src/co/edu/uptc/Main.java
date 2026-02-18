package co.edu.uptc;

import co.edu.uptc.interfaces.PresenterManager;
import co.edu.uptc.presenter.Presenter;

public class Main {
    public static void main(String[] args){
        PresenterManager presenter = new Presenter();
        presenter.init();
    }
}
