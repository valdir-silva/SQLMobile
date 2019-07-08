package com.example.sqlmobile;

public class Pergunta {

    private int id;
    private String pergunta;
    private String resposta[];
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

    public String[] getResposta() {
        return resposta;
    }

    public void setResposta(String resposta1) {
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
