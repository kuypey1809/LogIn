package com.khoidut.login;

//import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//import android.widget.TextView;

public class SelfStudy extends AppCompatActivity {
    Button TTHL;
    Button KhuA;
    Button KhuC;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from new_activity.xml
        setContentView(R.layout.self_study);

        TTHL = (Button) findViewById(R.id.TTHL);
        KhuA = (Button) findViewById(R.id.KhuA);
        KhuC = (Button) findViewById(R.id.KhuC);

        TTHL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent myIntent = new Intent(SelfStudy.this,
                        TTHL.class);
                startActivity(myIntent);
            }
        });
    }
}