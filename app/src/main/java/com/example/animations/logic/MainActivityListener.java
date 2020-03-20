package com.example.animations.logic;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.example.animations.R;
import com.example.animations.gui.MainActivity;
import com.example.animations.gui.SecondActivity;
import com.example.animations.gui.ThirdActivity;

public class MainActivityListener implements View.OnClickListener {

    MainActivity mainActivity;
    Animation animation;


    public MainActivityListener(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBlink:
                animation = AnimationUtils.loadAnimation(mainActivity.getApplicationContext(), R.anim.blink);
                break;
            case R.id.btnClockwise:
                animation = AnimationUtils.loadAnimation(mainActivity.getApplicationContext(), R.anim.clockwise);
                break;
            case R.id.btnFade:
                animation = AnimationUtils.loadAnimation(mainActivity.getApplicationContext(), R.anim.fade);
                break;
            case R.id.btnMove:
                animation = AnimationUtils.loadAnimation(mainActivity.getApplicationContext(), R.anim.move);
                break;
            case R.id.btnSlide:
                animation = AnimationUtils.loadAnimation(mainActivity.getApplicationContext(), R.anim.slide);
                break;
            case R.id.btnZoom:
                animation = AnimationUtils.loadAnimation(mainActivity.getApplicationContext(), R.anim.zoom);
                break;
        }
        mainActivity.animImage.startAnimation(animation);
        //   mainActivity.btnClockwise.startAnimation(animation);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        mainActivity.getMenuInflater().inflate(R.menu.optionmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuSecond:
                Intent intent = new Intent(mainActivity, SecondActivity.class);
                mainActivity.startActivity(intent);
                break;
            case R.id.menuThird:
                Intent intentThree = new Intent(mainActivity, ThirdActivity.class);
                mainActivity.startActivity(intentThree);
        }
        return true;
    }
}
