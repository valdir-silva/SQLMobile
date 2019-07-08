package com.example.sqlmobile;

public class Pergunta {

    private int id;
    private String pergunta;
    private String resposta1;
    private String resposta2; //alterar isso por um array
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

    public String getResposta1() {
        return resposta1;
    }

    public void setResposta1(String resposta1) {
        this.resposta1 = resposta1;
    }

    public String getResposta2() {
        return resposta2;
    }

    public void setResposta2(String resposta2) {
        this.resposta2 = resposta2;
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
