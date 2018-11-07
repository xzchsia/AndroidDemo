package com.example.androiddemo.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.androiddemo.R;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        initView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerview_container);
        // 设置布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this, LinearLayoutManager.VERTICAL, false));
        // 设置adapter
        mAdapter = new RecyclerViewAdapter(getData());
        // 设置点击事件
        mAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecyclerViewActivity.this, "click:" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(RecyclerViewActivity.this, "Long click:" + position, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(mAdapter);
        // 设置RecyclerView的间隔样式
        recyclerView.addItemDecoration(new MyDividerItemDecoration(RecyclerViewActivity.this, LinearLayoutManager.VERTICAL));
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        String temp = "item:";
        for (int i = 0; i < 20; i++) {
            data.add(temp + i);
        }
        return data;
    }
}
