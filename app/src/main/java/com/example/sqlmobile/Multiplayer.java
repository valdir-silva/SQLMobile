package com.example.sqlmobile;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Multiplayer extends AppCompatActivity {

    ImageView bg_Resposta1, bg_Resposta1_clicked, bg_Resposta2, bg_Resposta2_clicked;
    ImageView bg_Resposta1_P2, bg_Resposta1_clicked_P2, bg_Resposta2_P2, bg_Resposta2_clicked_P2;
    ImageView btn_confirma;
    Pergunta pergunta = new Pergunta();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Retira a Action Bar
        setContentView(R.layout.activity_multiplayer);

        bg_Resposta1 = findViewById(R.id.bg_Resposta1);
        bg_Resposta1_clicked = findViewById(R.id.bg_Resposta1_clicked);
        bg_Resposta2 = findViewById(R.id.bg_Resposta2);
        bg_Resposta2_clicked = findViewById(R.id.bg_Resposta2_clicked);

        bg_Resposta1_P2 = findViewById(R.id.bg_Resposta1_P2);
        bg_Resposta1_clicked_P2 = findViewById(R.id.bg_Resposta1_clicked_P2);
        bg_Resposta2_P2 = findViewById(R.id.bg_Resposta2_P2);
        bg_Resposta2_clicked_P2 = findViewById(R.id.bg_Resposta2_clicked_P2);

        btn_confirma = findViewById(R.id.btn_confirma);

        pergunta.setRespostaCerta(1);

        bg_Resposta1_clicked.setVisibility(View.INVISIBLE);
        bg_Resposta2_clicked.setVisibility(View.INVISIBLE);

        bg_Resposta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pergunta.setRespostaMarcada(1);
                bg_Resposta2_clicked.setVisibility(View.INVISIBLE);
                bg_Resposta2.setVisibility(View.VISIBLE);
                bg_Resposta1_clicked.setVisibility(View.VISIBLE);
                bg_Resposta1.setVisibility(View.INVISIBLE);
            }
        });

        bg_Resposta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pergunta.setRespostaMarcada(2);
                bg_Resposta1_clicked.setVisibility(View.INVISIBLE);
                bg_Resposta1.setVisibility(View.VISIBLE);
                bg_Resposta2_clicked.setVisibility(View.VISIBLE);
                bg_Resposta2.setVisibility(View.INVISIBLE);
            }
        });

        // PLAYER 2

        bg_Resposta1_clicked_P2.setVisibility(View.INVISIBLE);
        bg_Resposta2_clicked_P2.setVisibility(View.INVISIBLE);

        bg_Resposta1_P2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pergunta.setRespostaMarcada(1);
                bg_Resposta2_clicked_P2.setVisibility(View.INVISIBLE);
                bg_Resposta2_P2.setVisibility(View.VISIBLE);
                bg_Resposta1_clicked_P2.setVisibility(View.VISIBLE);
                bg_Resposta1_P2.setVisibility(View.INVISIBLE);
            }
        });

        bg_Resposta2_P2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pergunta.setRespostaMarcada(2);
                bg_Resposta1_clicked_P2.setVisibility(View.INVISIBLE);
                bg_Resposta1_P2.setVisibility(View.VISIBLE);
                bg_Resposta2_clicked_P2.setVisibility(View.VISIBLE);
                bg_Resposta2_P2.setVisibility(View.INVISIBLE);
            }
        });

        btn_confirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pergunta.getRespostaCerta() == pergunta.getRespostaMarcada()){
                    new AlertDialog.Builder(Multiplayer.this)
                            .setTitle("Resposta Correta!")
                            .setMessage("Aperte Ok para a próxima pergunta")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //fecha caixa de dialogo
                                    dialog.dismiss();
                                }
                            }).show();
                } else {
                    new AlertDialog.Builder(Multiplayer.this)
                            .setTitle("Tente Novamente")
                            .setMessage("Aperte Ok para tentar outra vez")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //fecha caixa de dialogo
                                    dialog.dismiss();
                                }
                            }).show();
                }
            }
        });
    }
}
