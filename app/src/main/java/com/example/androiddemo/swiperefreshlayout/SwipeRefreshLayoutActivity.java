package com.example.androiddemo.swiperefreshlayout;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.androiddemo.R;

import java.util.ArrayList;
import java.util.List;

public class SwipeRefreshLayoutActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private int lastVisibleItem;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh_layout);

        initView();
    }

    private void initView() {
        swipeRefreshLayout = findViewById(R.id.swiprefresh_container);
        recyclerView = findViewById(R.id.swiperefresh_rv);

        // 设置布局管理器
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager.setReverseLayout(false);
        recyclerView.setLayoutManager(linearLayoutManager);
        // 设置adapter
        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.IOnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(SwipeRefreshLayoutActivity.this, "click:" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(SwipeRefreshLayoutActivity.this, "long click:" + position, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(recyclerViewAdapter);

        // 设置刷新圆圈背景
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.white);
        swipeRefreshLayout.setColorSchemeResources(R.color.blue,
                R.color.orange,
                R.color.green,
                R.color.red);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<String> newDatas = new ArrayList<String>();
                        for (int i = 0; i < 5; i++) {
                            newDatas.add("new item" + i);
                        }
                        recyclerViewAdapter.addItem(newDatas);
                        /// 刷新完成后标志
                        swipeRefreshLayout.setRefreshing(false);
                        Toast.makeText(SwipeRefreshLayoutActivity.this, "数据刷新", Toast.LENGTH_SHORT).show();
                    }
                }, 1500);
            }
        });

        // 监听滚动事件，完成上拉加载功能
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                //滚动状态变化时回调
                super.onScrollStateChanged(recyclerView, newState);
//                Log.d("111111", "lastVisibleItem:"+lastVisibleItem+"getItemCount:"+recyclerViewAdapter.getItemCount());

                if (newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastVisibleItem + 1 == recyclerViewAdapter.getItemCount()) {
                    recyclerViewAdapter.changeMoreStatus(RecyclerViewAdapter.LOADING_MORE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            List<String> data = new ArrayList<>();
                            for (int i = 0; i < 5; i++) {
                                data.add("more item:" + i);
                            }
                            recyclerViewAdapter.addMoreItem(data);

                            recyclerViewAdapter.changeMoreStatus(RecyclerViewAdapter.PULLUP_LOAD_MORE);
                            //Toast.makeText(SwipeRefreshLayoutActivity.this, "加载数据", Toast.LENGTH_SHORT).show();
                            swipeRefreshLayout.setRefreshing(false);
                        }
                    }, 1000);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                //滚动时回调
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            }
        });
    }

}
