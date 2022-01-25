package com.example.voltify5d;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.listView = findViewById(R.id.listView);

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


        Log.d("Final", gb.toString());
    }
}