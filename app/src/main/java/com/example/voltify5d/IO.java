package com.example.voltify5d;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

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
     * create (if not exist) a file and write the list in
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
}

