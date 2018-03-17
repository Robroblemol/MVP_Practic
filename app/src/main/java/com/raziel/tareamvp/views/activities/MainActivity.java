package com.raziel.tareamvp.views.activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;


import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.raziel.tareamvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.raziel.tareamvp.views.presenters.IPresenter;
import com.raziel.tareamvp.views.presenters.Presenter;

public class MainActivity extends AppCompatActivity implements Iview {

    @BindView(R.id.txtNombre)
    EditText txtNombre;
    @BindView(R.id.txtApellido)
    EditText txtApellido;
    //@BindView(R.id.txtFecha)
    //EditText txtFecha;
    @BindView (R.id.datePicker)
    DatePicker dPicker;
    @BindView(R.id.btnCalcular)
    Button btnCalcular;


    private IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new Presenter(this);


       // Toast.makeText(this, "Test Toast", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarLoading() {
        //progress mostrar
        Log.i("MainActivity", "Mostrando Loading");

    }

    @Override
    public void ocultarLoading() {
        //progress ocultar
        Log.i("MainActivity", "Ocultando Loading");
    }

    @OnClick(R.id.btnCalcular)
    public void onClickInfo() {
        /* Toast.makeText(this, "Me presionaron!!!", Toast.LENGTH_SHORT).show(); */
        //Log.i("MainActivity", "date: "+date);

        MaterialDialog.Builder builder = new MaterialDialog.Builder(this)
                .positiveText(R.string.agree)
                .negativeText(R.string.disagree)
                .title(R.string.title)
                .content(R.string.content)
               .onPositive(new MaterialDialog.SingleButtonCallback() {
                   @Override
                   public void onClick( MaterialDialog dialog, DialogAction which) {
                       String name = txtNombre.getText().toString();
                       String lastName = txtApellido.getText().toString();
                       int date = dPicker.getYear();
                       presenter.showInf(name,lastName,date);
                   }
               })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(MaterialDialog dialog, DialogAction which) {
                        presenter.showNegativeAnwer();
                    }
                });

        MaterialDialog dialog =builder.build();

        dialog.show();

        //presenter.showInf(name,lastName,date);

    }

    @Override
    public void mostrarError(String msg) {

        Toast.makeText(this,
                msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarInfo(String info) {
        Log.i("MainActivity",""+info);
        Toast.makeText(this,
                " " + info, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showNegativeAnwer() {
        Toast.makeText(this,
                "Ok registro cancelado", Toast.LENGTH_LONG).show();
    }
}
