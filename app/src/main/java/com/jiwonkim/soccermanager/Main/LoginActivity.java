package com.jiwonkim.soccermanager.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jiwonkim.soccermanager.R;

public class LoginActivity extends AppCompatActivity {
    EditText userId, userPw;
    TextView regist;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        regist = (TextView)findViewById(R.id.regist);
        loginBtn = (Button)findViewById(R.id.login);
        userId = (EditText)findViewById(R.id.id);
        userPw = (EditText)findViewById(R.id.password);

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
                Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        });
    }
}
