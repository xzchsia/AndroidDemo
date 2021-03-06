package com.example.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androiddemo.BottomNavigation.BottomNavigationActivity;
import com.example.androiddemo.banner.BannerActivity;
import com.example.androiddemo.pagerslidingtab.PagerSlidingTabActivity;
import com.example.androiddemo.recyclerview.RecyclerViewActivity;
import com.example.androiddemo.startActivityForResult.StartForResultActivity;
import com.example.androiddemo.swiperefreshlayout.SwipeRefreshLayoutActivity;
import com.example.androiddemo.tablayout.TabLayoutActivity;

public class MainActivity extends AppCompatActivity {
    private Button mBtnPagerSlidTab;
    private Button mBtnBtmNavi;
    private Button mBtnBanner;
    private Button mBtnRecyclerView;
    private Button mBtnSwipeRefreshLayout;
    private Button mBtnTableLayout;
    private Button mBtnStartForResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        OnClick onClick = new OnClick();
        mBtnPagerSlidTab = findViewById(R.id.btn_pager_slid_tab);
        mBtnBtmNavi = findViewById(R.id.btn_btm_navi);
        mBtnBanner = findViewById(R.id.btn_banner);
        mBtnRecyclerView = findViewById(R.id.btn_recyclerview);
        mBtnSwipeRefreshLayout = findViewById(R.id.btn_swiperefresh);
        mBtnTableLayout = findViewById(R.id.btn_tab_layout);
        mBtnStartForResult = findViewById(R.id.btn_act_return_result);

        mBtnPagerSlidTab.setOnClickListener(onClick);
        mBtnBtmNavi.setOnClickListener(onClick);
        mBtnBanner.setOnClickListener(onClick);
        mBtnRecyclerView.setOnClickListener(onClick);
        mBtnSwipeRefreshLayout.setOnClickListener(onClick);
        mBtnTableLayout.setOnClickListener(onClick);
        mBtnStartForResult.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_pager_slid_tab:
                    // 跳转到PagerSlidingTabStrip演示界面
                    intent = new Intent(MainActivity.this, PagerSlidingTabActivity.class);
                    break;
                case R.id.btn_btm_navi:
                    // 跳转到BottomNavigationActivity演示界面
                    intent = new Intent(MainActivity.this, BottomNavigationActivity.class);
                    break;
                case R.id.btn_banner:
                    // 跳转到Banner轮播演示界面
                    intent = new Intent(MainActivity.this, BannerActivity.class);
                    break;
                case R.id.btn_recyclerview:
                    // 跳转到RecyclerView演示界面
                    intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.btn_swiperefresh:
                    // 跳转到SwipeRefreshLayout演示界面
                    intent = new Intent(MainActivity.this, SwipeRefreshLayoutActivity.class);
                    break;
                case R.id.btn_tab_layout:
                    // 跳转到TabLayout演示界面
                    intent = new Intent(MainActivity.this, TabLayoutActivity.class);
                    break;
                case R.id.btn_act_return_result:
                    // 跳转到TabLayout演示界面
                    intent = new Intent(MainActivity.this, StartForResultActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
