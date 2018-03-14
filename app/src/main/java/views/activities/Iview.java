package views.activities;

/**
 * Created by raziel on 11/03/18.
 */

public interface Iview {
    void mostrarLoading();

    void ocultarLoading();

    void onClickInfo();

    void mostrarError(String msg);

    void mostrarInfo(String info);
}
