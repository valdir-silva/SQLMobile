package com.example.sqlmobile;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sqlmobile.database.PerguntaDAO;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class Multiplayer extends AppCompatActivity {

    TextView  Resposta1, Resposta2, Resposta3, Resposta1_P2, Resposta2_P2, Resposta3_P2;

    ImageView bg_Resposta1, bg_Resposta1_clicked, bg_Resposta2, bg_Resposta2_clicked, bg_Resposta3, bg_Resposta3_clicked;
    ImageView bg_Resposta1_P2, bg_Resposta1_clicked_P2, bg_Resposta2_P2, bg_Resposta2_clicked_P2, bg_Resposta3_P2, bg_Resposta3_clicked_P2;
    ImageView btn_pular, btn_pular_P2;
    ImageView btn_confirma, btn_confirma_P2;

    TextView tempoP1, tempoP2;

    TextView pontosP1, pontosP2;

    Usuario player1 = new Usuario();
    Usuario player2 = new Usuario();

    List<Pergunta> listaPerguntas = new ArrayList<>();
    FrontEnd front = new FrontEnd();

    private PerguntaDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Retira a Action Bar
        setContentView(R.layout.activity_multiplayer);

        dao = new PerguntaDAO(this);

        bg_Resposta1 = findViewById(R.id.bg_Resposta1);
        bg_Resposta2 = findViewById(R.id.bg_Resposta2);
        bg_Resposta3 = findViewById(R.id.bg_Resposta3);

        btn_confirma = findViewById(R.id.btn_confirma);
        btn_pular = findViewById(R.id.btn_pular);

        Resposta1_P2 = findViewById(R.id.Resposta1_P2);
        Resposta2_P2 = findViewById(R.id.Resposta2_P2);
        Resposta3_P2 = findViewById(R.id.Resposta3_P2);

        btn_confirma_P2 = findViewById(R.id.btn_confirma_P2);
        btn_pular_P2 = findViewById(R.id.btn_pular_P2);

        //

        Resposta1 = findViewById(R.id.Resposta1);
        Resposta2 = findViewById(R.id.Resposta2);
        Resposta3 = findViewById(R.id.Resposta3);

        bg_Resposta1 = findViewById(R.id.bg_Resposta1);
        bg_Resposta1_clicked = findViewById(R.id.bg_Resposta1_clicked);
        bg_Resposta2 = findViewById(R.id.bg_Resposta2);
        bg_Resposta2_clicked = findViewById(R.id.bg_Resposta2_clicked);
        bg_Resposta3 = findViewById(R.id.bg_Resposta3);
        bg_Resposta3_clicked = findViewById(R.id.bg_Resposta3_clicked);

        //

        bg_Resposta1_P2 = findViewById(R.id.bg_Resposta1_P2);
        bg_Resposta1_clicked_P2 = findViewById(R.id.bg_Resposta1_clicked_P2);
        bg_Resposta2_P2 = findViewById(R.id.bg_Resposta2_P2);
        bg_Resposta2_clicked_P2 = findViewById(R.id.bg_Resposta2_clicked_P2);
        bg_Resposta3_P2 = findViewById(R.id.bg_Resposta3_P2);
        bg_Resposta3_clicked_P2 = findViewById(R.id.bg_Resposta3_clicked_P2);

        // pensar em instanciar objetos diretamente do findviewbyid IMPORTANT (é possível fazer isso e ainda fazer direto nas classes)

        // Abaixo: Instanciando e inicializando objetos e atributos
        player1.setPontuacao(0);
        player2.setPontuacao(0);
        player1.setId(0);
        player2.setId(1);
        player1.setNome("Player 1"); // Limitar nickname para 10 caracteres
        player2.setNome("Player 2");

        preencheLista();
        listaPerguntas = dao.obterTudo();

        //FIM INSTANCIANDO E INICIALIZANDO

        // Populando listas com Front-End de cada player - PLAYER 1
        player1.getControlador().getTextosPlayer().add((TextView)findViewById(R.id.PerguntaPlayer1));
        player1.getControlador().getTextosPlayer().add((TextView)findViewById(R.id.Resposta1));
        player1.getControlador().getTextosPlayer().add((TextView)findViewById(R.id.Resposta2));
        player1.getControlador().getTextosPlayer().add((TextView)findViewById(R.id.Resposta3));
        player1.getControlador().getTextosPlayer().add((TextView)findViewById(R.id.txtFinalizouPlayer));

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

        // Populando listas com Front-End de cada player - PLAYER 2
        player2.getControlador().getTextosPlayer().add((TextView)findViewById(R.id.PerguntaPlayer2));
        player2.getControlador().getTextosPlayer().add((TextView)findViewById(R.id.Resposta1_P2));
        player2.getControlador().getTextosPlayer().add((TextView)findViewById(R.id.Resposta2_P2));
        player2.getControlador().getTextosPlayer().add((TextView)findViewById(R.id.Resposta3_P2));
        player2.getControlador().getTextosPlayer().add((TextView)findViewById(R.id.txtFinalizouPlayer2));

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
        player2.getControlador().getBotoesClicked().add(bg_Resposta3_clicked_P2);

        player2.getControlador().getBotoesLock().add((ImageView) findViewById(R.id.btn_confirma_lock_P2));
        player2.getControlador().getBotoesLock().add((ImageView) findViewById(R.id.btn_pular_lock_P2));

        player2.getControlador().setTempo((TextView) findViewById(R.id.tempoP2));
        player2.getControlador().setTempoLock((TextView) findViewById(R.id.txtTempoLock_P2));
        player2.getControlador().setPontos((TextView) findViewById(R.id.pontosP2));

        // Populando resto do Front

        front.getTextos().add((TextView) findViewById(R.id.txtAcertou));
        front.getTextos().add((TextView) findViewById(R.id.txtErrou));
        front.getTextos().add((TextView) findViewById(R.id.txtAcertouP2));
        front.getTextos().add((TextView) findViewById(R.id.txtErrouP2));

        front.getParabensTxt().add((TextView) findViewById(R.id.txtParabens));
        front.getParabensTxt().add((TextView) findViewById(R.id.nomesP1));
        front.getParabensTxt().add((TextView) findViewById(R.id.nomesP2));
        front.getParabensTxt().add((TextView) findViewById(R.id.pontosP1_P1));
        front.getParabensTxt().add((TextView) findViewById(R.id.pontosP2_P1));
        front.getParabensTxt().add((TextView) findViewById(R.id.pontosP1_P2));
        front.getParabensTxt().add((TextView) findViewById(R.id.pontosP2_P2));

        front.getParabensImg().add((ImageView) findViewById(R.id.bg_txt_fim));
        front.getParabensImg().add((ImageView) findViewById(R.id.bg_fim));

        organizaFront(player1, player2, front); //COLOCANDO VALORES FRONT-END
        travaProximaPergunta(player1);
        travaProximaPergunta(player2);

        // FIM POPULANDO LISTA FRONT PLAYERS

        bg_Resposta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marcarResposta(player1, 0);
                listaPerguntas.get(player1.getControlador().getPergunta()).setRespostaMarcada(1);
            }
        });

        bg_Resposta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marcarResposta(player1, 1);
                listaPerguntas.get(player1.getControlador().getPergunta()).setRespostaMarcada(2);
            }
        });

        bg_Resposta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marcarResposta(player1, 2);
                listaPerguntas.get(player1.getControlador().getPergunta()).setRespostaMarcada(3);
            }
        });

        // PLAYER 2

        bg_Resposta1_clicked_P2.setVisibility(View.INVISIBLE); // colocar no metodo front
        bg_Resposta2_clicked_P2.setVisibility(View.INVISIBLE);

        bg_Resposta1_P2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marcarResposta(player2, 0);
                listaPerguntas.get(player2.getControlador().getPergunta()).setRespostaMarcada(1);
            }
        });

        bg_Resposta2_P2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marcarResposta(player2, 1);
                listaPerguntas.get(player2.getControlador().getPergunta()).setRespostaMarcada(2);
            }
        });

        bg_Resposta3_P2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marcarResposta(player2, 2);
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
                player1 = finalizaPlayer(player1); // enviando a instancia do player1 para setar o atributo 'ativo' como false
                player2 = finalizaPlayer(player2);
                finalizaJogo(player1, player2, front);
            }
        }.start();

        btn_confirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmaResposta(player1, front);
            }
        });

        btn_confirma_P2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmaResposta(player2, front);
            }
        });

        btn_pular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pularPergunta(player1);
            }
        });

        btn_pular_P2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pularPergunta(player2);
            }
        });
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

    public void atualizarPergunta(Usuario player){
        try {
            int numPergunta = player.getControlador().getPergunta();
            //usar for para diminuir linhas de codigo aqui
            player.getControlador().getTextosPlayer().get(0).setText(listaPerguntas.get(numPergunta).getPergunta());
            for(int i = 0 ; i <= 2; i++){ player.getControlador().getTextosPlayer().get(i+1).setText(listaPerguntas.get(numPergunta).getResposta().get(i));}

            for(int i = 0 ; i <= 2; i++){ player.getControlador().getBotoes().get(i).setVisibility(View.VISIBLE);}
            for(int i = 0 ; i <= 2; i++){ player.getControlador().getBotoesClicked().get(i).setVisibility(View.INVISIBLE);}

        } catch (IndexOutOfBoundsException e){
            player = finalizaPlayer(player); // ficou desnecessário nessa parte o objeto retornar
        }
    }

    public void organizaFront(Usuario p1, Usuario p2, FrontEnd f){
        p1.getControlador().getPontos().setText(Integer.toString(player1.getPontuacao()));
        p2.getControlador().getPontos().setText(Integer.toString(player2.getPontuacao()));

        //Colocar uma animação no confirmar e pular, usar contador de tempo e uma imageview diferente
        //Utilizar objeto e for para diminuir linhas
        p1.getControlador().getBotoesLock().get(0).setVisibility(View.INVISIBLE);
        p1.getControlador().getBotoesLock().get(1).setVisibility(View.INVISIBLE);

        p1.getControlador().getTempoLock().setVisibility(View.INVISIBLE);

        p2.getControlador().getBotoesLock().get(0).setVisibility(View.INVISIBLE);
        p2.getControlador().getBotoesLock().get(1).setVisibility(View.INVISIBLE);

        p2.getControlador().getTempoLock().setVisibility(View.INVISIBLE);

        for(int i = 0 ; i <= 3; i++){ f.getTextos().get(i).setVisibility(View.INVISIBLE);}

        p1.getControlador().getTempoLock().setVisibility(View.INVISIBLE);

        for(int i = 0 ; i <= 2; i++){ p1.getControlador().getBotoesClicked().get(i).setVisibility(View.INVISIBLE);}

        for(int i = 0 ; i <= 2; i++){ f.getParabensTxt().get(i).setVisibility(View.INVISIBLE);}

        for(int i = 3 ; i <= 6; i++){ f.getParabensTxt().get(i).setVisibility(View.INVISIBLE);}

        f.getParabensImg().get(0).setVisibility(View.INVISIBLE);
        f.getParabensImg().get(1).setVisibility(View.INVISIBLE);

        p1.getControlador().getTextosPlayer().get(4).setVisibility(View.INVISIBLE);
        p2.getControlador().getTextosPlayer().get(4).setVisibility(View.INVISIBLE);

        atualizarPergunta(p1); // pode dar problema por estar atualizando outra instancia da classe Usuario
        atualizarPergunta(p2);
    }

    public void finalizaJogo(Usuario p1, Usuario p2, FrontEnd f){ // Remover todas as ImageView de perguntas e colocar o nome FIM DE JOGO, utilizar atributo em Controlador para gerenciar isto
        p1.getControlador().getTempo().setText("FIM!");
        p2.getControlador().getTempo().setText("FIM!");

        //criar atributo contendo todas as imagens e textos da tela de fim de jogo

        for(TextView textosFim : front.getParabensTxt()){
            textosFim.setVisibility(View.VISIBLE);
        }

        for(ImageView imagensFim : front.getParabensImg()){
            imagensFim.setVisibility(View.VISIBLE);
        }

        Usuario vencedor = new Usuario().getControlador().testaVencedor(p1, p2);

        f.getParabensTxt().get(0).setText("PARABÉNS: " + vencedor.getNome());
        if (vencedor.getId() == 1){f.getParabensTxt().get(0).setRotation(180);}
        f.getParabensTxt().get(1).setText(player1.getNome() + "  VS  " + player2.getNome());
        f.getParabensTxt().get(2).setText(player1.getNome() + "  VS  " + player2.getNome());
        f.getParabensTxt().get(3).setText(Integer.toString(player1.getPontuacao()));
        f.getParabensTxt().get(4).setText(Integer.toString(player2.getPontuacao()));
        f.getParabensTxt().get(5).setText(Integer.toString(player1.getPontuacao()));
        f.getParabensTxt().get(6).setText(Integer.toString(player2.getPontuacao()));
    }

    public void travaProximaPergunta(final Usuario player){
        if (player.isAtivo()){
            player.setTravaPergunta(true);

            player.getControlador().getBotoes().get(3).setVisibility(View.INVISIBLE);
            player.getControlador().getBotoes().get(4).setVisibility(View.INVISIBLE);
            player.getControlador().getBotoesLock().get(0).setVisibility(View.VISIBLE);
            player.getControlador().getBotoesLock().get(1).setVisibility(View.VISIBLE);

            new CountDownTimer(6000, 1000) {
                public void onTick(long millisUntilFinished) {

                    int seconds = (int) ((millisUntilFinished / 1000) + 1);
                    if(seconds<=5) {
                        player.getControlador().getTempoLock().setVisibility(View.VISIBLE);
                        player.getControlador().getTempoLock().setText(Integer.toString(seconds));
                    }
                }
                public void onFinish() {
                    player.getControlador().getBotoes().get(3).setVisibility(View.VISIBLE);
                    player.getControlador().getBotoes().get(4).setVisibility(View.VISIBLE);
                    player.getControlador().getBotoesLock().get(0).setVisibility(View.INVISIBLE);
                    player.getControlador().getBotoesLock().get(1).setVisibility(View.INVISIBLE);

                    player.getControlador().getTempoLock().setVisibility(View.INVISIBLE);

                    player.setTravaPergunta(false);
                }
            }.start();
        }
    }

    public Usuario finalizaPlayer(Usuario player){

        for (TextView texto : player.getControlador().getTextosPlayer()){
            if(texto.getText().equals("FIM")){
                texto.setVisibility(View.VISIBLE);
            } else {
                texto.setVisibility(View.INVISIBLE);
            }
        }
        for (ImageView imagem : player.getControlador().getImagensPlayer()){
            imagem.setVisibility(View.INVISIBLE);
        }

        player.setAtivo(false);

        return player;
    }

    public void preencheLista(){

        Pergunta perguntaP2_1 = new Pergunta();
        perguntaP2_1.setPergunta("Qual dos seguintes NÃO é um tipo de join usado em SQL?");
        perguntaP2_1.getResposta().add("INNER JOIN");
        perguntaP2_1.getResposta().add("EXTRA JOIN");
        perguntaP2_1.getResposta().add("OUTER JOIN");
        perguntaP2_1.setRespostaCerta(2);
        dao.inserir(perguntaP2_1);

        Pergunta perguntaP2_2 = new Pergunta();
        perguntaP2_2.setPergunta("Para excluir um registro único de uma tabela, qual das seguintes declarações pode ser usada?");
        perguntaP2_2.getResposta().add("DELETE");
        perguntaP2_2.getResposta().add("REMOVE");
        perguntaP2_2.getResposta().add("TRUNCATE");
        perguntaP2_2.setRespostaCerta(2);
        dao.inserir(perguntaP2_2);

        Pergunta perguntaP2_3 = new Pergunta();
        perguntaP2_3.setPergunta("Caso você necessite inserir um novo registro no banco de dados, qual declaração deve utilizar?");
        perguntaP2_3.getResposta().add("INSERT INTO");
        perguntaP2_3.getResposta().add("ADD REGISTER");
        perguntaP2_3.getResposta().add("NEW DATA");
        perguntaP2_3.setRespostaCerta(1);
        dao.inserir(perguntaP2_3);

        Pergunta perguntaP2_4 = new Pergunta();
        perguntaP2_4.setPergunta("O que significa a sigla SQL?");
        perguntaP2_4.getResposta().add("Structured Quiz Language");
        perguntaP2_4.getResposta().add("Standard Question Language");
        perguntaP2_4.getResposta().add("Structured Query Language");
        perguntaP2_4.setRespostaCerta(3);
        dao.inserir(perguntaP2_4);

        Pergunta perguntaP2_5 = new Pergunta();
        perguntaP2_5.setPergunta("Precisamos programar um banco de dados para que, sempre que um determinado registro for inserido em uma tabela, uma ação específica seja realizada automaticamente. Qual estrutura nos permite programar isso?");
        perguntaP2_5.getResposta().add("TRIGGER");
        perguntaP2_5.getResposta().add("STORED PROCEDURE");
        perguntaP2_5.getResposta().add("VIEW");
        perguntaP2_5.setRespostaCerta(1);
        dao.inserir(perguntaP2_5);

        Pergunta perguntaP2_6 = new Pergunta();
        perguntaP2_6.setPergunta("Qual declaração devemos usar para efetuar uma consulta a um banco de dados?");
        perguntaP2_6.getResposta().add("CONSULT");
        perguntaP2_6.getResposta().add("SELECT");
        perguntaP2_6.getResposta().add("QUERY");
        perguntaP2_6.setRespostaCerta(2);
        dao.inserir(perguntaP2_6);
    }

    public void pularPergunta(Usuario player){
        player.getControlador().setPergunta(player.getControlador().getPergunta()+1);
        atualizarPergunta(player);
    }

    public void confirmaResposta(Usuario player, FrontEnd f){ // se levar ele para uma classe será necessário enviar e retornar a lista de perguntas
        if(!player.isTravaPergunta()){
            if (listaPerguntas.get(player.getControlador().getPergunta()).getRespostaCerta() == listaPerguntas.get(player.getControlador().getPergunta()).getRespostaMarcada()){
                mostrarTexto(f.getTextos().get(0));
                player.setPontuacao(player.getPontuacao()+1);
            } else {
                mostrarTexto(f.getTextos().get(1));
                player.setPontuacao(player.getPontuacao()-1);
            }
            player.getControlador().getPontos().setText(Integer.toString(player.getPontuacao()));
            player.getControlador().setPergunta(player.getControlador().getPergunta()+1);
            atualizarPergunta(player);
            travaProximaPergunta(player);
        }
    }

    public void preencheObjetos(){ //pensar em instanciar objetos em método global para carregar todos os dados nessa classe e nao na main

    }

    public void marcarResposta (Usuario player, int numero){ // testar colocar esse método na classe Controlador
        listaPerguntas.get(player.getControlador().getPergunta()).setRespostaMarcada(numero);

        for (int i = 0; i <= 2; i++){
            if(i == numero){
                player.getControlador().getBotoes().get(i).setVisibility(View.INVISIBLE);
                player.getControlador().getBotoesClicked().get(i).setVisibility(View.VISIBLE);
            } else {
                player.getControlador().getBotoes().get(i).setVisibility(View.VISIBLE);
                player.getControlador().getBotoesClicked().get(i).setVisibility(View.INVISIBLE);
            }
        }
    }
}
