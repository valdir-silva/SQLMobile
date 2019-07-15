package com.example.sqlmobile;

import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Multiplayer extends AppCompatActivity {

    TextView PerguntaPlayer1, PerguntaPlayer2;
    TextView Resposta1, Resposta2, Resposta3, Resposta1_P2, Resposta2_P2, Resposta3_P2;

    ImageView bg_Resposta1, bg_Resposta1_clicked, bg_Resposta2, bg_Resposta2_clicked, bg_Resposta3, bg_Resposta3_clicked;
    ImageView bg_Resposta1_P2, bg_Resposta1_clicked_P2, bg_Resposta2_P2, bg_Resposta2_clicked_P2, bg_Resposta3_P2, bg_Resposta3_clicked_P2;
    ImageView btn_pular, btn_pular_P2;
    ImageView btn_pular_lock, btn_pular_lock_P2;
    ImageView btn_confirma, btn_confirma_P2;
    ImageView btn_confirma_lock, btn_confirma_lock_P2;
    TextView txtTempoLock, txtTempoLock_P2;
    ImageView bg_fim, bg_txt_fim;

    TextView txtAcertou, txtAcertouP2;
    TextView txtErrou, txtErrouP2;

    TextView tempoP1, tempoP2;

    TextView pontosP1, pontosP2;

    TextView txtParabens, nomesP1, nomesP2, pontosP1_P1, pontosP2_P1, pontosP1_P2, pontosP2_P2;

    Usuario player1 = new Usuario();
    Usuario player2 = new Usuario();

    List<Pergunta> listaPerguntas = new ArrayList<Pergunta>();
    List<Pergunta> listaPerguntasP2 = new ArrayList<Pergunta>();

    Controladores controladores = new Controladores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Retira a Action Bar
        setContentView(R.layout.activity_multiplayer);

        PerguntaPlayer1 = findViewById(R.id.PerguntaPlayer1);
        PerguntaPlayer2 = findViewById(R.id.PerguntaPlayer2);

        Resposta1 = findViewById(R.id.Resposta1);
        Resposta2 = findViewById(R.id.Resposta2);
        Resposta3 = findViewById(R.id.Resposta3);
        Resposta1_P2 = findViewById(R.id.Resposta1_P2);
        Resposta2_P2 = findViewById(R.id.Resposta2_P2);
        Resposta3_P2 = findViewById(R.id.Resposta3_P2);

        bg_Resposta1 = findViewById(R.id.bg_Resposta1);
        bg_Resposta1_clicked = findViewById(R.id.bg_Resposta1_clicked);
        bg_Resposta2 = findViewById(R.id.bg_Resposta2);
        bg_Resposta2_clicked = findViewById(R.id.bg_Resposta2_clicked);
        bg_Resposta3 = findViewById(R.id.bg_Resposta3);
        bg_Resposta3_clicked = findViewById(R.id.bg_Resposta3_clicked);

        bg_Resposta1_P2 = findViewById(R.id.bg_Resposta1_P2);
        bg_Resposta1_clicked_P2 = findViewById(R.id.bg_Resposta1_clicked_P2);
        bg_Resposta2_P2 = findViewById(R.id.bg_Resposta2_P2);
        bg_Resposta2_clicked_P2 = findViewById(R.id.bg_Resposta2_clicked_P2);
        bg_Resposta3_P2 = findViewById(R.id.bg_Resposta3_P2);
        bg_Resposta3_clicked_P2 = findViewById(R.id.bg_Resposta3_clicked_P2);

        tempoP1 = findViewById(R.id.tempoP1);
        tempoP2 = findViewById(R.id.tempoP2);

        pontosP1 = findViewById(R.id.pontosP1);
        pontosP2 = findViewById(R.id.pontosP2);

        txtParabens = findViewById(R.id.txtParabens);
        nomesP1 = findViewById(R.id.nomesP1);
        nomesP2 = findViewById(R.id.nomesP2);
        pontosP1_P1 = findViewById(R.id.pontosP1_P1);
        pontosP2_P1 = findViewById(R.id.pontosP2_P1);
        pontosP1_P2 = findViewById(R.id.pontosP1_P2);
        pontosP2_P2 = findViewById(R.id.pontosP2_P2);

        btn_pular = findViewById(R.id.btn_pular);
        btn_pular_lock = findViewById(R.id.btn_pular_lock);
        btn_pular_lock_P2 = findViewById(R.id.btn_pular_lock_P2);
        btn_pular_P2 = findViewById(R.id.btn_pular_P2);

        btn_confirma = findViewById(R.id.btn_confirma);
        btn_confirma_lock = findViewById(R.id.btn_confirma_lock);
        btn_confirma_lock_P2 = findViewById(R.id.btn_confirma_lock_P2);
        btn_confirma_P2 = findViewById(R.id.btn_confirma_P2);

        txtTempoLock = findViewById(R.id.txtTempoLock);
        txtTempoLock_P2 = findViewById(R.id.txtTempoLock_P2);

        bg_fim = findViewById(R.id.bg_fim);
        bg_txt_fim = findViewById(R.id.bg_txt_fim);

        txtAcertou = findViewById(R.id.txtAcertou);
        txtErrou = findViewById(R.id.txtErrou);
        txtAcertouP2 = findViewById(R.id.txtAcertouP2);
        txtErrouP2 = findViewById(R.id.txtErrouP2);

        // Abaixo: Instanciando e inicializando objetos e atributos
        player1.setPontuacao(0);
        player2.setPontuacao(0);
        player1.setId(0);
        player2.setId(1);
        player1.setNome("Player 1"); // Limitar nickname para 10 caracteres
        player2.setNome("Player 2");

        Pergunta pergunta1 = new Pergunta(); // Fazendo desta forma como exemplo, a partir deste código...
        pergunta1.setPergunta("Select from blabla"); // ...é possível carregar a lista com um Database
        pergunta1.getResposta().add("Teste de resposta");
        pergunta1.getResposta().add("Teste de resposta");
        pergunta1.setRespostaCerta(1);
        listaPerguntas.add(pergunta1);

        Pergunta pergunta2 = new Pergunta();
        pergunta2.setPergunta("Select outra pergunta");
        pergunta2.getResposta().add("Outra resposta");
        pergunta2.getResposta().add("Outra resposta de novo");
        pergunta2.setRespostaCerta(2);
        listaPerguntas.add(pergunta2);

        Pergunta pergunta3 = new Pergunta();
        pergunta3.setPergunta("Select nova pergunta");
        pergunta3.getResposta().add("Outra nova resposta");
        pergunta3.getResposta().add("Outra resposta de novo");
        pergunta3.setRespostaCerta(2);
        listaPerguntas.add(pergunta3);

        // Lista de Perguntas do Player 2
        Pergunta perguntaP2_1 = new Pergunta();
        perguntaP2_1.setPergunta("Qual dos seguintes NÃO é um tipo de join usado em SQL?");
        perguntaP2_1.getResposta().add("INNER JOIN");
        perguntaP2_1.getResposta().add("EXTRA JOIN");
        perguntaP2_1.getResposta().add("OUTER JOIN");
        perguntaP2_1.setRespostaCerta(2);
        listaPerguntasP2.add(perguntaP2_1);

        Pergunta perguntaP2_2 = new Pergunta();
        perguntaP2_2.setPergunta("Para excluir um registro único de uma tabela, qual das seguintes declarações pode ser usada?");
        perguntaP2_2.getResposta().add("DELETE");
        perguntaP2_2.getResposta().add("REMOVE");
        perguntaP2_2.getResposta().add("TRUNCATE");
        perguntaP2_2.setRespostaCerta(2);
        listaPerguntasP2.add(perguntaP2_2);

        Pergunta perguntaP2_3 = new Pergunta();
        perguntaP2_3.setPergunta("Caso você necessite inserir um novo registro no banco de dados, qual declaração deve utilizar?");
        perguntaP2_3.getResposta().add("INSERT INTO");
        perguntaP2_3.getResposta().add("ADD REGISTER");
        perguntaP2_3.getResposta().add("NEW DATA");
        perguntaP2_3.setRespostaCerta(1);
        listaPerguntasP2.add(perguntaP2_3);

        Pergunta perguntaP2_4 = new Pergunta();
        perguntaP2_4.setPergunta("O que significa a sigla SQL?");
        perguntaP2_4.getResposta().add("Structured Quiz Language");
        perguntaP2_4.getResposta().add("Standard Question Language");
        perguntaP2_4.getResposta().add("Structured Query Language");
        perguntaP2_4.setRespostaCerta(3);
        listaPerguntasP2.add(perguntaP2_4);

        Pergunta perguntaP2_5 = new Pergunta();
        perguntaP2_5.setPergunta("Precisamos programar um banco de dados para que, sempre que um determinado registro for inserido em uma tabela, uma ação específica seja realizada automaticamente. Qual estrutura nos permite programar isso?");
        perguntaP2_5.getResposta().add("TRIGGER");
        perguntaP2_5.getResposta().add("STORED PROCEDURE");
        perguntaP2_5.getResposta().add("VIEW");
        perguntaP2_5.setRespostaCerta(1);
        listaPerguntasP2.add(perguntaP2_5);

        Pergunta perguntaP2_6 = new Pergunta();
        perguntaP2_6.setPergunta("Qual declaração devemos usar para efetuar uma consulta a um banco de dados?");
        perguntaP2_6.getResposta().add("CONSULT");
        perguntaP2_6.getResposta().add("SELECT");
        perguntaP2_6.getResposta().add("QUERY");
        perguntaP2_6.setRespostaCerta(2);
        listaPerguntasP2.add(perguntaP2_6);



        //FIM INSTANCIANDO E INICIALIZANDO

        organizaFront(); //COLOCANDO VALORES FRONT-END
        travaProximaPergunta();
        travaProximaPerguntaP2();

        bg_Resposta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaPerguntas.get(0).setRespostaMarcada(1);
                bg_Resposta2_clicked.setVisibility(View.INVISIBLE);
                bg_Resposta2.setVisibility(View.VISIBLE);
                bg_Resposta1_clicked.setVisibility(View.VISIBLE);
                bg_Resposta1.setVisibility(View.INVISIBLE);
                bg_Resposta3_clicked.setVisibility(View.INVISIBLE);
                bg_Resposta3.setVisibility(View.VISIBLE);
            }
        });

        bg_Resposta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaPerguntas.get(0).setRespostaMarcada(2);
                bg_Resposta1_clicked.setVisibility(View.INVISIBLE);
                bg_Resposta1.setVisibility(View.VISIBLE);
                bg_Resposta2_clicked.setVisibility(View.VISIBLE);
                bg_Resposta2.setVisibility(View.INVISIBLE);
                bg_Resposta3_clicked.setVisibility(View.INVISIBLE);
                bg_Resposta3.setVisibility(View.VISIBLE);
            }
        });

        bg_Resposta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaPerguntas.get(0).setRespostaMarcada(2);
                bg_Resposta1_clicked.setVisibility(View.INVISIBLE);
                bg_Resposta1.setVisibility(View.VISIBLE);
                bg_Resposta2_clicked.setVisibility(View.INVISIBLE);
                bg_Resposta2.setVisibility(View.VISIBLE);
                bg_Resposta3_clicked.setVisibility(View.VISIBLE);
                bg_Resposta3.setVisibility(View.INVISIBLE);
            }
        });

        // PLAYER 2

        bg_Resposta1_clicked_P2.setVisibility(View.INVISIBLE);
        bg_Resposta2_clicked_P2.setVisibility(View.INVISIBLE);

        bg_Resposta1_P2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaPerguntas.get(1).setRespostaMarcada(1);
                bg_Resposta2_clicked_P2.setVisibility(View.INVISIBLE);
                bg_Resposta2_P2.setVisibility(View.VISIBLE);
                bg_Resposta1_clicked_P2.setVisibility(View.VISIBLE);
                bg_Resposta1_P2.setVisibility(View.INVISIBLE);
                bg_Resposta3_clicked_P2.setVisibility(View.INVISIBLE);
                bg_Resposta3_P2.setVisibility(View.VISIBLE);
            }
        });

        bg_Resposta2_P2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaPerguntas.get(1).setRespostaMarcada(2);
                bg_Resposta1_clicked_P2.setVisibility(View.INVISIBLE);
                bg_Resposta1_P2.setVisibility(View.VISIBLE);
                bg_Resposta2_clicked_P2.setVisibility(View.VISIBLE);
                bg_Resposta2_P2.setVisibility(View.INVISIBLE);
                bg_Resposta3_clicked_P2.setVisibility(View.INVISIBLE);
                bg_Resposta3_P2.setVisibility(View.VISIBLE);
            }
        });

        bg_Resposta3_P2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaPerguntas.get(1).setRespostaMarcada(2);
                bg_Resposta1_clicked_P2.setVisibility(View.INVISIBLE);
                bg_Resposta1_P2.setVisibility(View.VISIBLE);
                bg_Resposta2_clicked_P2.setVisibility(View.INVISIBLE);
                bg_Resposta2_P2.setVisibility(View.VISIBLE);
                bg_Resposta3_clicked_P2.setVisibility(View.VISIBLE);
                bg_Resposta3_P2.setVisibility(View.INVISIBLE);
            }
        });

        new CountDownTimer(40000, 1000) {

            public void onTick(long millisUntilFinished) {
                int secondos = (int) (millisUntilFinished / 1000);
                int minutos = secondos / 60;
                secondos = secondos % 60;
                tempoP1.setText(String.format("%02d", minutos)
                        + ":" + String.format("%02d", secondos));
                tempoP2.setText(String.format("%02d", minutos)
                        + ":" + String.format("%02d", secondos));
            }

            public void onFinish() {
                finalizaJogo();
            }
        }.start();

        btn_confirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(controladores.isLiberaProxPerguntaP1()){
                    if (listaPerguntas.get(0).getRespostaCerta() == listaPerguntas.get(0).getRespostaMarcada()){
                        mostrarTexto(txtAcertou);
                        player1.setPontuacao(player1.getPontuacao()+1);
                    } else {
                        mostrarTexto(txtErrou);
                        player1.setPontuacao(player1.getPontuacao()-1);
                    }
                    pontosP1.setText(Integer.toString(player1.getPontuacao()));
                    controladores.setPerguntaP1(controladores.getPerguntaP1()+1);
                    atualizarPerguntaP1(controladores.getPerguntaP1());
                    travaProximaPergunta();
                }
            }
        });

        btn_confirma_P2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (controladores.isLiberaProxPerguntaP2()){
                    if (listaPerguntas.get(1).getRespostaCerta() == listaPerguntas.get(1).getRespostaMarcada()){
                        mostrarTexto(txtAcertouP2);
                        player2.setPontuacao(player2.getPontuacao()+1);
                    } else {
                        mostrarTexto(txtErrouP2);
                        player2.setPontuacao(player2.getPontuacao()-1);
                    }
                    pontosP2.setText(Integer.toString(player2.getPontuacao()));
                    controladores.setPerguntaP2(controladores.getPerguntaP2()+1);
                    atualizarPerguntaP2(controladores.getPerguntaP2());
                    travaProximaPerguntaP2();
                }
            }
        });

        btn_pular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controladores.setPerguntaP1(controladores.getPerguntaP1()+1);
                atualizarPerguntaP1(controladores.getPerguntaP1());
            }
        });

        btn_pular_P2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controladores.setPerguntaP2(controladores.getPerguntaP2()+1);
                atualizarPerguntaP2(controladores.getPerguntaP1());
            }
        });
    }

    public void mostrarImagem (ImageView imagem){
        imagem.setVisibility(View.VISIBLE);
    }

    public void mostrarTexto (final TextView texto){

        new CountDownTimer(1000, 1000) {
            public void onTick(long millisUntilFinished) {
                texto.setVisibility(View.VISIBLE);
            }
            public void onFinish() {
                texto.setVisibility(View.INVISIBLE);
            }
        }.start();
    }

    public void atualizarPerguntaP1(int numPergunta){ // Abstrair para os dois jogadores // ADICIONAR TEMPO DE 5 SEGUNDOS PARA TROCAR DE PERGUNTA, ATÉ LÁ, VOLTAR E CONFIRMA FICAM CINZA
        PerguntaPlayer1.setText(listaPerguntas.get(numPergunta).getPergunta());
        Resposta1.setText(listaPerguntas.get(numPergunta).getResposta().get(0));
        Resposta2.setText(listaPerguntas.get(numPergunta).getResposta().get(1));
        //Resposta3.setText(listaPerguntas.get(numPergunta).getResposta().get(2));
    }

    public void atualizarPerguntaP2(int numPergunta){ // Abstrair para os dois jogadores // ADICIONAR TEMPO DE 5 SEGUNDOS PARA TROCAR DE PERGUNTA, ATÉ LÁ, VOLTAR E CONFIRMA FICAM CINZA
        PerguntaPlayer2.setText(listaPerguntasP2.get(numPergunta).getPergunta());
        PerguntaPlayer2.setGravity(Gravity.CENTER_HORIZONTAL);
        Resposta1_P2.setText(listaPerguntasP2.get(numPergunta).getResposta().get(0));
        Resposta2_P2.setText(listaPerguntasP2.get(numPergunta).getResposta().get(1));
        Resposta3_P2.setText(listaPerguntasP2.get(numPergunta).getResposta().get(2));
    }

    public void organizaFront(){
        pontosP1.setText(Integer.toString(player1.getPontuacao()));
        pontosP2.setText(Integer.toString(player2.getPontuacao()));

        //Colocar uma animação no confirmar e pular, usar contador de tempo e uma imageview diferente
        btn_confirma_lock.setVisibility(View.INVISIBLE);
        btn_pular_lock.setVisibility(View.INVISIBLE);
        txtTempoLock.setVisibility(View.INVISIBLE);

        btn_confirma_lock_P2.setVisibility(View.INVISIBLE);
        btn_pular_lock_P2.setVisibility(View.INVISIBLE);
        txtTempoLock_P2.setVisibility(View.INVISIBLE);

        txtAcertou.setVisibility(View.INVISIBLE);
        txtErrou.setVisibility(View.INVISIBLE);
        txtAcertouP2.setVisibility(View.INVISIBLE);
        txtErrouP2.setVisibility(View.INVISIBLE);
        txtTempoLock.setVisibility(View.INVISIBLE);

        bg_Resposta1_clicked.setVisibility(View.INVISIBLE);
        bg_Resposta2_clicked.setVisibility(View.INVISIBLE);
        bg_Resposta3_clicked.setVisibility(View.INVISIBLE);

        txtParabens.setVisibility(View.INVISIBLE);
        bg_txt_fim.setVisibility(View.INVISIBLE);
        bg_fim.setVisibility(View.INVISIBLE);

        nomesP1.setVisibility(View.INVISIBLE);
        nomesP2.setVisibility(View.INVISIBLE);
        pontosP1_P1.setVisibility(View.INVISIBLE);
        pontosP2_P1.setVisibility(View.INVISIBLE);
        pontosP1_P2.setVisibility(View.INVISIBLE);
        pontosP2_P2.setVisibility(View.INVISIBLE);

        atualizarPerguntaP1(controladores.getPerguntaP1()); // ta faltando instanciar na posição 0
        atualizarPerguntaP2(controladores.getPerguntaP2());
    }

    public void finalizaJogo(){ // Remover todas as ImageView de perguntas e colocar o nome FIM DE JOGO, utilizar atributo em Controladores para gerenciar isto
        tempoP1.setText("FIM!");
        tempoP2.setText("FIM!");

        txtParabens.setVisibility(View.VISIBLE);
        bg_txt_fim.setVisibility(View.VISIBLE);
        bg_fim.setVisibility(View.VISIBLE);
        nomesP1.setVisibility(View.VISIBLE);
        nomesP2.setVisibility(View.VISIBLE);
        pontosP1_P1.setVisibility(View.VISIBLE);
        pontosP2_P1.setVisibility(View.VISIBLE);
        pontosP1_P2.setVisibility(View.VISIBLE);
        pontosP2_P2.setVisibility(View.VISIBLE);

        Usuario vencedor = controladores.testaVencedor(player1, player2);

        txtParabens.setText("PARABÉNS: " + vencedor.getNome());// Fazer, de alguma forma, não ser possível clicar nos botões por quando aparecer essa janela
        if (vencedor.getId() == 1){txtParabens.setRotation(180);}
        nomesP1.setText(player1.getNome() + "  VS  " + player2.getNome());
        nomesP2.setText(player1.getNome() + "  VS  " + player2.getNome());
        pontosP1_P1.setText(Integer.toString(player1.getPontuacao()));
        pontosP2_P1.setText(Integer.toString(player2.getPontuacao()));
        pontosP1_P2.setText(Integer.toString(player1.getPontuacao()));
        pontosP2_P2.setText(Integer.toString(player2.getPontuacao()));
    }

    public void travaProximaPergunta(){ // Abstrair método para os dois players
        controladores.setLiberaProxPerguntaP1(false);

        btn_pular.setVisibility(View.INVISIBLE);
        btn_pular_lock.setVisibility(View.VISIBLE);
        btn_confirma.setVisibility(View.INVISIBLE);
        btn_confirma_lock.setVisibility(View.VISIBLE);

        new CountDownTimer(6000, 1000) {
            public void onTick(long millisUntilFinished) {

                int seconds = (int) ((millisUntilFinished / 1000) + 1);
                if(seconds<=5) {
                    txtTempoLock.setVisibility(View.VISIBLE);
                    txtTempoLock.setText(Integer.toString(seconds));
                }

            }
            public void onFinish() {
                btn_pular.setVisibility(View.VISIBLE);
                btn_pular_lock.setVisibility(View.INVISIBLE);
                btn_confirma.setVisibility(View.VISIBLE);
                btn_confirma_lock.setVisibility(View.INVISIBLE);
                txtTempoLock.setVisibility(View.INVISIBLE);
                controladores.setLiberaProxPerguntaP1(true);
            }
        }.start();
    }

    public void travaProximaPerguntaP2(){
        controladores.setLiberaProxPerguntaP2(false);

        btn_pular_P2.setVisibility(View.INVISIBLE);
        btn_pular_lock_P2.setVisibility(View.VISIBLE);
        btn_confirma_P2.setVisibility(View.INVISIBLE);
        btn_confirma_lock_P2.setVisibility(View.VISIBLE);

        new CountDownTimer(6000, 1000) {
            public void onTick(long millisUntilFinished) {

                int seconds = (int) ((millisUntilFinished / 1000) + 1);
                if(seconds<=5) {
                    txtTempoLock_P2.setVisibility(View.VISIBLE);
                    txtTempoLock_P2.setText(Integer.toString(seconds));
                }

            }
            public void onFinish() {
                btn_pular_P2.setVisibility(View.VISIBLE);
                btn_pular_lock_P2.setVisibility(View.INVISIBLE);
                btn_confirma_P2.setVisibility(View.VISIBLE);
                btn_confirma_lock_P2.setVisibility(View.INVISIBLE);
                txtTempoLock_P2.setVisibility(View.INVISIBLE);
                controladores.setLiberaProxPerguntaP2(true);
            }
        }.start();
    }
}
