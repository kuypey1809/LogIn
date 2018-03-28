package com.khoidut.login;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by Khoi on 3/23/2018.
 */

public class ServicesMap extends AppCompatActivity{
    Animation animation_blink;
    ImageView imgcanteen1;
    ImageView imgcanteen2;
    @SuppressLint("WrongConstant")
    private void manageBlinkEffect() {
        ObjectAnimator anim = ObjectAnimator.ofInt(imgcanteen1, "backgroundColor", Color.WHITE, Color.RED,
                Color.WHITE);
        anim.setDuration(1500);
        anim.setEvaluator(new ArgbEvaluator());
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        anim.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.services_map);

        animation_blink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink_animation);
        imgcanteen1 = (ImageView) findViewById(R.id.imageCanteen1);
        imgcanteen2 = (ImageView) findViewById(R.id.imageCanteen2);
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
                manageBlinkEffect();

                break;
            case R.id.menuFoodStore:
                break;
            case R.id.menuVendingMachine:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
