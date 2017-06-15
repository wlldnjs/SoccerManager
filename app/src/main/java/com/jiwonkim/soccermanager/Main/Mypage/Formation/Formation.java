package com.jiwonkim.soccermanager.Main.Mypage.Formation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiwonkim.soccermanager.R;

import java.util.ArrayList;

public class Formation extends AppCompatActivity implements View.OnTouchListener{
    Button squad1,squad2,squad3;
    RecyclerView recyclerPlayer;
    LinearLayoutManager linearLayoutManager;
    ArrayList<PlayerListData> itemDatas;
    FormationAdapter formationAdapter;
    float oldXvalue, oldYvalue;
    boolean createPlayer = false;
    PlayerListData player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formation);

        recyclerPlayer = (RecyclerView)findViewById(R.id.recycler_player_list);
        recyclerPlayer.setHasFixedSize(true);
//        recyclerPlayer.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.HORIZONTAL));

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

    public View.OnTouchListener touchListener = new View.OnTouchListener(){
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            final int widthsize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics());
            final int heightsize = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, getResources().getDisplayMetrics());
//            final int textsize = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 13, getResources().getDisplayMetrics());

//            int width = ((ViewGroup)v.getParent()).getWidth() - v.getWidth();
//            int height = ((ViewGroup)v.getParent()).getHeight() - v.getHeight();
            final int position = recyclerPlayer.getChildPosition(v);

            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                Log.i("액션 이벤트 ", "클릭");
            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                if(event.getY()<0){
                    Log.i("액션 이벤트 ", "나가부렸어");
                    Log.i("아이디",""+itemDatas.get(position).name);
                    Log.i("createPlayer 상태 ", ""+createPlayer);
                    if(createPlayer == false){
                        Log.i("액션 이벤트 ", "진입");
                        player = itemDatas.get(position);
                        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
                        RelativeLayout rootView = (RelativeLayout)findViewById(R.id.ground);
                        LinearLayout targetView = new LinearLayout(Formation.this);
                        targetView.setLayoutParams(new LinearLayout.LayoutParams(widthsize,heightsize));
                        targetView.setOrientation(LinearLayout.VERTICAL);

                        ImageView imageView = new ImageView(Formation.this);
                        imageView.setImageResource(R.drawable.man);
                        imageView.setLayoutParams(new ViewGroup.LayoutParams(widthsize,widthsize));

                        TextView textView = new TextView(Formation.this);
                        textView.setText(player.name.toString());
                        textView.setTextSize(13);
                        textView.setTextColor(Color.WHITE);

                        targetView.addView(imageView);
                        targetView.addView(textView);
                        rootView.addView(targetView);
                        targetView.setOnTouchListener(Formation.this);
//                        LinearLayout targetView = (LinearLayout)inflater.inflate(R.layout.recycler_item_formation,rootView,false);
//                        inflater.inflate(R.layout.recycler_item_formation,rootView,true);
                        itemDatas.remove(position);
                        formationAdapter.notifyDataSetChanged();
                        Log.i("액션 이벤트 ", "이벤트 완료");
                        Log.i("createPlayer 상태 ", ""+createPlayer);
                    }
                }

            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                Log.i("액션 이벤트 ", "뗌");
                createPlayer =false;
            }
            return true;
        }
    };

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Log.i("바깥이벤트", "클릭");

        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            Log.i("바깥이벤트 ", "이동중");
            v.setX(event.getX());
            v.setY(event.getY());
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            Log.i("바깥이벤트 ", "뗌");

        }
        return true;
    }
}
