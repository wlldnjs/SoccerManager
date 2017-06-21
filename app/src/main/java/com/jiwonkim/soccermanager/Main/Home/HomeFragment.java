package com.jiwonkim.soccermanager.Main.Home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiwonkim.soccermanager.R;

import static com.jiwonkim.soccermanager.Main.Login.LoginActivity.loginUserData;

/**
 * Created by user on 2017-06-08.
 */

public class HomeFragment extends Fragment{
    TextView teamName, count, captain, speed, acc, heal, agil, aver;

    public HomeFragment(){
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.fragment_home,container,false);
        teamName = (TextView)layout.findViewById(R.id.teamName);
        count = (TextView)layout.findViewById(R.id.count);
        captain = (TextView)layout.findViewById(R.id.captain);
        speed = (TextView)layout.findViewById(R.id.home_speed);
        acc = (TextView)layout.findViewById(R.id.home_acc);
        heal = (TextView)layout.findViewById(R.id.home_health);
        agil = (TextView)layout.findViewById(R.id.home_agil);
        aver = (TextView)layout.findViewById(R.id.home_aver);

        if(loginUserData.myTeamName == null){
            teamName.setText("(소속 팀이 없습니다.)");
        }else {
            teamName.setText(loginUserData.myTeamName);
        }
        speed.setText(loginUserData.mySpeed);
        acc.setText(loginUserData.acceleration);
        heal.setText(loginUserData.health);
        agil.setText(loginUserData.agility);

        float total =(float)(Integer.parseInt(loginUserData.mySpeed) +Integer.parseInt(loginUserData.acceleration) +Integer.parseInt(loginUserData.health) +Integer.parseInt(loginUserData.agility))/4;
        aver.setText(String.valueOf(total));

        return layout;
    }


}
