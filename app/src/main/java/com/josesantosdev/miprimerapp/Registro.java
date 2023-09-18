package com.josesantosdev.miprimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {


    private EditText nombres, apellidos, cedula, correo, usuarioNuevo, claveNuevo;
    private Button registrarme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        nombres = findViewById(R.id.txtNombres);
        apellidos = findViewById(R.id.txtApellidos);
        cedula = findViewById(R.id.txtCedula);
        correo = findViewById(R.id.txtCorreo);
        usuarioNuevo = findViewById(R.id.txtUsuarioNuevo);
        claveNuevo = findViewById(R.id.txtClaveNuevo);
        registrarme = findViewById(R.id.btnRegistrarme);


        /*registarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pulse el botón", Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    public void validar(View view) {
        String nombre = nombres.getText().toString();
        String apellido = apellidos.getText().toString();
        String identificacion = cedula.getText().toString();
        String email = correo.getText().toString();
        String user = usuarioNuevo.getText().toString();
        String pass = claveNuevo.getText().toString();


        Toast.makeText(getApplicationContext(), "Pulso registrarme", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}