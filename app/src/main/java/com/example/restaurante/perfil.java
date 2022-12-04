package com.example.restaurante;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_menu:
                Toast.makeText(this,"Menú",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_zonas:
                Toast.makeText(this,"Zonas",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_Eventos:
                Toast.makeText(this,"Eventos",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_Recomendaciones:
                Toast.makeText(this,"Recomendaciones",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}
