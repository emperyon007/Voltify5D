package com.example.voltify5d;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity
{
    gestoreBrani gb;

    EditText txtTitolo;
    EditText txtAutore;
    EditText txtDurata;

    Button submit;
    Button view;

    Spinner drpList;

    //private static Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtTitolo = findViewById(R.id.edtTitolo);
        this.txtAutore = findViewById(R.id.edtAutore);
        this.txtDurata = findViewById(R.id.edtDurata);

        this.submit = findViewById(R.id.btnSubmit);
        this.view = findViewById(R.id.btnView);

        this.drpList = findViewById(R.id.selectList);

        //MainActivity.context = getApplicationContext();

        gb = new gestoreBrani();

        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                gb.addBrano
                (
                    txtTitolo.getText().toString(),
                    txtAutore.getText().toString(),
                    Integer.parseInt(txtDurata.getText().toString())
                );

            }
        });

        view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = (new Intent(MainActivity.this, MainActivity2.class));
                i.putExtra("key", (Serializable) gb.listaBrani);
                startActivity(i);
            }
        });

    }

}