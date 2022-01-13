package com.example.voltify5d;

import java.io.Serializable;

public class Brano implements Serializable
{
    private String titolo;
    private String autore;
    private int durata;

    public Brano(String titolo, String autore, int durata)
    {
        this.titolo = titolo;
        this.autore = autore;
        this.durata = durata;
    }

    @Override
    public String toString() {
        return "Brano{" +
                "titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", durata=" + durata +
                '}';
    }
}
