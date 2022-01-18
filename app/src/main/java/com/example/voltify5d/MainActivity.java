package com.example.voltify5d;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

    public String selectedGen;

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

        /*
        elencoGeneri[] = {"Rock", "Pop", "Punk"};

        ArrayAdapter<String> spGen = new ArrayAdapter<String>(this, R.layout.simple_spinner_item, eleconGeneri);

        drpList.setAdapter(spGen);
         */

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genre_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        drpList.setAdapter(adapter);


        //MainActivity.context = getApplicationContext();

        gb = new gestoreBrani();

        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                selectedGen = drpList.getSelectedItem().toString();

                gb.addBrano
                (
                    txtTitolo.getText().toString(),
                    txtAutore.getText().toString(),
                    selectedGen,
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

        drpList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

}