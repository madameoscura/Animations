package com.example.animations.logic;

import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.animations.R;
import com.example.animations.gui.ThirdActivity;

public class ThirdActivityListener implements View.OnDragListener, View.OnTouchListener {

    private ThirdActivity thirdActivity;
    private Drawable enterShape;
    private Drawable normalShape;

    public ThirdActivityListener(ThirdActivity thirdActivity) {
        this.thirdActivity = thirdActivity;
        enterShape = thirdActivity.getResources().getDrawable(R.drawable.shape_droptarget, null);
        normalShape = thirdActivity.getResources().getDrawable(R.drawable.shape, null);
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        int action = event.getAction();
        switch (event.getAction()) {
            //element angefasst aber nicht bewegt
            case DragEvent.ACTION_DRAG_STARTED:
                break;
                //wenn element angefangen wird zu bewegen
            case DragEvent.ACTION_DRAG_ENTERED:
                v.setBackground(enterShape);
                break;
                //Geste stoppen
            case DragEvent.ACTION_DRAG_EXITED:
                v.setBackground(normalShape);
                break;
            case DragEvent.ACTION_DROP:
                View view = (View) event.getLocalState();
                //container in dem sich unsere View befindet
                ViewGroup owner = (ViewGroup) view.getParent();
                //wir lösen es aus View
                owner.removeView(view);
                //wir fügen es neuer View hinzu, wo wir es loslassen
                LinearLayout container = (LinearLayout) v;
                container.addView(view);
                view.setVisibility(View.VISIBLE);
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                v.setBackground(normalShape);
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, shadowBuilder, v, 0);
            v.setVisibility(View.INVISIBLE);
            return true;
        } else {
            return false;
        }

    }
}
