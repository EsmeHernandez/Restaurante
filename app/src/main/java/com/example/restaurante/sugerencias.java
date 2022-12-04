package com.example.restaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class sugerencias extends AppCompatActivity {
    ImageView ivCodigoQR;
    EditText etDatos;
    Button btnGenerar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencias);
        ivCodigoQR=findViewById(R.id.ivqr);
        etDatos= findViewById(R.id.etDatos);
        btnGenerar=findViewById(R.id.generar);
        btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.encodeBitmap(
                            "mailto" + etDatos.getText().toString(),
                    BarcodeFormat.QR_CODE, 750, 750
                    );
                    ivCodigoQR.setImageBitmap(bitmap);
                }catch (Exception e){
                    e.printStackTrace();


                }

            }
        });
    }
}