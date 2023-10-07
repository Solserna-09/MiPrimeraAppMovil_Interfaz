package com.josesantosdev.miprimerapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.josesantosdev.miprimerapp.database.AppDatabase;

public class Login extends AppCompatActivity { //heredando

   private EditText usuario, clave;
   private Button ingresar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = findViewById(R.id.txtUsuario);
        clave = findViewById(R.id.txtClave);
       ingresar = findViewById(R.id.btnIngresar);

     /* ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pulse el botón", Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    public void validarBoton (View view) {

       String usua = usuario.getText().toString();
       String pass = clave.getText().toString();

       if(!usua.isEmpty() && !pass.isEmpty()) {
           AppDatabase database = Room.databaseBuilder(getApplicationContext(),
                   AppDatabase.class, "first-database").allowMainThreadQueries().build();

           User user = database.userDao().getUserByUserName(usua);

           if(user != null) {
               String password = user.password;
               if(password.equals(pass)) {
                   Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
               } else {
                   Toast.makeText(getApplicationContext(), "usuario o clave incorrectos", Toast.LENGTH_SHORT).show();
               }
           } else {
               Toast.makeText(getApplicationContext(), "usuario o clave incorrectos", Toast.LENGTH_SHORT).show();
           }
       } else {
           Toast.makeText(getApplicationContext(), "El campo usuario y contraseña es obligatorio", Toast.LENGTH_SHORT).show();
       }



       /*if (usua.isEmpty() ||pass.isEmpty()){
           Toast.makeText(getApplicationContext(), "usuario o clave vacios", Toast.LENGTH_SHORT).show();

       } else if (usua.equals("solv")&& pass.equals("Sol123")){
           Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
           Intent intent = new Intent(this, Registro.class);
           startActivity(intent);
       }else {
           Toast.makeText(getApplicationContext(), "usuario o clave incorrectos", Toast.LENGTH_SHORT).show();
       }*/
      //  Toast.makeText(getApplicationContext(), "Pulso ingresar", Toast.LENGTH_SHORT).show();
}
}
