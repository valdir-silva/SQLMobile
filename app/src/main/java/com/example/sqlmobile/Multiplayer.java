package com.example.sqlmobile;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sqlmobile.database.PerguntaDAO;

import java.util.ArrayList;
import java.util.List;

public class Multiplayer extends AppCompatActivity {

    Usuario player1 = new Usuario();
    Usuario player2 = new Usuario();

    Controlador controlador = new Controlador();
    FrontEnd front = new FrontEnd();

    List<Pergunta> listaPerguntas = new ArrayList<>();
    private PerguntaDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Retira a Action Bar
        setContentView(R.layout.activity_multiplayer);
        dao = new PerguntaDAO(this);

        // Abaixo: Instanciando e inicializando objetos e atributos
        if (getIntent().getExtras() != null) {
            player1 = getIntent().getExtras().getParcelable("player1");
            player2 = getIntent().getExtras().getParcelable("player2");
            controlador = getIntent().getExtras().getParcelable("controlador");
        }
        player1.getControlador().setTempoTravado(controlador.getTempoTravado());
        player2.getControlador().setTempoTravado(controlador.getTempoTravado());
        player1.setPontuacao(0);
        player2.setPontuacao(0);
        player1.setId(0);
        player2.setId(1);

        dao = controlador.preencheLista(dao);
        listaPerguntas = dao.obterTudo();
        //FIM INSTANCIANDO E INICIALIZANDO

        // Populando listas com Front-End de cada player - PLAYER 1
        player1.getControlador().getTextosPlayer().add((TextView) findViewById(R.id.PerguntaPlayer1));
        player1.getControlador().getTextosPlayer().add((TextView) findViewById(R.id.Resposta1));
        player1.getControlador().getTextosPlayer().add((TextView) findViewById(R.id.Resposta2));
        player1.getControlador().getTextosPlayer().add((TextView) findViewById(R.id.Resposta3));
        player1.getControlador().getTextosPlayer().add((TextView) findViewById(R.id.txtFinalizouPlayer));

        player1.getControlador().getImagensPlayer().add((ImageView) findViewById(R.id.bg_Resposta1));
        player1.getControlador().getImagensPlayer().add((ImageView) findViewById(R.id.bg_Resposta1_clicked));
        player1.getControlador().getImagensPlayer().add((ImageView) findViewById(R.id.bg_Resposta2));
        player1.getControlador().getImagensPlayer().add((ImageView) findViewById(R.id.bg_Resposta2_clicked));
        player1.getControlador().getImagensPlayer().add((ImageView) findViewById(R.id.bg_Resposta3));
        player1.getControlador().getImagensPlayer().add((ImageView) findViewById(R.id.bg_Resposta3_clicked));
        player1.getControlador().getImagensPlayer().add((ImageView) findViewById(R.id.btn_confirma));
        player1.getControlador().getImagensPlayer().add((ImageView) findViewById(R.id.btn_confirma_lock));
        player1.getControlador().getImagensPlayer().add((ImageView) findViewById(R.id.btn_pular));
        player1.getControlador().getImagensPlayer().add((ImageView) findViewById(R.id.btn_pular_lock));

        // instanciando novamente, mas botoes especificos para ter maior controle de maneira fácil (pensar em coloca-los uni-los para foreach e n duplicar mais os atributos)
        player1.getControlador().getBotoes().add((ImageView) findViewById(R.id.bg_Resposta1));
        player1.getControlador().getBotoes().add((ImageView) findViewById(R.id.bg_Resposta2));
        player1.getControlador().getBotoes().add((ImageView) findViewById(R.id.bg_Resposta3));
        player1.getControlador().getBotoes().add((ImageView) findViewById(R.id.btn_confirma));
        player1.getControlador().getBotoes().add((ImageView) findViewById(R.id.btn_pular));

        player1.getControlador().getBotoesClicked().add((ImageView) findViewById(R.id.bg_Resposta1_clicked));
        player1.getControlador().getBotoesClicked().add((ImageView) findViewById(R.id.bg_Resposta2_clicked));
        player1.getControlador().getBotoesClicked().add((ImageView) findViewById(R.id.bg_Resposta3_clicked));

