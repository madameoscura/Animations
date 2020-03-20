package com.example.animations.gui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import com.example.animations.R;
import com.example.animations.logic.MainActivityListener;

public class MainActivity extends AppCompatActivity {

    MainActivityListener mainActivityListener;
    public Button btnZoom, btnFade, btnMove, btnClockwise, btnSlide, btnBlink;
    public ImageView animImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnZoom = findViewById(R.id.btnZoom);
        btnFade = findViewById(R.id.btnFade);
        btnMove = findViewById(R.id.btnMove);
        btnClockwise = findViewById(R.id.btnClockwise);
        btnSlide = findViewById(R.id.btnSlide);
        btnBlink = findViewById(R.id.btnBlink);

        animImage = findViewById(R.id.animImage);

        mainActivityListener = new MainActivityListener(this);

        btnZoom.setOnClickListener(mainActivityListener);
        btnFade.setOnClickListener(mainActivityListener);
        btnMove.setOnClickListener(mainActivityListener);
        btnClockwise.setOnClickListener(mainActivityListener);
        btnSlide.setOnClickListener(mainActivityListener);
        btnBlink.setOnClickListener(mainActivityListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return mainActivityListener.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return mainActivityListener.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
