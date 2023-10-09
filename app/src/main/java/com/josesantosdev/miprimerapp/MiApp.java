package com.josesantosdev.miprimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MiApp extends AppCompatActivity {


    private Button iniciarSesion, registarme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_app);

        iniciarSesion = findViewById(R.id.btnIniciarSesion);
        registarme = findViewById(R.id.btnRegistro);
    }

    public void validarBotonInicio(View view) {

        if (iniciarSesion.isClickable()) {
            Toast.makeText(getApplicationContext(), "iniciar sesión", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);

        }

}
    public void validarBotonReg(View view) {
        if (registarme.isClickable()) {
            Toast.makeText(getApplicationContext(), "registrate", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Registro.class);
            startActivity(intent);

        }
    }
}


