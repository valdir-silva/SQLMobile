package com.example.sqlmobile;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Controlador {
    private int pergunta;
    private boolean finalizaPlayer;
    private List<TextView> textosPlayer = new ArrayList<TextView>();
    private List<ImageView> imagensPlayer = new ArrayList<ImageView>();
    private List<ImageView> botoes = new ArrayList<>();
    private List<ImageView> botoesClicked = new ArrayList<>();
    private List<ImageView> botoesLock = new ArrayList<>();
    private TextView tempo;
    private TextView tempoLock;
    private TextView pontos;

    public Controlador(){
        this.setPergunta(0);
    }

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
        } else {
            vencedor = p2;
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
}
