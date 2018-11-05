package com.example.androiddemo.banner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.androiddemo.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class BannerActivity extends AppCompatActivity {
    private List<String> imageList;
    private List<String> imageTitle;
    private Banner mBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        // 设置图片地址
        imageList = new ArrayList<>();
        imageList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1541408832598&di=3019468b4296d5840126626acb375c04&imgtype=0&src=http%3A%2F%2Fmedia-cdn.tripadvisor.com%2Fmedia%2Fphoto-s%2F02%2F64%2F60%2F0b%2Fbeautiful-water.jpg");
        imageList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1541408850117&di=359ef42c4af8d13c7a94c9043e4209d0&imgtype=0&src=http%3A%2F%2Fmedia-cdn.tripadvisor.com%2Fmedia%2Fphoto-s%2F01%2Fc7%2F19%2F48%2Fjet-boat-deep-into-world.jpg");
        imageList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1541408869850&di=60c36bf7db7e695982f60c82627d70b1&imgtype=0&src=http%3A%2F%2Fmedia-cdn.tripadvisor.com%2Fmedia%2Fphoto-s%2F03%2F01%2Fff%2F64%2Fgrand-mirage-resort.jpg");

        // 设置标题文字
        imageTitle = new ArrayList<>();
        imageTitle.add("111111");
        imageTitle.add("222222");
        imageTitle.add("333333");

        mBanner = findViewById(R.id.banner_container);
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(imageList);
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.RotateDown);
        //设置标题集合（当banner样式有显示title时）
        mBanner.setBannerTitles(imageTitle);
        //设置轮播时间
        mBanner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();

        // 添加banner点击事件
        mBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(BannerActivity.this, "点击了图片" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
