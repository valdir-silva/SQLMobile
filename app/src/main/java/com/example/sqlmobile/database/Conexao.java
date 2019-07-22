package com.example.sqlmobile.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "banco.db";
    private static final int version = 1;

    public Conexao(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table pergunta(id integer primary key autoincrement," +
                "pergunta varchar (200)," +
                "resposta1 varchar (100)," +
                "resposta2 varchar (100)," +
                "resposta3 varchar (100)," +
                "resposta_certa integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
