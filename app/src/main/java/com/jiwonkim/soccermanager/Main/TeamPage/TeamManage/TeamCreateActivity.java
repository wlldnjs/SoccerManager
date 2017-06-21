package com.jiwonkim.soccermanager.Main.TeamPage.TeamManage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jiwonkim.soccermanager.Application.ApplicationController;
import com.jiwonkim.soccermanager.Network.NetworkService;
import com.jiwonkim.soccermanager.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.jiwonkim.soccermanager.Main.Login.LoginActivity.loginUserData;

public class TeamCreateActivity extends AppCompatActivity {
    EditText createTeamName, createTeamLocation;
    Button createBtn;
    NetworkService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_create);
        service = ApplicationController.getInstance().getNetworkService();

        createTeamName = (EditText)findViewById(R.id.createTeamName);
        createTeamLocation = (EditText)findViewById(R.id.teamLocation);
        createBtn = (Button)findViewById(R.id.createBtn);

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    final TeamInfo teamInfo = new TeamInfo();
                    teamInfo.name = createTeamName.getText().toString();
                    teamInfo.captain = loginUserData.name;
                    teamInfo.location = createTeamLocation.getText().toString();
                    teamInfo.id = loginUserData.id;
                    Call<TeamCreateResult> requsetCreateTeam = service.getTeamCreateResult(teamInfo);
                    requsetCreateTeam.enqueue(new Callback<TeamCreateResult>() {
                        @Override
                        public void onResponse(Call<TeamCreateResult> call, Response<TeamCreateResult> response) {
                            if (response.isSuccessful()){
                                if(response.body().status.equals("success")) {
                                    loginUserData.myTeamName = teamInfo.name;
                                    loginUserData.captain = loginUserData.name;
                                    Toast.makeText(TeamCreateActivity.this, "구단 생성 완료.", Toast.LENGTH_SHORT).show();
                                    finish();
                                } else {
                                    Toast.makeText(TeamCreateActivity.this, response.body().reason, Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<TeamCreateResult> call, Throwable t) {
                            Toast.makeText(TeamCreateActivity.this, "서버 상태를 확인해주세요.", Toast.LENGTH_SHORT).show();
                        }
                    });

                }catch (Exception e){
                    Toast.makeText(TeamCreateActivity.this, "값을 확인해 주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
