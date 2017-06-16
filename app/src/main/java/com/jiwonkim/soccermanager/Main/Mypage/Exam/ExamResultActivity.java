package com.jiwonkim.soccermanager.Main.Mypage.Exam;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.jiwonkim.soccermanager.R;

public class ExamResultActivity extends AppCompatActivity implements Runnable {
    TextView resultText, textTotal;
    RatingBar lating_speed, lating_acc, lating_heal, lating_agil, lating_total;
    int speed, acc, heal, agil;
    LinearLayout linearLayout;
    float totalCount;
    ProgressBar progress;
    Handler process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_result);

        resultText = (TextView)findViewById(R.id.resultText1);
        textTotal = (TextView)findViewById(R.id.text_total);
        lating_speed = (RatingBar)findViewById(R.id.lating_speed);
        lating_acc = (RatingBar)findViewById(R.id.lating_acc);
        lating_heal = (RatingBar)findViewById(R.id.lating_heal);
        lating_agil = (RatingBar)findViewById(R.id.lating_agil);
        lating_total = (RatingBar)findViewById(R.id.lating_total);
        linearLayout = (LinearLayout)findViewById(R.id.result_layout);
        progress = (ProgressBar)findViewById(R.id.progress);

        speed = getIntent().getExtras().getInt("speed");
        acc = getIntent().getExtras().getInt("acceleration");
        heal = getIntent().getExtras().getInt("health");
        agil = getIntent().getExtras().getInt("agility");
        totalCount = (float)(speed+acc+heal+agil)/4;

        process = new Handler();
        new Thread(ExamResultActivity.this).start();

        lating_speed.setMax(5);
        lating_acc.setMax(5);
        lating_heal.setMax(5);
        lating_agil.setMax(5);
        lating_total.setMax(5);
        lating_total.setStepSize((float)0.5);

        lating_speed.setRating((float)speed);
        lating_acc.setRating((float)acc);
        lating_heal.setRating((float)heal);
        lating_agil.setRating((float)agil);
        lating_total.setRating(totalCount);
        textTotal.setText(""+totalCount);
        Log.d("총 점수", ""+totalCount);
    }

    @Override
    public void run() {
        try{
            Thread.sleep(3000);
            process.post(changeView);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private Runnable changeView = new Runnable() {
        @Override
        public void run() {
            try {
                progress.setVisibility(View.INVISIBLE);
                resultText.setText("사용자 님의 측정 결과 입니다.");
                linearLayout.setVisibility(View.VISIBLE);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    };
}
