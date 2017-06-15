package com.jiwonkim.soccermanager.Main.Search;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jiwonkim.soccermanager.R;

import java.util.ArrayList;

/**
 * Created by user on 2017-06-08.
 */

public class SearchFragment extends Fragment{
    EditText editSearch;
    ImageView searchBtn;
    RecyclerView recyclerSearch1, recyclerSearch2;
    Context context;
    LinearLayoutManager linearLayoutManager;
    ArrayList<SearchListData> itemDatas;
    SearchAdapter searchAdapter;
    FrameLayout searchResult;

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

        searchResult = (FrameLayout)layout.findViewById(R.id.search_result);

        editSearch = (EditText)layout.findViewById(R.id.editSearch);
        searchBtn = (ImageView)layout.findViewById(R.id.searchBtn);
        recyclerSearch1 = (RecyclerView)layout.findViewById(R.id.recyclerSearch1);
        recyclerSearch2 = (RecyclerView)layout.findViewById(R.id.recyclerSearch2);
        recyclerSearch1.setHasFixedSize(true);
        recyclerSearch1.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));

        linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerSearch1.setLayoutManager(linearLayoutManager);

        itemDatas = new ArrayList<SearchListData>();
        itemDatas.add(new SearchListData(R.drawable.man,"hangyu","최한규","전곡조기축구회"));
        itemDatas.add(new SearchListData(R.drawable.man,"jiwon","김지원","동두천FC"));
        itemDatas.add(new SearchListData(R.drawable.man,"jinsung","윤진성","노원볼보이"));
        itemDatas.add(new SearchListData(R.drawable.man,"youngbum","김영범",""));
        itemDatas.add(new SearchListData(R.drawable.man,"2no","백인호","노원FC"));

        searchAdapter = new SearchAdapter(itemDatas,clickListener);
        recyclerSearch1.setAdapter(searchAdapter);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(searchResult.getVisibility() == View.INVISIBLE) {
                    searchResult.setVisibility(View.VISIBLE);
                }
                searchAdapter.notifyDataSetChanged();
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
