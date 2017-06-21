package com.jiwonkim.soccermanager.Main.Search;

import android.content.Context;
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
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiwonkim.soccermanager.Application.ApplicationController;
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
//        itemDatas.add(new SearchListData(R.drawable.man,"hangyu","최한규","전곡조기축구회"));
//        itemDatas.add(new SearchListData(R.drawable.man,"jiwon","김지원","동두천FC"));
//        itemDatas.add(new SearchListData(R.drawable.man,"jinsung","윤진성","노원볼보이"));
//        itemDatas.add(new SearchListData(R.drawable.man,"youngbum","김영범",""));
//        itemDatas.add(new SearchListData(R.drawable.man,"2no","백인호","노원FC"));

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
        searchTeamAdapter = new SearchAdapter(itemTeamDatas,clickListener);
        searchUserAdapter = new SearchAdapter(itemUserDatas,clickListener);
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
                            if(response.body().status.equals("success")){
                                if(!editSearch.getText().toString().equals("")) {
                                    itemUserDatas.add(new SearchListData(R.drawable.man, response.body().resultData.id, response.body().resultData.name, response.body().resultData.myTeamName));
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

    public View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final int position = recyclerSearch1.getChildPosition(v);
            Toast.makeText(context, (position+1)+"번째 item", Toast.LENGTH_SHORT).show();
        }
    };
}
