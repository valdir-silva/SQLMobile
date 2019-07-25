package com.example.sqlmobile;

import android.os.CountDownTimer;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sqlmobile.database.PerguntaDAO;

import java.util.ArrayList;
import java.util.List;

public class Controlador implements Parcelable {
    private int pergunta;
    private boolean finalizaPlayer;
    private List<TextView> textosPlayer = new ArrayList<TextView>();
    private List<ImageView> imagensPlayer = new ArrayList<ImageView>();
    private List<ImageView> botoes = new ArrayList<>();
    private List<ImageView> botoesClicked = new ArrayList<>();
    private List<ImageView> botoesLock = new ArrayList<>();
    private int tempoTravado;
    private TextView tempo;
    private TextView tempoLock;
    private TextView pontos;
    private TextView acertou;
    private TextView errou;

    public Controlador(){
        this.setPergunta(0);
    }

    protected Controlador(Parcel in) {
        pergunta = in.readInt();
        finalizaPlayer = in.readByte() != 0;
        tempoTravado = in.readInt();
    }

    public static final Creator<Controlador> CREATOR = new Creator<Controlador>() {
        @Override
        public Controlador createFromParcel(Parcel in) {
            return new Controlador(in);
        }

        @Override
        public Controlador[] newArray(int size) {
            return new Controlador[size];
        }
    };

    public int getPergunta() {
        return pergunta;
    }

    public void setPergunta(int pergunta) {
        this.pergunta = pergunta;
    }

    public Usuario testaVencedor(Usuario p1, Usuario p2){

        Usuario vencedor;

        if(p1.getPontuacao() > p2.getPontuacao()){
            vencedor = p1;
        } else if (p1.getPontuacao() < p2.getPontuacao()){
            vencedor = p2;
        } else {
            vencedor = null;
        }
        return vencedor;
    }

    public boolean isFinalizaPlayer() {
        return finalizaPlayer;
    }

    public void setFinalizaPlayer(boolean finalizaPlayer) {
        this.finalizaPlayer = finalizaPlayer;
    }

    public List<TextView> getTextosPlayer() {
        return textosPlayer;
    }

    public void setTextosPlayer(List<TextView> textosPlayer) {
        this.textosPlayer = textosPlayer;
    }

    public List<ImageView> getImagensPlayer() {
        return imagensPlayer;
    }

    public void setImagensPlayer(List<ImageView> imagensPlayer) {
        this.imagensPlayer = imagensPlayer;
    }

    public List<ImageView> getBotoes() {
        return botoes;
    }

    public void setBotoes(List<ImageView> botoes) {
        this.botoes = botoes;
    }

    public List<ImageView> getBotoesClicked() {
        return botoesClicked;
    }

    public void setBotoesClicked(List<ImageView> botoesClicked) {
        this.botoesClicked = botoesClicked;
    }

    public List<ImageView> getBotoesLock() {
        return botoesLock;
    }

    public void setBotoesLock(List<ImageView> botoesLock) {
        this.botoesLock = botoesLock;
    }

    public int getTempoTravado() {
        return tempoTravado;
    }

    public void setTempoTravado(int tempoTravado) {
        this.tempoTravado = tempoTravado;
    }

    public TextView getTempo() {
        return tempo;
    }

    public void setTempo(TextView tempo) {
        this.tempo = tempo;
    }

    public TextView getTempoLock() {
        return tempoLock;
    }

    public void setTempoLock(TextView tempoLock) {
        this.tempoLock = tempoLock;
    }

    public TextView getPontos() {
        return pontos;
    }

    public void setPontos(TextView pontos) {
        this.pontos = pontos;
    }

    public TextView getAcertou() {
        return acertou;
    }

    public void setAcertou(TextView acertou) {
        this.acertou = acertou;
    }

    public TextView getErrou() {
        return errou;
    }

