package com.jiwonkim.soccermanager.Main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.jiwonkim.soccermanager.R;

public class RegistActivity extends AppCompatActivity {
    EditText editId, editPw, editName, editBirth;
    Spinner country1, country2;
    RadioGroup positions;
    CheckBox fw, mf, cf, gk;
    Button signBtn;

    String[] country_list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        editId = (EditText)findViewById(R.id.id);
        editPw = (EditText)findViewById(R.id.password);
        editName = (EditText)findViewById(R.id.name);
        editBirth = (EditText)findViewById(R.id.birth);

        country1 = (Spinner)findViewById(R.id.country1);
        country2 = (Spinner)findViewById(R.id.country2);
        positions = (RadioGroup)findViewById(R.id.position);
        fw = (CheckBox)findViewById(R.id.fw);
        mf = (CheckBox)findViewById(R.id.mf);
        cf = (CheckBox)findViewById(R.id.cf);
        gk = (CheckBox)findViewById(R.id.gk);

        signBtn = (Button)findViewById(R.id.signBtn);

        country_list1 = getResources().getStringArray(R.array.country_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,country_list1);
        country1.setAdapter(adapter);
        country1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] country_list2;
                ArrayAdapter<String> adapter2;
                switch (position){
                    case 0:
                        String[] selectCon = {"지역을 선택해주세요"};
                        country2.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,selectCon));
                        break;
                    case 1:
                        country_list2 = getResources().getStringArray(R.array.seoul);
                        adapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,country_list2);
                        country2.setAdapter(adapter2);
//                        country2.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,country_list2));
                        break;
                    case 2:
                        country_list2 = getResources().getStringArray(R.array.busan);
                        adapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,country_list2);
                        country2.setAdapter(adapter2);
                        break;
                    case 3:
                        country_list2 = getResources().getStringArray(R.array.daegu);
                        adapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,country_list2);
                        country2.setAdapter(adapter2);
                        break;
                    case 4:
                        country_list2 = getResources().getStringArray(R.array.inchen);
                        adapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,country_list2);
                        country2.setAdapter(adapter2);
                        break;
                    case 5:
                        country_list2 = getResources().getStringArray(R.array.gwangju);
                        adapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,country_list2);
                        country2.setAdapter(adapter2);
                        break;
                    case 6:
                        country_list2 = getResources().getStringArray(R.array.daejeon);
                        adapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,country_list2);
                        country2.setAdapter(adapter2);
                        break;
                    case 7:
                        country_list2 = getResources().getStringArray(R.array.ulsan);
                        adapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,country_list2);
                        country2.setAdapter(adapter2);
                        break;
                    case 8:
                        country_list2 = getResources().getStringArray(R.array.gangwon);
                        adapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,country_list2);
                        country2.setAdapter(adapter2);
                        break;
                    case 9:
                        country_list2 = getResources().getStringArray(R.array.gyeonggi);
                        adapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,country_list2);
                        country2.setAdapter(adapter2);
                        break;
                    case 10:
                        country_list2 = getResources().getStringArray(R.array.gyeongnam);
                        adapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,country_list2);
                        country2.setAdapter(adapter2);
                        break;
                    case 11:
                        country_list2 = getResources().getStringArray(R.array.gyeongbuk);
                        adapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,country_list2);
                        country2.setAdapter(adapter2);
                        break;
                    case 12:
                        country_list2 = getResources().getStringArray(R.array.gyeongnam);
                        adapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,country_list2);
                        country2.setAdapter(adapter2);
                        break;
                    case 13:
                        country_list2 = getResources().getStringArray(R.array.gyeongbuk);
                        adapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,country_list2);
                        country2.setAdapter(adapter2);
                        break;
                    case 14:
                        country_list2 = getResources().getStringArray(R.array.jeju);
                        adapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,country_list2);
                        country2.setAdapter(adapter2);
                        break;
                    case 15:
                        country_list2 = getResources().getStringArray(R.array.chungnam);
                        adapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,country_list2);
                        country2.setAdapter(adapter2);
                        break;
                    case 16:
                        country_list2 = getResources().getStringArray(R.array.chungbuk);
                        adapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,country_list2);
                        country2.setAdapter(adapter2);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                String[] selectCon = {"지역을 선택해주세요"};
                country2.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,selectCon));
            }
        });

        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String id = editId.getText().toString();
                    String pw = editPw.getText().toString();
                    String name = editName.getText().toString();
                    int birth = Integer.parseInt(editBirth.getText().toString());
                    String country = country1.getSelectedItem().toString() +" " +country2.getSelectedItem().toString();
                    String position = "";
                    if(fw.isChecked()){
                        position += "f";
                    }
                    if(mf.isChecked()){
                        position += "m";
                    }
                    if(cf.isChecked()){
                        position += "c";
                    }
                    if(gk.isChecked()){
                        position += "g";
                    }

                    Toast.makeText(RegistActivity.this, "id : " +id +"\npw : " +pw +"\nname : " +name +"\nbirth : " +birth +"\ncountry : " +country +"\nposition : " +position, Toast.LENGTH_SHORT).show();
                    finish();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
