package com.yueshenginfo.jnjw.modules.home;

import android.os.Bundle;
import android.view.View;

import com.flyco.pageindicator.indicator.RoundCornerIndicaor;
import com.yueshenginfo.jnjw.IBaseActivity;
import com.yueshenginfo.jnjw.R;
import com.yueshenginfo.jnjw.modules.home.banner.ImageBanner;
import com.yueshenginfo.jnjw.modules.home.banner.ViewFindUtils;

import java.util.ArrayList;

public class MainActivity extends IBaseActivity {

    private int[] resIds = {R.drawable.one, R.drawable.two,
            R.drawable.three, R.drawable.four};
    private ArrayList<Integer> resList;
    private View decorView;
    private ImageBanner banner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        setListener();
    }

    @Override
    public void initView() {
        resList = new ArrayList<>();
        for (int i = 0; i < resIds.length; i++) {
            resList.add(resIds[i]);
        }

        decorView = getWindow().getDecorView();
        banner = ViewFindUtils.find(decorView, R.id.banner_circle);
        banner.setSource(resList).startScroll();
        RoundCornerIndicaor indicator = ViewFindUtils.find(decorView, R.id.indicator_circle);
        indicator.setViewPager(banner.getViewPager(), resList.size());
    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {

    }
}
