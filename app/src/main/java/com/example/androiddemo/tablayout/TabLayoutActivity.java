package com.example.androiddemo.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.androiddemo.R;

public class TabLayoutActivity extends AppCompatActivity {
    private final static String TAG = "TabLayoutActivity";
    private TabLayout tabLayout;
    private ViewPager viewPager;
    TabLayoutAdapter tabLayoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        initRes();
    }

    private void initRes() {
        tabLayout = findViewById(R.id.tab_layout_container);
        viewPager = findViewById(R.id.tab_layout_viewpager);

        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                Log.d(TAG,"======>onTabSelected:"+tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        TabLayoutAdapter adapter = new TabLayoutAdapter(getSupportFragmentManager());
        String[] titleFragment = new String[]{"推荐", "热点", "视频", "社会", "图片", "娱乐", "科技", "汽车"};
        for (int i=0; i< titleFragment.length; ++i) {
            adapter.addFragment(TabLayoutFragment.newInstance(titleFragment[i]));
        }

        viewPager.setAdapter(adapter);
        //设置预加载页面的数目，避免当页面个数 > 3时，有Fragment被销毁的情况
        viewPager.setOffscreenPageLimit(adapter.getCount() - 1);
    }
}
