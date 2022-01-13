package com.example.voltify5d;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    gestoreBrani gb;

    EditText txtTitolo = findViewById(R.id.edtTitolo);
    EditText txtAutore = findViewById(R.id.edtAutore);
    EditText txtDurata = findViewById(R.id.edtDurata);

    Button submit = findViewById(R.id.btnSubmit);
    Button view = findViewById(R.id.btnView);

    Spinner drpList = findViewById(R.id.selectList);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                    Integer.getInteger(txtDurata.toString())
                );
            }
        });

        view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

            }
        });
    }
}