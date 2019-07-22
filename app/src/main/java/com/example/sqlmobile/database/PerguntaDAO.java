package com.example.sqlmobile.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqlmobile.Pergunta;

import java.util.ArrayList;
import java.util.List;

public class PerguntaDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public PerguntaDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Pergunta pergunta){
        ContentValues values = new ContentValues();
        values.put("pergunta", pergunta.getPergunta());
        values.put("resposta1", pergunta.getResposta().get(0));
        values.put("resposta2", pergunta.getResposta().get(1));
        values.put("resposta3", pergunta.getResposta().get(2));
        values.put("resposta_certa", pergunta.getRespostaCerta());
        return banco.insert("pergunta", null, values);
    }

    public List<Pergunta> obterTudo(){
        List<Pergunta> perguntas = new ArrayList<>();
        Cursor cursor = banco.query("pergunta", new String[] {"id", "pergunta", "resposta1", "resposta2", "resposta3", "resposta_certa"},
                null, null, null, null, null);
        while (cursor.moveToNext()){
            Pergunta p = new Pergunta();
            p.setId(cursor.getInt(0));
            p.setPergunta(cursor.getString(1));
            p.getResposta().add(cursor.getString(2));
            p.getResposta().add(cursor.getString(3));
            p.getResposta().add(cursor.getString(4));
            p.setRespostaCerta(cursor.getInt(5));
            perguntas.add(p);
        }
        return perguntas;
    }
}