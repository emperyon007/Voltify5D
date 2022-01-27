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

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    ListView listView;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.listView = findViewById(R.id.listView);

        builder = new AlertDialog.Builder(this);

        Bundle extras = getIntent().getExtras();
        List<String> gbMap = new ArrayList<String>();
        List<Brano> gb = (ArrayList<Brano>) extras.getSerializable("key");

        for (Brano gbItem:gb)
        {
            gbMap.add(gbItem.toString());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                gbMap );

        listView.setAdapter(arrayAdapter);

        Log.i("Final", gb.toString());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
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

                                gb.remove(position);
                                gbMap.remove(position);
                                //arrayAdapter.remove(arrayAdapter.getItem(position));
                            }
                        })
                        .setNegativeButton("Undo", new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int id)
                            {
                                dialog.cancel();
                                Log.i("No", "No");
                            }
                        });

                AlertDialog alert = builder.create();
                alert.setTitle("Alert");
                alert.show();
            }
        });

    }
}