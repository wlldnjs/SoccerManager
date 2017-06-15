package com.jiwonkim.soccermanager.Main.Mypage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jiwonkim.soccermanager.Main.Mypage.Formation.Formation;
import com.jiwonkim.soccermanager.R;

/**
 * Created by user on 2017-06-08.
 */

public class MypageFragment extends Fragment implements View.OnClickListener{
    Button test, myInfo, teamInfo, setting;
    Context context;

    public MypageFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setContext(Context context){
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.fragment_mypage,container,false);
        test = (Button) layout.findViewById(R.id.test);
        myInfo = (Button) layout.findViewById(R.id.myInfo);
        teamInfo = (Button) layout.findViewById(R.id.teamInfo);
        setting = (Button) layout.findViewById(R.id.setting);

        test.setOnClickListener(this);
        myInfo.setOnClickListener(this);
        teamInfo.setOnClickListener(this);
        setting.setOnClickListener(this);
//        teamInfo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(context, Formation.class));
//            }
//        });
        return layout;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.test:
                Toast.makeText(context, "준비중입니다.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myInfo:
                Toast.makeText(context, "준비중입니다.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.teamInfo:
                startActivity(new Intent(context, Formation.class));
                break;
            case R.id.setting:
                Toast.makeText(context, "준비중입니다.", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
