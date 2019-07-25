package com.example.sqlmobile;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {

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

    protected Usuario(Parcel in) {
        id = in.readInt();
        nome = in.readString();
        pontuacao = in.readInt();
        ativo = in.readByte() != 0;
        travaPergunta = in.readByte() != 0;
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nome);
        dest.writeInt(pontuacao);
        dest.writeByte((byte) (ativo ? 1 : 0));
        dest.writeByte((byte) (travaPergunta ? 1 : 0));
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