        player1.getControlador().getBotoesLock().add((ImageView) findViewById(R.id.btn_confirma_lock));
        player1.getControlador().getBotoesLock().add((ImageView) findViewById(R.id.btn_pular_lock));

        player1.getControlador().setTempo((TextView) findViewById(R.id.tempoP1));
        player1.getControlador().setTempoLock((TextView) findViewById(R.id.txtTempoLock));
        player1.getControlador().setPontos((TextView) findViewById(R.id.pontosP1));

        player1.getControlador().setAcertou((TextView) findViewById(R.id.txtAcertou));
        player1.getControlador().setErrou((TextView) findViewById(R.id.txtErrou));

        // Populando listas com Front-End de cada player - PLAYER 2
        player2.getControlador().getTextosPlayer().add((TextView) findViewById(R.id.PerguntaPlayer2));
        player2.getControlador().getTextosPlayer().add((TextView) findViewById(R.id.Resposta1_P2));
        player2.getControlador().getTextosPlayer().add((TextView) findViewById(R.id.Resposta2_P2));
        player2.getControlador().getTextosPlayer().add((TextView) findViewById(R.id.Resposta3_P2));
        player2.getControlador().getTextosPlayer().add((TextView) findViewById(R.id.txtFinalizouPlayer2));

        player2.getControlador().getImagensPlayer().add((ImageView) findViewById(R.id.bg_Resposta1_P2));
        player2.getControlador().getImagensPlayer().add((ImageView) findViewById(R.id.bg_Resposta1_clicked_P2));
        player2.getControlador().getImagensPlayer().add((ImageView) findViewById(R.id.bg_Resposta2_P2));
        player2.getControlador().getImagensPlayer().add((ImageView) findViewById(R.id.bg_Resposta2_clicked_P2));
        player2.getControlador().getImagensPlayer().add((ImageView) findViewById(R.id.bg_Resposta3_P2));
        player2.getControlador().getImagensPlayer().add((ImageView) findViewById(R.id.bg_Resposta3_clicked_P2));
        player2.getControlador().getImagensPlayer().add((ImageView) findViewById(R.id.btn_confirma_P2));
        player2.getControlador().getImagensPlayer().add((ImageView) findViewById(R.id.btn_confirma_lock_P2));
        player2.getControlador().getImagensPlayer().add((ImageView) findViewById(R.id.btn_pular_P2));
        player2.getControlador().getImagensPlayer().add((ImageView) findViewById(R.id.btn_pular_lock_P2));

        // instanciando novamente, mas botoes especificos para ter maior controle de maneira fácil (pensar em coloca-los uni-los para foreach e n duplicar mais os atributos)
        player2.getControlador().getBotoes().add((ImageView) findViewById(R.id.bg_Resposta1_P2));
        player2.getControlador().getBotoes().add((ImageView) findViewById(R.id.bg_Resposta2_P2));
        player2.getControlador().getBotoes().add((ImageView) findViewById(R.id.bg_Resposta3_P2));
        player2.getControlador().getBotoes().add((ImageView) findViewById(R.id.btn_confirma_P2));
        player2.getControlador().getBotoes().add((ImageView) findViewById(R.id.btn_pular_P2));

        player2.getControlador().getBotoesClicked().add((ImageView) findViewById(R.id.bg_Resposta1_clicked_P2));
        player2.getControlador().getBotoesClicked().add((ImageView) findViewById(R.id.bg_Resposta2_clicked_P2));
        player2.getControlador().getBotoesClicked().add((ImageView) findViewById(R.id.bg_Resposta3_clicked_P2));

        player2.getControlador().getBotoesLock().add((ImageView) findViewById(R.id.btn_confirma_lock_P2));
        player2.getControlador().getBotoesLock().add((ImageView) findViewById(R.id.btn_pular_lock_P2));

        player2.getControlador().setTempo((TextView) findViewById(R.id.tempoP2));
        player2.getControlador().setTempoLock((TextView) findViewById(R.id.txtTempoLock_P2));
        player2.getControlador().setPontos((TextView) findViewById(R.id.pontosP2));

