package com.example.restaurante;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLitedOpenHelper extends SQLiteOpenHelper{
    public AdminSQLitedOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table clientes(id_cliente integer primary key, nombre_c text, apellido_c text, numero_c integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + "clientes");
        sqLiteDatabase.execSQL("create table clientes(id_cliente integer primary key, nombre_c text, apellido_c text, numero_c integer)");

    }
}
