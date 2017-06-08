package com.jiwonkim.soccermanager.Main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.jiwonkim.soccermanager.R;

public class RegistActivity extends AppCompatActivity {
    EditText editId, editPw, editName, editBirth;
    Spinner country;
    RadioGroup positions;
    CheckBox fw, mf, cf, gk;

    String[] country_list = {"서울","경기","강원","인천","대전","대구","부산"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        editId = (EditText)findViewById(R.id.id);
        editPw = (EditText)findViewById(R.id.password);
        editName = (EditText)findViewById(R.id.name);
        editBirth = (EditText)findViewById(R.id.birth);

        country = (Spinner)findViewById(R.id.country);
        positions = (RadioGroup)findViewById(R.id.position);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,country_list);
        country.setAdapter(adapter);
    }
}
