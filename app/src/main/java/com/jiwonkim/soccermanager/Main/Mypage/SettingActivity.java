package com.jiwonkim.soccermanager.Main.Mypage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jiwonkim.soccermanager.R;

import static com.jiwonkim.soccermanager.Main.MainActivity.mp;

public class SettingActivity extends AppCompatActivity{

    Button soundOnOff, withdrawal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        soundOnOff = (Button)findViewById(R.id.musicOnOff);
        withdrawal = (Button)findViewById(R.id.withDrawal);

        soundOnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp.isPlaying()){
                    Toast.makeText(SettingActivity.this, "음악 off.", Toast.LENGTH_SHORT).show();
                    mp.pause();
                } else {
                    Toast.makeText(SettingActivity.this, "음악 on.", Toast.LENGTH_SHORT).show();
                    mp.start();
                }
            }
        });

        withdrawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SettingActivity.this, "탈퇴했다 치자.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
