package com.example.animations.gui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.animations.R;
import com.example.animations.logic.ThirdActivityListener;

public class ThirdActivity extends AppCompatActivity {

    ThirdActivityListener thirdActivityListener;
    public LinearLayout topLeft, topRight, bottomLeft, bottomRight;
    public ImageView myimage1, myimage2, myimage3, myimage4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_third);

        topLeft = findViewById(R.id.topLeft);
        topRight = findViewById(R.id.topRight);
        bottomLeft = findViewById(R.id.bottomLeft);
        bottomRight = findViewById(R.id.bottomRight);

        myimage1 = findViewById(R.id.myimage1);
        myimage2 = findViewById(R.id.myimage2);
        myimage3 = findViewById(R.id.myimage3);
        myimage4 = findViewById(R.id.myimage4);

        thirdActivityListener = new ThirdActivityListener(this);

        topLeft.setOnDragListener(thirdActivityListener);
        topRight.setOnDragListener(thirdActivityListener);
        bottomLeft.setOnDragListener(thirdActivityListener);
        bottomRight.setOnDragListener(thirdActivityListener);


        myimage1.setOnTouchListener(thirdActivityListener);
        myimage2.setOnTouchListener(thirdActivityListener);
        myimage3.setOnTouchListener(thirdActivityListener);
        myimage4.setOnTouchListener(thirdActivityListener);

    }
}
