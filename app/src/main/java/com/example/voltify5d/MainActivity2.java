package com.example.voltify5d;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extras = getIntent().getExtras();
        ArrayList<Brano> gb = (ArrayList<Brano>) extras.getSerializable("key");

        System.out.println(gb.toString());
    }
}