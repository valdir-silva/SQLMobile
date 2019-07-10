package com.example.sqlmobile;

import java.util.ArrayList;
import java.util.List;

public class Pergunta {

    private int id;
    private String pergunta;
    List<String> resposta = new ArrayList<String>();
    private int respostaCerta;
    private  int respostaMarcada;

    public Pergunta() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public List<String> getResposta() {
        return resposta;
    }

    public void setResposta(List<String> resposta) {
        this.resposta = resposta;
    }

    public int getRespostaCerta() {
        return respostaCerta;
    }

    public void setRespostaCerta(int respostaCerta) {
        this.respostaCerta = respostaCerta;
    }

    public int getRespostaMarcada() {
        return respostaMarcada;
    }

    public void setRespostaMarcada(int respostaMarcada) {
        this.respostaMarcada = respostaMarcada;
    }
}
