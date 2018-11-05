package com.example.androiddemo.pagerslidingtab;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.example.androiddemo.R;

public class PagerSlidingTabActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private PagerSlidingTabStrip mSlidingTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_sliding_tab);

        mViewPager = findViewById(R.id.view_pager);
        //mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        setupViewPager(mViewPager);

        // Bind the tabs to the ViewPager
        mSlidingTabs = findViewById(R.id.pager_slid_tab_strip);
        // 这里的ViewPager的适配器必须是继承的FragmentPagerAdapter，
        // 并重写getPageIconResId(int position)或者getPageTitle(int position)方法
        mSlidingTabs.setViewPager(mViewPager);

        setTabsValue();

        updateTextStyle(mViewPager.getCurrentItem());
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                updateTextStyle(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    // 文本指示器Tab选中后文本大小和颜色变化
    private void updateTextStyle(int position) {
        LinearLayout tabsContainer = (LinearLayout) mSlidingTabs.getChildAt(0);
        for (int i = 0; i < tabsContainer.getChildCount(); i++) {
            TextView textView = (TextView) tabsContainer.getChildAt(i);
            if (i == position) {
                textView.setTextSize(18);
                textView.setTextColor(getResources().getColor(R.color.tab_checked));
            } else {
                textView.setTextSize(12);
                textView.setTextColor(getResources().getColor(R.color.tab_unchecked));
            }
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(BlankFragment.newInstance("新闻"));
        adapter.addFragment(BlankFragment.newInstance("图书"));
        adapter.addFragment(BlankFragment.newInstance("发现"));
        adapter.addFragment(BlankFragment.newInstance("更多"));
        viewPager.setAdapter(adapter);
    }

    /**
     * 对PagerSlidingTabStrip的各项属性进行赋值。
     */
    private void setTabsValue() {
        // 获取屏幕密度
        DisplayMetrics dm = getResources().getDisplayMetrics();
        // 设置Tab是自动填充满屏幕的
        mSlidingTabs.setShouldExpand(false);
        // 设置Tab的分割线是透明的
        mSlidingTabs.setDividerColor(Color.TRANSPARENT);
        // 设置Tab底部线的高度
        mSlidingTabs.setUnderlineHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, dm));
        // 设置Tab Indicator的高度
        mSlidingTabs.setIndicatorHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3, dm));
        // 设置Tab标题文字的大小
        mSlidingTabs.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, dm));
        // 设置Tab Indicator的颜色
        mSlidingTabs.setIndicatorColor(Color.parseColor("#d83737"));//#d83737   #d83737(绿)
        // 取消点击Tab时的背景色
        mSlidingTabs.setTabBackground(0);
    }

}
