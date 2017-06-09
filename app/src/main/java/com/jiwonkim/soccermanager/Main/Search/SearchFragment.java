package com.jiwonkim.soccermanager.Main.Search;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jiwonkim.soccermanager.R;

/**
 * Created by user on 2017-06-08.
 */

public class SearchFragment extends Fragment{
    EditText editSearch;
    ImageView searchBtn;
    RecyclerView recyclerSearch1, recyclerSearch2;
    Context context;

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

        editSearch = (EditText)layout.findViewById(R.id.editSearch);
        searchBtn = (ImageView)layout.findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
            }
        });

        return layout;
    }
}
