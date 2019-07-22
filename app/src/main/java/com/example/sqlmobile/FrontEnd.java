package com.example.sqlmobile;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FrontEnd {
    List<ImageView> imagens = new ArrayList<>();
    List<TextView> textos = new ArrayList<>();
    List<ImageView> parabensImg = new ArrayList<>();
    List<TextView> parabensTxt = new ArrayList<>();

    public List<ImageView> getImagens() {
        return imagens;
    }

    public void setImagens(List<ImageView> imagens) {
        this.imagens = imagens;
    }

    public List<TextView> getTextos() {
        return textos;
    }

    public void setTextos(List<TextView> textos) {
        this.textos = textos;
    }

    public List<ImageView> getParabensImg() {
        return parabensImg;
    }

    public void setParabensImg(List<ImageView> parabensImg) {
        this.parabensImg = parabensImg;
    }

    public List<TextView> getParabensTxt() {
        return parabensTxt;
    }

    public void setParabensTxt(List<TextView> parabensTxt) {
        this.parabensTxt = parabensTxt;
    }
}
