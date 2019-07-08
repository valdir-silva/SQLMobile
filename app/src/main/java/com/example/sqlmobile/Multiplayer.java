package com.example.sqlmobile;

import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Multiplayer extends AppCompatActivity {

    ImageView bg_Resposta1, bg_Resposta1_clicked, bg_Resposta2, bg_Resposta2_clicked;
    ImageView bg_Resposta1_P2, bg_Resposta1_clicked_P2, bg_Resposta2_P2, bg_Resposta2_clicked_P2;
    ImageView btn_confirma;
    ImageView btn_confirma_P2;

    TextView tempoP1;

    Pergunta pergunta = new Pergunta();
    Pergunta perguntaP2 = new Pergunta();

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

        tempoP1 = findViewById(R.id.tempoP1);

        btn_confirma = findViewById(R.id.btn_confirma);
        btn_confirma_P2 = findViewById(R.id.btn_confirma_P2);

        pergunta.setRespostaCerta(1);
        perguntaP2.setRespostaCerta(2);

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
                perguntaP2.setRespostaMarcada(1);
                bg_Resposta2_clicked_P2.setVisibility(View.INVISIBLE);
                bg_Resposta2_P2.setVisibility(View.VISIBLE);
                bg_Resposta1_clicked_P2.setVisibility(View.VISIBLE);
                bg_Resposta1_P2.setVisibility(View.INVISIBLE);
            }
        });

        bg_Resposta2_P2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perguntaP2.setRespostaMarcada(2);
                bg_Resposta1_clicked_P2.setVisibility(View.INVISIBLE);
                bg_Resposta1_P2.setVisibility(View.VISIBLE);
                bg_Resposta2_clicked_P2.setVisibility(View.VISIBLE);
                bg_Resposta2_P2.setVisibility(View.INVISIBLE);
            }
        });

        new CountDownTimer(130000, 1000) {

            public void onTick(long millisUntilFinished) {
                int secondos = (int) (millisUntilFinished / 1000);
                int minutos = secondos / 60;
                secondos = secondos % 60;
                tempoP1.setText(String.format("%02d", minutos)
                        + ":" + String.format("%02d", secondos));
            }

            public void onFinish() {
                tempoP1.setText("FIM!");
            }
        }.start();

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

        btn_confirma_P2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (perguntaP2.getRespostaCerta() == perguntaP2.getRespostaMarcada()){
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
