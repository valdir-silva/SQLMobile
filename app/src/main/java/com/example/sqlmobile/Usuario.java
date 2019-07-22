package com.example.sqlmobile;

public class Usuario {

    private int id;
    private String nome;
    private int pontuacao;
    private boolean ativo;
    private boolean travaPergunta;
    private Controlador controlador = new Controlador();

    public Usuario () {
        this.setAtivo(true);
        this.setTravaPergunta(false);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isTravaPergunta() {
        return travaPergunta;
    }

    public void setTravaPergunta(boolean travaPergunta) {
        this.travaPergunta = travaPergunta;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
}
