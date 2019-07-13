package com.example.sqlmobile;

public class Controladores {
    private int perguntaP1; // Abstrair para os dois Players
    private int perguntaP2;

    public Controladores(){
        setPerguntaP1(1);
        setPerguntaP2(1);
    }

    public int getPerguntaP1() {
        return perguntaP1;
    }

    public void setPerguntaP1(int perguntaP1) {
        this.perguntaP1 = perguntaP1;
    }

    public int getPerguntaP2() {
        return perguntaP2;
    }

    public void setPerguntaP2(int perguntaP2) {
        this.perguntaP2 = perguntaP2;
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
}
