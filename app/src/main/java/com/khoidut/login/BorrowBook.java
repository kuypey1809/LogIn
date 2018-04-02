package com.khoidut.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BorrowBook extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from new_activity.xml
        setContentView(R.layout.book_borrow);
    }
}
