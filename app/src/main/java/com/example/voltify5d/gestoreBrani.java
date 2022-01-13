package com.example.voltify5d;

import java.util.ArrayList;

public class gestoreBrani
{
    ArrayList<Brano> listaBrani;
    public gestoreBrani()
    {
        listaBrani = new ArrayList<Brano>();
    }

    public void addBrano(String titolo, String autore, int durata)
    {
        Brano br = new Brano(titolo, autore, durata);
    }

    public void viewBrani()
    {

    }
}
