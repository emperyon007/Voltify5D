package com.example.voltify5d;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
}
