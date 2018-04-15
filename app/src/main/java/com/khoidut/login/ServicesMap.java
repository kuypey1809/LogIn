package com.khoidut.login;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
/**
 * Created by Khoi on 3/23/2018.
 */

public class ServicesMap extends AppCompatActivity{

    ImageView imgcanteen1, imgcanteen2, imgfoodstore1, imgfoodstore2, imgvendingmachine1, imgvendingmachine2;

    @SuppressLint("WrongConstant")
    private void manageBlinkEffect(ImageView viewer) {
        ObjectAnimator anim = ObjectAnimator.ofInt(viewer, "backgroundColor", Color.WHITE, Color.RED,
                Color.WHITE);
        anim.setDuration(1500);
        anim.setEvaluator(new ArgbEvaluator());
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        anim.start();
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.services_map);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Material Search");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        imgcanteen1 = (ImageView) findViewById(R.id.imageCanteen1);
        imgcanteen2 = (ImageView) findViewById(R.id.imageCanteen2);
        imgfoodstore1= (ImageView) findViewById(R.id.imageFoodStore1);
        imgfoodstore2= (ImageView) findViewById(R.id.imageFoodStore2);
        imgvendingmachine1= (ImageView) findViewById(R.id.imageVendingMachine1);
        imgvendingmachine2= (ImageView) findViewById(R.id.imageVendingMachine2);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_servicesmap, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuCanteen:
                imgcanteen1.setVisibility(View.VISIBLE);
                imgcanteen2.setVisibility(View.VISIBLE);
                manageBlinkEffect(imgcanteen1);
                manageBlinkEffect(imgcanteen2);
                break;
            case R.id.menuFoodStore:
                imgfoodstore1.setVisibility(View.VISIBLE);
                imgfoodstore2.setVisibility(View.VISIBLE);
                manageBlinkEffect(imgfoodstore1);
                manageBlinkEffect(imgfoodstore2);
                break;
            case R.id.menuVendingMachine:
                imgvendingmachine1.setVisibility(View.VISIBLE);
                imgvendingmachine2.setVisibility(View.VISIBLE);
                manageBlinkEffect(imgvendingmachine1);
                manageBlinkEffect(imgvendingmachine2);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
