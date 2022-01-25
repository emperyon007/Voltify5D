package com.example.voltify5d;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity
{
    gestoreBrani gb;

    EditText txtTitolo;
    EditText txtAutore;
    EditText txtMinuti;
    EditText txtSecondi;

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
        this.txtMinuti = findViewById(R.id.edtMinuti);
        this.txtSecondi = findViewById(R.id.edtSecondi);

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

        //preset toast

        Context context = getApplicationContext();

        submit.setOnClickListener(new View.OnClickListener()
        {
            /**
             * Method: onClick
             * Handles the click of the "submit" button
             * If every field is populated, adds the track to the final list
             * @param view
             */
            @Override
            public void onClick(View view)
            {
                Log.d("Submit", "Clicked submit");

                if(txtTitolo.getText().toString().isEmpty() || txtAutore.getText().toString().isEmpty() || txtMinuti.getText().toString().isEmpty())
                {
                    String text = "Fill all fields";
                    Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                    toast.show();
                }
                else
                {
                    selectedGen = drpList.getSelectedItem().toString();

                    gb.addBrano
                    (
                        txtTitolo.getText().toString(),
                        txtAutore.getText().toString(),
                        selectedGen,
                        txtMinuti.getText().toString() + ":" +
                        txtSecondi.getText().toString()
                    );
                }
            }
        });


        view.setOnClickListener(new View.OnClickListener()
        {
            /**
             * Method: onClick
             * Handles the click of the "view" button
             * When clicked it displays the final list with all tracks
             * @param view
             */
            @Override
            public void onClick(View view)
            {
                Log.d("View", "Clicked view");

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

