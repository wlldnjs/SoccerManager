package com.jiwonkim.soccermanager.Main.Search;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiwonkim.soccermanager.Application.ApplicationController;
import com.jiwonkim.soccermanager.Main.Login.UserData;
import com.jiwonkim.soccermanager.Network.NetworkService;
import com.jiwonkim.soccermanager.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by user on 2017-06-08.
 */

public class SearchFragment extends Fragment{
    EditText editSearch;
    ImageView searchBtn;
    RecyclerView recyclerSearch1, recyclerSearch2;
    Context context;
    LinearLayoutManager linearLayoutManager1, linearLayoutManager2;
    ArrayList<SearchListData> itemUserDatas, itemTeamDatas;
    SearchAdapter searchUserAdapter, searchTeamAdapter;
    FrameLayout searchResult;
    NetworkService service;
    ArrayList<UserData> searchUserDatas;

    public SearchFragment() {
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
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.fragment_search,container,false);
        service = ApplicationController.getInstance().getNetworkService();

        searchResult = (FrameLayout)layout.findViewById(R.id.search_result);

        editSearch = (EditText)layout.findViewById(R.id.editSearch);
        searchBtn = (ImageView)layout.findViewById(R.id.searchBtn);
        recyclerSearch1 = (RecyclerView)layout.findViewById(R.id.recyclerSearch1);
        recyclerSearch1.setHasFixedSize(true);
        recyclerSearch1.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        recyclerSearch2 = (RecyclerView)layout.findViewById(R.id.recyclerSearch2);
        recyclerSearch2.setHasFixedSize(true);
        recyclerSearch2.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));

        linearLayoutManager1 = new LinearLayoutManager(context);
        linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerSearch1.setLayoutManager(linearLayoutManager1);
        linearLayoutManager2 = new LinearLayoutManager(context);
        linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerSearch1.setLayoutManager(linearLayoutManager1);
        recyclerSearch2.setLayoutManager(linearLayoutManager2);

        itemTeamDatas = new ArrayList<SearchListData>();
        itemUserDatas = new ArrayList<SearchListData>();

        searchUserDatas = new ArrayList<UserData>();

        editSearch.setImeOptions(EditorInfo.IME_ACTION_DONE);       // 키보드 확인버튼 누를 시 동작 이벤트
        editSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    searchBtn.performClick();
                }
                return false;
            }
        });
        searchTeamAdapter = new SearchAdapter(itemTeamDatas,teamClickListener);
        searchUserAdapter = new SearchAdapter(itemUserDatas,userClickListener);
        recyclerSearch1.setAdapter(searchTeamAdapter);
        recyclerSearch2.setAdapter(searchUserAdapter);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(searchResult.getVisibility() == View.INVISIBLE) {
                    searchResult.setVisibility(View.VISIBLE);
                }
                itemUserDatas.removeAll(itemUserDatas);
                Call<SearchUserResult> requestSearchUser = service.getSearchUserResult(editSearch.getText().toString().trim());
                requestSearchUser.enqueue(new Callback<SearchUserResult>() {
                    @Override
                    public void onResponse(Call<SearchUserResult> call, Response<SearchUserResult> response) {
                        if(response.isSuccessful()){
                            searchUserDatas.removeAll(searchUserDatas);
                            if(response.body().status.equals("success")){
                                if(!editSearch.getText().toString().equals("")) {
                                    for(int i=0; i<response.body().resultData.size(); i++){
                                        searchUserDatas.add(response.body().resultData.get(i));
                                        itemUserDatas.add(new SearchListData(R.drawable.man, response.body().resultData.get(i).id, response.body().resultData.get(i).name, response.body().resultData.get(i).myTeamName));
                                    }
                                }

                                searchTeamAdapter.notifyDataSetChanged();
                                searchUserAdapter.notifyDataSetChanged();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<SearchUserResult> call, Throwable t) {
                        Toast.makeText(context, "서버와 통신상태를 확인해 주세요.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        return layout;
    }

    public View.OnClickListener userClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final int position = recyclerSearch2.getChildPosition(v);
//            Toast.makeText(context, (position+1)+"번째 유저 item", Toast.LENGTH_SHORT).show();

            // 다이얼로그 생성
            LayoutInflater dialog = LayoutInflater.from(context);
            final View dialogLayout = dialog.inflate(R.layout.custom_dialog, null);
            final Dialog myDialog = new Dialog(getActivity());

            // 다이얼로그 타이틀제거, 투명
            myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            myDialog.setContentView(dialogLayout);

            final TextView dialogId = (TextView)dialogLayout.findViewById(R.id.dialog_id);
            final TextView dialogName = (TextView)dialogLayout.findViewById(R.id.dialog_name);
            final TextView dialogBirth = (TextView)dialogLayout.findViewById(R.id.dialog_birth);
            final TextView dialogCountry = (TextView)dialogLayout.findViewById(R.id.dialog_country);
            final TextView dialogPosition = (TextView)dialogLayout.findViewById(R.id.dialog_position);
            final TextView dialogTeam = (TextView)dialogLayout.findViewById(R.id.dialog_team);
            final TextView dialogSpeed = (TextView)dialogLayout.findViewById(R.id.dialog_speed);
            final TextView dialogAcc = (TextView)dialogLayout.findViewById(R.id.dialog_acc);
            final TextView dialogHealth = (TextView)dialogLayout.findViewById(R.id.dialog_health);
            final TextView dialogAgil = (TextView)dialogLayout.findViewById(R.id.dialog_agil);
            final TextView dialogAver = (TextView)dialogLayout.findViewById(R.id.dialog_aver);

            dialogId.setText(searchUserDatas.get(position).id);
            dialogName.setText(searchUserDatas.get(position).name);
            dialogBirth.setText(searchUserDatas.get(position).birth);
            dialogCountry.setText(searchUserDatas.get(position).location);
            dialogPosition.setText(searchUserDatas.get(position).preferredPosition);
            dialogTeam.setText(searchUserDatas.get(position).myTeamName);
            dialogSpeed.setText(searchUserDatas.get(position).mySpeed);
            dialogAcc.setText(searchUserDatas.get(position).acceleration);
            dialogHealth.setText(searchUserDatas.get(position).health);
            dialogAgil.setText(searchUserDatas.get(position).agility);
            float total =(float)(Integer.parseInt(dialogSpeed.getText().toString()) +Integer.parseInt(dialogAcc.getText().toString()) +Integer.parseInt(dialogHealth.getText().toString()) +Integer.parseInt(dialogAgil.getText().toString()))/4;
            dialogAver.setText(String.valueOf(total));

            // 다이얼로그 크기 조정
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            Window window = myDialog.getWindow();
            layoutParams.copyFrom(window.getAttributes());
            layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
            layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
            window.setAttributes(layoutParams);

            myDialog.show();
        }
    };

    public View.OnClickListener teamClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final int position = recyclerSearch1.getChildPosition(v);

            Toast.makeText(context, (position+1)+"번째 팀 item", Toast.LENGTH_SHORT).show();
        }
    };
}
