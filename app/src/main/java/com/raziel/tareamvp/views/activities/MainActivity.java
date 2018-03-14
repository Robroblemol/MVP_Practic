package com.raziel.tareamvp.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.raziel.tareamvp.R;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.raziel.tareamvp.views.presenters.IPresenter;
import com.raziel.tareamvp.views.presenters.Presenter;

public class MainActivity extends AppCompatActivity implements Iview {

    @BindView(R.id.btnCalcular)
    Button btnCalcular;
    @BindView(R.id.txtNombre)
    EditText txtNombre;
    @BindView(R.id.txtApellido)
    EditText txtApellido;
    @BindView(R.id.txtFecha)
    EditText txtFecha;

    private IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new Presenter(this);

        Toast.makeText(this, "Test Toast", Toast.LENGTH_SHORT).show();
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
        Toast.makeText(this, "Me presionaron!!!", Toast.LENGTH_SHORT).show();
        Log.i("MainActivity", ">>> Presionado calcular");
        String name = txtNombre.getText().toString();
        String lastName = txtApellido.getText().toString();
        Date date = (Date) txtFecha.getText();

        presenter.showInf(name,lastName,date);

    }

    @Override
    public void mostrarError(String msg) {

        Toast.makeText(this,
                msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarInfo(String info) {
        Toast.makeText(this,
                "La suma es:" + info, Toast.LENGTH_SHORT).show();
    }
}
