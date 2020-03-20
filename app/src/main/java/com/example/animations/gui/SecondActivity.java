package com.example.animations.gui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.animations.R;
import com.example.animations.logic.SecondActivityListener;

public class SecondActivity extends AppCompatActivity {

    SecondActivityListener secondActivityListener;
   public Button btnPlay;
   public ImageView imageBounceBall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        btnPlay = findViewById(R.id.btnBounceBall);

        imageBounceBall = findViewById(R.id.imageBounceBall);

        secondActivityListener = new SecondActivityListener(this);

        btnPlay.setOnClickListener(secondActivityListener);
    }
}
