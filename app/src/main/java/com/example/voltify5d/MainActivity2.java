package com.example.voltify5d;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONException;

import java.util.StringTokenizer;

public class MainActivity2 extends AppCompatActivity {

    ListView listView;

    Button exp;
    Button imp;
    Button clear;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        this.exp = findViewById(R.id.btnExp);
        this.imp = findViewById(R.id.btnImp);
        this.clear = findViewById(R.id.btnClear);

        findViewById(R.id.loadingPanel).setVisibility(View.GONE);

        this.listView = findViewById(R.id.listView);
        builder = new AlertDialog.Builder(this);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                Memory.brani );

        listView.setAdapter(arrayAdapter);

        Log.i("Final", Memory.brani.toString());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            /**
             * Method: onItemClick
             * when item is clicked displays option to delete it
             * @param parent
             * @param view
             * @param position
             * @param id
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id)
            {
                Log.i("clicked item", ""  + position);

                builder.setMessage("Do you want to delete this item?")
                        .setCancelable(false)
                        .setPositiveButton("Delete", new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int id)
                            {
                                Log.i("Yes", "Yes");

                                Memory.brani.remove(position);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("Keep", new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int id)
                            {
                                dialog.cancel();
                                Log.i("No", "No");
                            }
                        });
                arrayAdapter.notifyDataSetChanged();

                AlertDialog alert = builder.create();
                alert.setTitle("Alert");
                alert.show();
            }
        });

        /***
         * Method: onClick
         * on click use "writeToFile" function to export list
         */
        exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IO.writeToFile(Memory.brani.toString(), getApplicationContext());
            }
        });

        imp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fileText = IO.readFileRaw(getApplicationContext());

                try {
                    IO.readFileJson(getApplicationContext());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.d("printed", fileText);

                findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                        arrayAdapter.notifyDataSetChanged();
                    }
                }, 2000);

            }

        });

        clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            /***
             * Method: onClick
             * when button is clicked displays option to clear the list
             */
            public void onClick(View view)
            {
                builder.setMessage("Do you want to clear the list?")
                        .setCancelable(false)
                        .setPositiveButton("Clear", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                Memory.brani.clear();
                                arrayAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("Keep", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.cancel();
                            }
                        });

                AlertDialog alert = builder.create();
                alert.setTitle("Alert");
                alert.show();
            }
        });

    }

}