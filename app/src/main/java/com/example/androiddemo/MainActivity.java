package com.example.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androiddemo.BottomNavigation.BottomNavigationActivity;
import com.example.androiddemo.pagerslidingtab.PagerSlidingTabActivity;

public class MainActivity extends AppCompatActivity {
    private Button mBtnPagerSlidTab;
    private Button mBtnBtmNavi;

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

        mBtnPagerSlidTab.setOnClickListener(onClick);
        mBtnBtmNavi.setOnClickListener(onClick);
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
            }

            startActivity(intent);
        }
    }
}