package com.example.voltify5d;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    ListView listView;

    Button export;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        this.export = findViewById(R.id.btnExp);

        this.listView = findViewById(R.id.listView);
        builder = new AlertDialog.Builder(this);
        Bundle extras = getIntent().getExtras();

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
        export.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IO.writeToFile(Memory.brani.toString(), getApplicationContext());
            }
        });

    }
}