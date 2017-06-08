package com.jiwonkim.soccermanager.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jiwonkim.soccermanager.R;

public class LoginActivity extends AppCompatActivity {
    TextView regist;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        regist = (TextView)findViewById(R.id.regist);
        loginBtn = (Button)findViewById(R.id.login);

        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registIntent = new Intent(LoginActivity.this, RegistActivity.class);
                startActivity(registIntent);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "로그인 버튼 클릭", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
