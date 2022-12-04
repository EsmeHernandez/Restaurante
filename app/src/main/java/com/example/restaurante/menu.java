package com.example.restaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.zxing.integration.android.IntentIntegrator;

public class menu extends AppCompatActivity {
    Button btnscan;
    EditText txtresultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnscan = findViewById(R.id.btnscan);
        txtresultado = findViewById(R.id.txtresultado);

        btnscan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                IntentIntegrator integrador=new IntentIntegrator(menu.this);
                integrador.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrador.setPrompt("Lector - CDP");
                integrador.setCameraId(0);
                integrador.setBeepEnabled(true);
                integrador.setBarcodeImageEnabled(true);
                integrador.initiateScan();
            }
        });

        }
    }
