package com.khoidut.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String SHARED_PREF_NAME = "usersInfo";
    public static final String USER_TOKEN = "token";
    Button tu_hoc;
    Button relax;
    Button buttonLogOut;
    Button btnBorrowBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tu_hoc = (Button) findViewById(R.id.tu_hoc);
        relax = (Button) findViewById(R.id.relax);
        buttonLogOut = (Button) findViewById(R.id.buttonLogOut);
        btnBorrowBook = (Button) findViewById(R.id.book);

        tu_hoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent myIntent = new Intent(MainActivity.this,
                        SelfStudy.class);
                startActivity(myIntent);
            }
        });

        relax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this,
                        ServicesMap.class);
                startActivity(myIntent);
            }
        });

        buttonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this,
                        LoginActivity.class);
                startActivity(myIntent);


                final SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
                String token = sharedPreferences.getString(USER_TOKEN, null);
                if (token != null) {
//
//                    try {
//                        HttpClient client = new DefaultHttpClient();
//                        String getURL = "http://10.0.3.2:8000/api/logout";
//                        HttpGet httpGet = new HttpGet(getURL);
//                        httpGet .setHeader("Content-Type", "application/json");
//                        httpGet .setHeader("Authorization", token);
//                        HttpResponse response = client.execute(httpGet);
//                        HttpEntity resEntity = response.getEntity();
//                        System.out.println(resEntity);
//                        if (resEntity != null) {
//                            //parse response.
//                            Log.e("Response", EntityUtils.toString(resEntity));
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }


                    System.out.println("token here");
                    System.out.println(token);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(USER_TOKEN, null);
                    editor.commit();

                }
            }
        });

        btnBorrowBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this,
                        BorrowBook.class);
                startActivity(myIntent);
            }
        });
    }
}
    