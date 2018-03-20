package com.khoidut.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import cz.msebera.android.httpclient.Header;

import com.google.*;
import java.util.Collection;

public class LoginActivity extends AppCompatActivity {

    public static final String SHARED_PREF_NAME = "usersInfo";
    public static final String USER_NAME = "name";
    public static final String USER_EMAIL = "email";
    public static final String USER_TOKEN = "token";
    //Declaration EditTexts
    EditText editTextEmail;
    EditText editTextPassword;
    //Declaration TextInputLayout
    TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutPassword;
    //Declaration Button
    Button buttonLogin;
    //Declaration SqliteHelper
    SqliteHelper sqliteHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initCreateAccountTextView();
        initViews();

        sqliteHelper = new SqliteHelper(this);
        sqliteHelper.query(sqliteHelper.SQL_TABLE_USERS);
        //set click event of login button
        checkIsLogin();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Check user input is correct or not
                if (validate()) {
                    //Get values from EditText fields
                    final String Email = editTextEmail.getText().toString();
                    final String Password = editTextPassword.getText().toString();
                    RequestParams req = new RequestParams();
                    req.put("email", Email);
                    req.put("password", Password);

                    HttpUtils.post("api/login", req, new JsonHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            // called when response HTTP status is "200 OK
                            User data = new Gson().fromJson(response.toString(), User.class);
                            String token = null;
                            for (int i=0; i < data.getToken().size(); i++)
                            {
                                System.out.println(data.getToken().get(i).getAccess_token());
                                token = data.getToken().get(i).getAccess_token();
                            }

                            //Authenticate user
                            final SharedPreferences sharedPreferences = LoginActivity.this.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
//                            if(sharedPreferences.getBoolean("logged",false)){
//                                goToMainActivity();
//                            }
//                            buttonLogin.setOnClickListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                                    goToMainActivity();
//                                    sharedPreferences.edit().putBoolean("logged",true).apply();
//                                }
//                            });

                            editor.putString(USER_EMAIL, data.email);
                            editor.putString(USER_NAME, data.userName);
                            editor.putString(USER_TOKEN, token);
                            editor.commit();

                            String getEmail = sharedPreferences.getString(USER_EMAIL, data.email);
                            System.out.println(getEmail);
                            String getToken = sharedPreferences.getString(USER_TOKEN, token);
                            System.out.println(getToken);
                            System.out.println("run here");
                            Snackbar.make(buttonLogin, "Successfully Logged in!", Snackbar.LENGTH_LONG).show();
                            //User Logged in Successfully Launch You home screen activity
                            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                            Snackbar.make(buttonLogin, "Failed to log in , please try again", Snackbar.LENGTH_LONG).show();
                            super.onFailure(statusCode, headers, throwable, errorResponse);
                        }
                    });
                }
            }
        });
    }

    private void goToMainActivity() {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    private void checkIsLogin() {
        final SharedPreferences sharedPreferences = LoginActivity.this.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String token = sharedPreferences.getString(USER_TOKEN, null);
        if(token != null){
            System.out.println("token here");
            System.out.println(token);
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putString(USER_TOKEN, null);
//            editor.commit();


            System.out.println(sharedPreferences.getString(USER_TOKEN, null));
            goToMainActivity();
        }
    }

    //this method used to set Create account TextView text and click event( maltipal colors
    // for TextView yet not supported in Xml so i have done it programmatically)
    private void initCreateAccountTextView() {
        TextView textViewCreateAccount = (TextView) findViewById(R.id.textViewCreateAccount);
        textViewCreateAccount.setText(fromHtml());
        textViewCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    //this method is used to connect XML views to its Objects
    private void initViews() {
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

    }

    //This method is for handling fromHtml method deprecation
    @SuppressWarnings("deprecation")
    public static Spanned fromHtml() {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml("<font color='#0c0099'>I don't have account yet. </font><font color='#0c0099'>Create one</font>", Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml("<font color='#0c0099'>I don't have account yet. </font><font color='#0c0099'>Create one</font>");
        }
        return result;
    }

    //This method is used to validate input given by user
    public boolean validate() {
        boolean valid;

        //Get values from EditText fields
        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();

        //Handling validation for Email field
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            textInputLayoutEmail.setError("Please enter valid email!");
        } else {
            textInputLayoutEmail.setError(null);
        }

        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false;
            textInputLayoutPassword.setError("Please enter valid password!");
        } else {
            if (Password.length() > 5) {
                valid = true;
                textInputLayoutPassword.setError(null);
            } else {
                valid = false;
                textInputLayoutPassword.setError("Password is to short!");
            }
        }

        return valid;
    }
}