package com.example.restaurante;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;


public class eventos extends AppCompatActivity {
    Button btCamara;
    ImageView imagen;
    String rutaImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
        btCamara=findViewById(R.id.btCamara);
        imagen=findViewById(R.id.image);

        //btCamara.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view) {
               // abrirCamara();
            }
       // });
            //}
           public void abrirCamara(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (intent.resolveActivity(getPackageManager())!= null) {
                File imagenArchivo = null;
                try {
                    imagenArchivo = crearImagen();
                } catch (IOException ex) {
                    Log.e("Error", ex.toString());
                }
                if (imagenArchivo != null) {
                    Uri fotoUri = FileProvider.getUriForFile(this, "com.example.restaurante.fileprovider",
                            imagenArchivo);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, fotoUri);
                    startActivityForResult(intent, 1);
                }

                }
            }
            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                super.onActivityResult(requestCode, resultCode, data);
                if (requestCode == 1 && resultCode == RESULT_OK) {
                    //Bundle extras = data.getExtras();
                    Bitmap imgBitmap = BitmapFactory.decodeFile(rutaImagen);
                    imagen.setImageBitmap(imgBitmap);
                }
            }
            private File crearImagen() throws IOException {
        String nombreImagen= "foto_";
        File directorio= getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File imagen = File.createTempFile(nombreImagen, ".jpg", directorio);
        rutaImagen = imagen.getAbsolutePath();
        return imagen;
            }
}