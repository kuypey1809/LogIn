package com.khoidut.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GetBook extends AppCompatActivity {

    String urlGetData = "http://khoi-smart-library.herokuapp.com/api/book";
    ListView listviewBook;
    ArrayList<InfoBook> arrayBook;
    ListBookAdapter adapter;
    public static final String SHARED_PREF_NAME = "usersInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_book);

        listviewBook = (ListView) findViewById(R.id.listviewBook);
        arrayBook = new ArrayList<>();
        adapter = new ListBookAdapter(this, R.layout.flow_list_book, arrayBook);
        listviewBook.setAdapter(adapter);
        GetData(urlGetData);
    }

    private void GetData(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
            JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        ListBookDataJson demo = new Gson().fromJson(response.toString(), ListBookDataJson.class);
                        System.out.println(demo.getCurrent_page());

                        System.out.println(demo.getData().size());
                        for (int i =0; i< demo.getData().size(); i++) {
                            System.out.println("data " + i + " :" + demo.getData().get(i).getId());
                            System.out.println("data " + i + " :" + demo.getData().get(i).getName());
                            System.out.println("data " + i + " :" + demo.getData().get(i).getImage_url());
                            arrayBook.add(new InfoBook(
                                    demo.getData().get(i).getName(),
                                    demo.getData().get(i).getDescription()
                            ));
                        }

                        adapter.notifyDataSetChanged();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error);
                        Toast.makeText(GetBook.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {    //this is the part, that adds the header to the request
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "Bearer " + getTokenViaSharePreferences());
                params.put("Accept", "application/json");

                return params;
            }};

        requestQueue.add(jsonArrayRequest);
    }

    private String getTokenViaSharePreferences()
    {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getString("token", null);
    }
}
