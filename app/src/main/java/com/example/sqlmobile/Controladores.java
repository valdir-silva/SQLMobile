package com.example.sqlmobile;

public class Controladores {
    private int perguntaP1; // Abstrair para os dois Players
    private int perguntaP2;
    private boolean liberaProxPerguntaP1;
    private boolean liberaProxPerguntaP2;

    public Controladores(){
        this.setPerguntaP1(0);
        this.setPerguntaP2(0);
        this.setLiberaProxPerguntaP1(false);
        this.setLiberaProxPerguntaP2(false);
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

    public boolean isLiberaProxPerguntaP1() {
        return liberaProxPerguntaP1;
    }

    public void setLiberaProxPerguntaP1(boolean liberaProxPerguntaP1) {
        this.liberaProxPerguntaP1 = liberaProxPerguntaP1;
    }

    public boolean isLiberaProxPerguntaP2() {
        return liberaProxPerguntaP2;
    }

    public void setLiberaProxPerguntaP2(boolean liberaProxPerguntaP2) {
        this.liberaProxPerguntaP2 = liberaProxPerguntaP2;
    }
}
