package com.jiwonkim.soccermanager.Main.Mypage.Formation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.jiwonkim.soccermanager.R;

import java.util.ArrayList;

public class Formation extends AppCompatActivity {
    Button squad1,squad2,squad3;
    RecyclerView recyclerPlayer;
    LinearLayoutManager linearLayoutManager;
    ArrayList<PlayerListData> itemDatas;
    FormationAdapter formationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formation);

        recyclerPlayer = (RecyclerView)findViewById(R.id.recycler_player_list);
        recyclerPlayer.setHasFixedSize(true);
        recyclerPlayer.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.HORIZONTAL));

        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerPlayer.setLayoutManager(linearLayoutManager);

        itemDatas = new ArrayList<PlayerListData>();
        itemDatas.add(new PlayerListData(R.drawable.man,"김지원"));
        itemDatas.add(new PlayerListData(R.drawable.man,"최한규"));
        itemDatas.add(new PlayerListData(R.drawable.man,"김영범"));
        itemDatas.add(new PlayerListData(R.drawable.man,"박형준"));
        itemDatas.add(new PlayerListData(R.drawable.man,"장지원"));
        itemDatas.add(new PlayerListData(R.drawable.man,"백인호"));
        itemDatas.add(new PlayerListData(R.drawable.man,"윤진성"));

        formationAdapter = new FormationAdapter(itemDatas,touchListener);
        recyclerPlayer.setAdapter(formationAdapter);
    }

    public View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()){
                    case MotionEvent.ACTION_UP :
                        v.setX(event.getRawX()-120);
                        v.setY(event.getRawY()-220);
                    case MotionEvent.ACTION_DOWN :
                        v.setX(event.getRawX()-120);
                        v.setY(event.getRawY()-220);
                    case MotionEvent.ACTION_MOVE:
                        v.setX(event.getRawX()-120);
                        v.setY(event.getRawY()-220);
                }
                return true;
        }

    };
}
