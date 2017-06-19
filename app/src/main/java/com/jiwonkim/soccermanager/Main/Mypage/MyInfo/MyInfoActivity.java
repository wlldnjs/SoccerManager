package com.jiwonkim.soccermanager.Main.Mypage.MyInfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.jiwonkim.soccermanager.R;

public class MyInfoActivity extends AppCompatActivity {
    TextView id, name, birth, country, position, team, speed, acc, health, agil, aver;
    Button editBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);
        id = (TextView)findViewById(R.id.myInfo_id);
        name = (TextView)findViewById(R.id.myInfo_name);
        birth = (TextView)findViewById(R.id.myInfo_birth);
        country = (TextView)findViewById(R.id.myInfo_country);
        position = (TextView)findViewById(R.id.myInfo_position);
        team = (TextView)findViewById(R.id.myInfo_team);
        speed = (TextView)findViewById(R.id.myInfo_speed);
        acc = (TextView)findViewById(R.id.myInfo_acc);
        health = (TextView)findViewById(R.id.myInfo_health);
        agil = (TextView)findViewById(R.id.myInfo_agil);
        aver = (TextView)findViewById(R.id.myInfo_agil);
        editBtn = (Button)findViewById(R.id.myInfo_edit);


    }
}
