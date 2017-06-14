package com.jiwonkim.soccermanager.Main.Mypage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.jiwonkim.soccermanager.R;

public class Formation extends AppCompatActivity {

    ImageView sample1, sample2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formation);

        sample1 = (ImageView)findViewById(R.id.image1);
        sample2 = (ImageView)findViewById(R.id.image2);

        sample1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_UP :
                        sample1.setX(event.getRawX()-120);
                        sample1.setY(event.getRawY()-220);
                    case MotionEvent.ACTION_DOWN :
                        sample1.setX(event.getRawX()-120);
                        sample1.setY(event.getRawY()-220);
                    case MotionEvent.ACTION_MOVE:
                        sample1.setX(event.getRawX()-120);
                        sample1.setY(event.getRawY()-220);
                }
                return true;
            }
        });

        sample2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_UP :
                        sample2.setX(event.getRawX()-120);
                        sample2.setY(event.getRawY()-220);
                    case MotionEvent.ACTION_DOWN :
                        sample2.setX(event.getRawX()-120);
                        sample2.setY(event.getRawY()-220);
                    case MotionEvent.ACTION_MOVE:
                        sample2.setX(event.getRawX()-120);
                        sample2.setY(event.getRawY()-220);
                }
                return true;
            }
        });
    }
}
