package com.example.restaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class mostrar_pedido extends AppCompatActivity {
     TextView tvDatos;
     ImageView ivqr;
     Button generar, btnguardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_pedido);
        tvDatos=findViewById(R.id.textViewDatos);
        ivqr=findViewById(R.id.ivqr);
        generar=findViewById(R.id.generar);
        btnguardar=findViewById(R.id.btnguardar);
        
        Bundle recibeDatos=getIntent().getExtras();
        String [ ] info=recibeDatos.getStringArray("keyDatos");

        tvDatos.setText("Bebida: "+info[0]+"\nPlatillo: "+info[1]+"\nPostre: " +info[2]+"\nCaldos: "+info[3]);

        generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.encodeBitmap(
                            "mailto" + tvDatos.getText().toString(),
                            BarcodeFormat.QR_CODE, 750, 750
                    );
                    ivqr.setImageBitmap(bitmap);
                }catch (Exception e){
                    e.printStackTrace();


                }
            }
        });
 }
 public void guardarpedido(View view){
     Toast.makeText(this, "Tu pedido ha sido guardado tardará 15 minutos, llama al mesero", Toast.LENGTH_SHORT).show();
 }
}
