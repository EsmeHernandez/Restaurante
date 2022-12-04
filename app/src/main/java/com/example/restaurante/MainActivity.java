package com.example.restaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public EditText ed1,ed2,ed3,ed4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText) findViewById(R.id.ednombre);
        ed2 = (EditText) findViewById(R.id.edapellido);
        ed3 = (EditText) findViewById(R.id.edcorreo);
        ed4 = (EditText) findViewById(R.id.edcontraseña);
    }

    public void altas(View view) {

        AdminSQLitedOpenHelper admin = new AdminSQLitedOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String clave_c = ed1.getText().toString();
        String nombre = ed2.getText().toString();
        String apellido = ed3.getText().toString();
        String celular = ed4.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("id_cliente", clave_c);
        registro.put("nombre_c", nombre);
        registro.put("apellido_c", apellido);
        registro.put("numero_c", celular);
        bd.insert("clientes", null, registro);//Inserto la base de datos clientes
        bd.close();
        //Mensaje emergente
        Toast.makeText(this, "Datos del usuario cargados con existo", Toast.LENGTH_SHORT).show();
        this.limpiar();
    }

    public void limpiar() {
        ed1.setText("");
        ed2.setText("");
        ed3.setText("");
        ed4.setText("");
    }

    public void busqueda(View view) {
        AdminSQLitedOpenHelper admin = new AdminSQLitedOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String clave_c = ed1.getText().toString();
        Cursor fila = bd.rawQuery("select nombre_c, apellido_c, numero_c from clientes where numero_c=" + clave_c, null);
        //Toast.makeText(this, "voy aqui", Toast.LENGTH_SHORT).show();
        if (fila.moveToFirst()) {
            ed2.setText(fila.getString(0));
            ed3.setText(fila.getString(1));
            ed4.setText(fila.getString(2));
        } else
            Toast.makeText(this, "Se encontro correctamente al usuario", Toast.LENGTH_SHORT).show();
        bd.close();
    }

    public void bajas(View view) {
        AdminSQLitedOpenHelper admin = new AdminSQLitedOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String clave_c = ed1.getText().toString();
        int cantidad = bd.delete("clientes", "id_cliente=" + clave_c, null);
        this.limpiar();
        if (cantidad == 1)
            Toast.makeText(this, "Cliente eliminado", Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, "voy aqui", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "El registro no se encontro", Toast.LENGTH_SHORT).show();
        bd.close();
    }

    public void modificaciones(View view) {
        AdminSQLitedOpenHelper admin = new AdminSQLitedOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String clave_c = ed1.getText().toString();
        //Toast.makeText(this, "voy aqui", Toast.LENGTH_SHORT).show();
        String nombre = ed2.getText().toString();
        String apellido = ed3.getText().toString();
        String celular = ed4.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("id_cliente", clave_c);
        registro.put("nombre_c", nombre);
        registro.put("apellido_c", apellido);
        registro.put("numero_c", celular);
        int cantidad=bd.update("clientes", registro, "id_cliente="+ clave_c, null);
        bd.close();
        if (cantidad == 1)
            Toast.makeText(this, "Datos modifiados con exito", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Datos no modificados", Toast.LENGTH_SHORT).show();

    }

    public void cambio_registro(View view) {
        Intent registro = new Intent(MainActivity.this, crearUsuario.class);
        //i.putExtra("nom",nombres.getText().toString());

        startActivity(registro);//correr la ventana con 'i' objeto que se construyo
    }
    public void cambio_login(View view) {
        Intent login = new Intent(MainActivity.this, login.class);
        //i.putExtra("nom",nombres.getText().toString());

        startActivity(login);//correr la ventana con 'i' objeto que se construyo
    }
    public void cambio_menu(View view) {
        Intent menu = new Intent(MainActivity.this, menu.class);
        //i.putExtra("nom",nombres.getText().toString());

        startActivity(menu);//correr la ventana con 'i' objeto que se construyo
    }
    public void cambio_pedido(View view) {
        Intent pedido = new Intent(MainActivity.this, pedido.class);
        //i.putExtra("nom",nombres.getText().toString());

        startActivity(pedido);//correr la ventana con 'i' objeto que se construyo
    }
    public void cambio_sugerencias(View view) {
        Intent sugerencias = new Intent(MainActivity.this, sugerencias.class);
        //i.putExtra("nom",nombres.getText().toString());

        startActivity(sugerencias);//correr la ventana con 'i' objeto que se construyo
    }
    public void salir(View view) {

        finish();
    }
}