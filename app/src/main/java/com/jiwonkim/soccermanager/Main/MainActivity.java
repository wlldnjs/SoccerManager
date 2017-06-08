package com.jiwonkim.soccermanager.Main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.jiwonkim.soccermanager.Main.Home.HomeFragment;
import com.jiwonkim.soccermanager.Main.Mypage.MypageFragment;
import com.jiwonkim.soccermanager.Main.Schedule.ScheduleFragment;
import com.jiwonkim.soccermanager.Main.Search.SearchFragment;
import com.jiwonkim.soccermanager.Main.Talk.TalkFragment;
import com.jiwonkim.soccermanager.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView homeBtn, searchBtn, mypageBtn, scheduleBtn, talkBtn;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeBtn = (ImageView) findViewById(R.id.home);
        searchBtn = (ImageView) findViewById(R.id.search);
        mypageBtn = (ImageView) findViewById(R.id.mypage);
        scheduleBtn = (ImageView) findViewById(R.id.schedule);
        talkBtn = (ImageView) findViewById(R.id.talk);

        homeBtn.setOnClickListener(this);
        homeBtn.setTag(0);
        searchBtn.setOnClickListener(this);
        searchBtn.setTag(1);
        mypageBtn.setOnClickListener(this);
        mypageBtn.setTag(2);
        scheduleBtn.setOnClickListener(this);
        scheduleBtn.setTag(3);
        talkBtn.setOnClickListener(this);
        talkBtn.setTag(4);

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(0);


    }

    @Override
    public void onClick(View v) {
        int tag = (int)v.getTag();
        viewPager.setCurrentItem(tag);
    }

    private class pagerAdapter extends FragmentStatePagerAdapter{
        public pagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new HomeFragment();
                case 1:
                    return new SearchFragment();
                case 2:
                    return new MypageFragment();
                case 3:
                    return new ScheduleFragment();
                case 4:
                    return new TalkFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