    public void setErrou(TextView errou) {
        this.errou = errou;
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

    public void atualizarPergunta(Usuario player, List<Pergunta> listaPerguntas){
        try {
            int numPergunta = player.getControlador().getPergunta();
            //usar for para diminuir linhas de codigo aqui
            player.getControlador().getTextosPlayer().get(0).setText(listaPerguntas.get(numPergunta).getPergunta());
            for(int i = 0 ; i <= 2; i++){ player.getControlador().getTextosPlayer().get(i+1).setText(listaPerguntas.get(numPergunta).getResposta().get(i));}

            for(int i = 0 ; i <= 2; i++){ player.getControlador().getBotoes().get(i).setVisibility(View.VISIBLE);}
            for(int i = 0 ; i <= 2; i++){ player.getControlador().getBotoesClicked().get(i).setVisibility(View.INVISIBLE);}

        } catch (IndexOutOfBoundsException e){
            player.getControlador().finalizaPlayer(player);
        }
    }

    public void marcarResposta (Usuario player, int numero, List<Pergunta> listaPerguntas){ // testar colocar esse método na classe Controlador
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

    public void confirmaResposta(Usuario player, FrontEnd f, List<Pergunta> listaPerguntas){ // QUANDO PONTUACAO FICAR NEGATIVA DEIXAR BG VERMELHO
        if(!player.isTravaPergunta()){
            if (listaPerguntas.get(player.getControlador().getPergunta()).getRespostaCerta() == listaPerguntas.get(player.getControlador().getPergunta()).getRespostaMarcada()){
                player.getControlador().mostrarTexto(player.getControlador().getAcertou());
                player.setPontuacao(player.getPontuacao()+1);
            } else {
                player.getControlador().mostrarTexto(player.getControlador().getErrou());
                player.setPontuacao(player.getPontuacao()-1);
            }
            player.getControlador().getPontos().setText(Integer.toString(player.getPontuacao()));
            player.getControlador().setPergunta(player.getControlador().getPergunta()+1);
            player.getControlador().atualizarPergunta(player, listaPerguntas);
            player.getControlador().travaProximaPergunta(player);
        }
    }

    public void travaProximaPergunta(final Usuario player){
        if (player.isAtivo()){
            player.setTravaPergunta(true);

            player.getControlador().getBotoes().get(3).setVisibility(View.INVISIBLE);
            player.getControlador().getBotoes().get(4).setVisibility(View.INVISIBLE);
            player.getControlador().getBotoesLock().get(0).setVisibility(View.VISIBLE);
            player.getControlador().getBotoesLock().get(1).setVisibility(View.VISIBLE);

            new CountDownTimer(player.getControlador().getTempoTravado()*1000, 1000) {
                public void onTick(long millisUntilFinished) {

                    int seconds = (int) ((millisUntilFinished / 1000) + 1);
                    if(seconds<=(player.getControlador().getTempoTravado()-1)) {
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

    public void pularPergunta(Usuario player, List<Pergunta> listaPerguntas){
        player.getControlador().setPergunta(player.getControlador().getPergunta()+1);
        player.getControlador().atualizarPergunta(player, listaPerguntas);
        player.getControlador().travaProximaPergunta(player);
    }

    public void organizaFront(Usuario p1, Usuario p2, FrontEnd f, List<Pergunta> listaPerguntas){
        p1.getControlador().getPontos().setText(Integer.toString(p1.getPontuacao()));
        p2.getControlador().getPontos().setText(Integer.toString(p2.getPontuacao()));

        //Colocar uma animação no confirmar e pular, usar contador de tempo e uma imageview diferente
        //Utilizar objeto e for para diminuir linhas
        p1.getControlador().getBotoesLock().get(0).setVisibility(View.INVISIBLE);
        p1.getControlador().getBotoesLock().get(1).setVisibility(View.INVISIBLE);

        p1.getControlador().getTempoLock().setVisibility(View.INVISIBLE);

        p2.getControlador().getBotoesLock().get(0).setVisibility(View.INVISIBLE);
        p2.getControlador().getBotoesLock().get(1).setVisibility(View.INVISIBLE);

        p2.getControlador().getTempoLock().setVisibility(View.INVISIBLE);

        p1.getControlador().getAcertou().setVisibility(View.INVISIBLE);
        p2.getControlador().getAcertou().setVisibility(View.INVISIBLE);
        p1.getControlador().getErrou().setVisibility(View.INVISIBLE);
        p2.getControlador().getErrou().setVisibility(View.INVISIBLE);

        p1.getControlador().getTempoLock().setVisibility(View.INVISIBLE);

        for(int i = 0 ; i <= 2; i++){ p1.getControlador().getBotoesClicked().get(i).setVisibility(View.INVISIBLE);}

        for(int i = 0 ; i <= 2; i++){ f.getParabensTxt().get(i).setVisibility(View.INVISIBLE);}

        for(int i = 3 ; i <= 6; i++){ f.getParabensTxt().get(i).setVisibility(View.INVISIBLE);}

        f.getParabensImg().get(0).setVisibility(View.INVISIBLE);
        f.getParabensImg().get(1).setVisibility(View.INVISIBLE);

        p1.getControlador().getTextosPlayer().get(4).setVisibility(View.INVISIBLE);
        p2.getControlador().getTextosPlayer().get(4).setVisibility(View.INVISIBLE);

        p1.getControlador().atualizarPergunta(p1, listaPerguntas); // pode dar problema por estar atualizando outra instancia da classe Usuario
        p2.getControlador().atualizarPergunta(p2, listaPerguntas);
    }

    public void finalizaJogo(Usuario p1, Usuario p2, FrontEnd f){ // Remover todas as ImageView de perguntas e colocar o nome FIM DE JOGO, utilizar atributo em Controlador para gerenciar isto
        p1.getControlador().getTempo().setText("FIM!");
        p2.getControlador().getTempo().setText("FIM!");

        //criar atributo contendo todas as imagens e textos da tela de fim de jogo

        for(TextView textosFim : f.getParabensTxt()){
            textosFim.setVisibility(View.VISIBLE);
        }

        for(ImageView imagensFim : f.getParabensImg()){
            imagensFim.setVisibility(View.VISIBLE);
        }

        Usuario vencedor = new Usuario().getControlador().testaVencedor(p1, p2);

        try {
            f.getParabensTxt().get(0).setText("PARABÉNS: " + vencedor.getNome());
            if (vencedor.getId() == 1){f.getParabensTxt().get(0).setRotation(180);}
        } catch (Exception e){
            f.getParabensTxt().get(0).setText("EMPATE");
        }

        f.getParabensTxt().get(1).setText(p1.getNome() + "  VS  " + p2.getNome());
        f.getParabensTxt().get(2).setText(p1.getNome() + "  VS  " + p2.getNome());
        f.getParabensTxt().get(3).setText(Integer.toString(p1.getPontuacao()));
        f.getParabensTxt().get(4).setText(Integer.toString(p2.getPontuacao()));
        f.getParabensTxt().get(5).setText(Integer.toString(p1.getPontuacao()));
        f.getParabensTxt().get(6).setText(Integer.toString(p2.getPontuacao()));
    }

    public PerguntaDAO preencheLista(PerguntaDAO dao){

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

        return dao;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(pergunta);
        dest.writeByte((byte) (finalizaPlayer ? 1 : 0));
        dest.writeInt(tempoTravado);
    }
}
