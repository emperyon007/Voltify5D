package com.example.voltify5d;

import java.util.ArrayList;
import java.util.List;

public class gestoreBrani
{
    ArrayList<Brano> listaBrani;

    /**
     * Method: gestoreBrani
     * constructor for gestoreBrani
     */
    public gestoreBrani()
    {
        listaBrani = new ArrayList<Brano>();
    }

    /**
     * Method: addBrano
     * Instances a new track and adds it to the list
     * @param titolo
     * @param autore
     * @param genere
     * @param durata
     */
    public void addBrano(String titolo, String autore, String genere, String durata)
    {
        Brano br = new Brano(titolo, autore, genere, durata);
        this.listaBrani.add(br);
    }

    public void viewBrani()
    {

    }
}
