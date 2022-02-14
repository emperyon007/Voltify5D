package com.example.voltify5d;

import java.io.Serializable;

public class Brano implements Serializable
{
    private String titolo;
    private String autore;
    private String genere;
    private String durata;

    /**
     * Method: Brano
     * constructor for Brano
     * @param titolo
     * @param autore
     * @param genere
     * @param durata
     */
    public Brano(String titolo, String autore, String genere, String durata)
    {
        this.titolo = titolo;
        this.autore = autore;
        this.genere = genere;
        this.durata = durata;
    }

    /**
     * Method: toString
     * returns a formal description of the track
     * @return
     */
    @Override
    public String toString() {
        return
                "" + titolo +
                "\n" + autore +
                " | " + genere +
                " | " + durata + "\n";
    }
}
