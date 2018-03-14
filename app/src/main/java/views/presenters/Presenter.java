package views.presenters;

import com.raziel.tareamvp.domain.domain.IIteratorMvp;
import com.raziel.tareamvp.domain.domain.InteratorMvp;

import java.util.Date;

import views.activities.Iview;

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
    public void showInf(String name, String lastName, Date date) {
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