        player2.getControlador().setAcertou((TextView) findViewById(R.id.txtAcertouP2));
        player2.getControlador().setErrou((TextView) findViewById(R.id.txtErrouP2));

        // Populando resto do Front
        front.getParabensTxt().add((TextView) findViewById(R.id.txtParabens));
        front.getParabensTxt().add((TextView) findViewById(R.id.nomesP1));
        front.getParabensTxt().add((TextView) findViewById(R.id.nomesP2));
        front.getParabensTxt().add((TextView) findViewById(R.id.pontosP1_P1));
        front.getParabensTxt().add((TextView) findViewById(R.id.pontosP2_P1));
        front.getParabensTxt().add((TextView) findViewById(R.id.pontosP1_P2));
        front.getParabensTxt().add((TextView) findViewById(R.id.pontosP2_P2));

        front.getParabensImg().add((ImageView) findViewById(R.id.bg_txt_fim));
        front.getParabensImg().add((ImageView) findViewById(R.id.bg_fim));

        controlador.organizaFront(player1, player2, front, listaPerguntas); //COLOCANDO VALORES FRONT-END
        controlador.travaProximaPergunta(player1);
        controlador.travaProximaPergunta(player2);
        // FIM POPULANDO LISTA FRONT PLAYERS

        player1.getControlador().getBotoes().get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controlador.marcarResposta(player1, 0, listaPerguntas);
                listaPerguntas.get(player1.getControlador().getPergunta()).setRespostaMarcada(1);
            }
        });

        player1.getControlador().getBotoes().get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controlador.marcarResposta(player1, 1, listaPerguntas);
                listaPerguntas.get(player1.getControlador().getPergunta()).setRespostaMarcada(2);
            }
        });

        player1.getControlador().getBotoes().get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controlador.marcarResposta(player1, 2, listaPerguntas);
                listaPerguntas.get(player1.getControlador().getPergunta()).setRespostaMarcada(3);
            }
        });

        // PLAYER 2

        player2.getControlador().getBotoes().get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controlador.marcarResposta(player2, 0, listaPerguntas);
                listaPerguntas.get(player2.getControlador().getPergunta()).setRespostaMarcada(1);
            }
        });

        player2.getControlador().getBotoes().get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controlador.marcarResposta(player2, 1, listaPerguntas);
                listaPerguntas.get(player2.getControlador().getPergunta()).setRespostaMarcada(2);
            }
        });

        player2.getControlador().getBotoes().get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controlador.marcarResposta(player2, 2, listaPerguntas);
                listaPerguntas.get(player2.getControlador().getPergunta()).setRespostaMarcada(3);
            }
        });

        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                int secondos = (int) (millisUntilFinished / 1000);
                int minutos = secondos / 60;
                secondos = secondos % 60;
                player1.getControlador().getTempo().setText(String.format("%02d", minutos)
                        + ":" + String.format("%02d", secondos));
                player2.getControlador().getTempo().setText(String.format("%02d", minutos)
                        + ":" + String.format("%02d", secondos));
            }

            public void onFinish() {
                player1 = controlador.finalizaPlayer(player1); // enviando a instancia do player1 para setar o atributo 'ativo' como false
                player2 = controlador.finalizaPlayer(player2);
                controlador.finalizaJogo(player1, player2, front);
            }
        }.start();

        player1.getControlador().getBotoes().get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // QUANDO PONTUACAO FICAR NEGATIVA DEIXAR BG VERMELHO
                controlador.confirmaResposta(player1, front, listaPerguntas);
            }
        });

        player2.getControlador().getBotoes().get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controlador.confirmaResposta(player2, front, listaPerguntas);
            }
        });

        player1.getControlador().getBotoes().get(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // BOTAO PULAR (mudar atributo para entender melhor oq significa)
                controlador.pularPergunta(player1, listaPerguntas);
            }
        });

        player2.getControlador().getBotoes().get(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // BOTAO PULAR
                controlador.pularPergunta(player2, listaPerguntas);
            }
        });
    }
}
