package com.khoidut.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;


import java.util.BitSet;

public class MainActivity extends AppCompatActivity {
    Button tu_hoc;
    Button relax;
    Button book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tu_hoc = (Button) findViewById(R.id.tu_hoc);
        relax = (Button) findViewById(R.id.relax);
        book = (Button) findViewById(R.id.book);

        tu_hoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent myIntent = new Intent(MainActivity.this,
                        SelfStudy.class);
                startActivity(myIntent);
            }
        });
    }
    }

