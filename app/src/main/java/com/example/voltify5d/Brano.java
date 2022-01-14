package com.example.voltify5d;

import java.io.Serializable;

public class Brano implements Serializable
{
    private String titolo;
    private String autore;
    private String genere;
    private int durata;

    public Brano(String titolo, String autore, String genere, int durata)
    {
        this.titolo = titolo;
        this.autore = autore;
        this.genere = genere;
        this.durata = durata;
    }

    @Override
    public String toString() {
        return
                "" + titolo +
                "\n" + autore +
                " | " + genere +
                " | " + durata +
                "\"";
    }
}
