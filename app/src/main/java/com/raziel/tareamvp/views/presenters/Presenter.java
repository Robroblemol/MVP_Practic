package com.raziel.tareamvp.views.presenters;

import com.raziel.tareamvp.domain.IIteratorMvp;
import com.raziel.tareamvp.domain.InteratorMvp;

import com.raziel.tareamvp.views.activities.Iview;

/**
 * Created by raziel on 11/03/18.
 */

public class Presenter implements  IPresenter{

    private Iview view;
    private IIteratorMvp mvp;

    public Presenter(Iview view){
        this.view = view;
        mvp = new InteratorMvp();
    }
    @Override
    public void showNegativeAnwer(){
        view.showNegativeAnwer();
    }
    @Override
    public void showDate(){
        view.showDate();
    }
    @Override
    public void showInf(String name, String lastName, String date) {
        try{
            view.mostrarLoading();
            String info = mvp.showInf(name,lastName, date);
            view.ocultarLoading();
            view.mostrarInfo(info);
        }catch (Exception e){
            view.mostrarError(e.getMessage());
        }
    }

}
