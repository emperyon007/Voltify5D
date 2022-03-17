package com.example.voltify5d;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IO
{

    /***
     * Method: writeToFile
     * create (if not exist) a file and write the list in (Dev file exp)
     * @param s
     * @param context
     */
    public static void writeToFile(String s, Context context)
    {
        try {
            FileWriter out = new FileWriter(new File(context.getFilesDir(), "backup"));
            Log.i("PathToFile", context.getFilesDir().getAbsolutePath());
            out.write(s);
            out.close();
        } catch (IOException e) {
            Log.i("WriteOP", e.getMessage());
        }
    }

    public static String readFile(String fileName, Context c)
    {
        BufferedReader fileIn = null;
        String outputFile;
        StringBuilder strB = new StringBuilder();

        try
        {
            fileIn= new BufferedReader(new InputStreamReader(c.openFileInput(fileName)));
            while((outputFile = fileIn.readLine()) != null)
            {
                strB.append(outputFile + "\n");
            }
        }
        catch(FileNotFoundException e)
        {
            Log.e("FileStatus", "File does not exists");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return strB.toString();
    }

    /***
     * Method: readFileRaw
     * Get file from dir "raw" and read it
     * @param c
     * @return
     */
    public static String readFileRaw(Context c)
    {
        BufferedReader fileIn = null;
        String outputFile;
        StringBuilder strB = new StringBuilder();

        Resources res = c.getResources();

        InputStream is = res.openRawResource(R.raw.brani);

        try
        {
            fileIn= new BufferedReader(new InputStreamReader(is));
            while((outputFile = fileIn.readLine()) != null)
            {
                strB.append(outputFile + "\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return strB.toString();
    }

    public static void readFileJson(Context c) throws JSONException {
        BufferedReader fileIn = null;
        String outputFile;
        StringBuilder strB = new StringBuilder();

        Resources res = c.getResources();

        InputStream is = res.openRawResource(R.raw.json_file);

        try
        {
            fileIn= new BufferedReader(new InputStreamReader(is));
            while((outputFile = fileIn.readLine()) != null)
            {
                strB.append(outputFile + "\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //return strB.toString();


        JSONObject jsonObject = new JSONObject(strB.toString());
        JSONArray jsonArrayB = jsonObject.getJSONArray("Brano");
        String[] brani = new String[jsonArrayB.length()];

        for(int i=0;i < jsonArrayB.length();i++) {
            Log.d("Brani", brani[i] = jsonArrayB.getString(i));
        }

        Log.d("BraniS", brani[0]);
        Log.d("BraniS", brani[1]);

        /*
        JSONArray jsonArray = new JSONArray(strB.toString());

        for (int i = 0; i < jsonArray.length(); i++) {
            //JSONObject jsonObject = jsonArray.getJSONObject(i);
            String value = jsonArray.getString(i);
        }


        JSONObject jsObj = new JSONObject(strB.toString());
        String titolo = jsObj.getString("Titolo");
        String autore = jsObj.getString("Autore");
        String genere = jsObj.getString("Genere");
        int durata = jsObj.getInt("Durata");


        Integer minuti = durata / 60;
        Integer secondi = durata % 60;

        Brano toAppend = new Brano
                (
                        titolo,
                        autore,
                        genere,
                        minuti + ":" + String.format("%02d", secondi)
                );

        return toAppend.toString();
         */
    }
}

