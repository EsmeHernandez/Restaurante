package com.example.restaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {
    public EditText usuario;
    public EditText password;
    public Button salir;
    public Button continuar;

    String log = "Esme", pass = "123", nombre = "Esmeralda Hernández";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        continuar = findViewById(R.id.continuar);
        password = findViewById(R.id.password);
        usuario = findViewById(R.id.usuario);
        salir = findViewById(R.id.salir);
    }

    public void continuar_perfil(View view) {
        Intent perfil = new Intent(login.this, perfil.class);
        String l = usuario.getText().toString();
        String p = password.getText().toString();
        if (log.equals(l) && pass.equals(p)) {
            perfil.putExtra("Nombre", nombre);
            startActivity(perfil);
        }
    }

    public void cambio_inicio(View view) {
        Intent login = new Intent(this, MainActivity.class);
        //i.putExtra("nom",nombres.getText().toString());

        //(MainActivity.class);
    }
}