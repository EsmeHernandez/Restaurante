package com.example.restaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class pedido extends AppCompatActivity {
    EditText etEnviar;
    Button btnEnviar;

    String [ ] datos= new String[] {"1 coca-cola", "Mojarra frita", "Flan napolitano", "Sopa de mariscos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        etEnviar = findViewById(R.id.editText);
        btnEnviar = findViewById(R.id.button8);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle enviarDatos = new Bundle();
                enviarDatos.putStringArray("keyDatos", datos);

                Intent intent = new Intent(pedido.this, mostrar_pedido.class);
                intent.putExtras(enviarDatos);
                startActivity(intent);

            }
        });


    }
}

