package com.yueshenginfo.jnjw.modules.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.yueshenginfo.jnjw.IBaseActivity;
import com.yueshenginfo.jnjw.R;
import com.yueshenginfo.jnjw.modules.department.activity.DepartmentActivity;
import com.yueshenginfo.jnjw.modules.home.banner.SimpleImageBanner;
import com.yueshenginfo.jnjw.modules.home.banner.SimpleTextBanner;
import com.yueshenginfo.jnjw.modules.home.banner.ViewFindUtils;
import com.yueshenginfo.jnjw.publics.utils.DataProvider;
import com.yueshenginfo.jnjw.publics.utils.T;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends IBaseActivity {

    @Bind(R.id.btn_jwbm)
    Button mBtnJwbm;
    @Bind(R.id.btn_bmfw)
    Button mBtnBmfw;
    @Bind(R.id.btn_cjdsj)
    Button mBtnCjdsj;
    @Bind(R.id.btn_xxgk)
    Button mBtnXxgk;
    @Bind(R.id.btn_tzgg)
    Button mBtnTzgg;
    @Bind(R.id.btn_hddt)
    Button mBtnHddt;
    //侧滑菜单
    private DrawerLayout mDrawerLayout;
    private ListView lvLeftMenu;
    private String[] lvs = {"List Item 01", "List Item 02", "List Item 03", "List Item 04"};
    private ArrayAdapter arrayAdapter;
    //主要布局
    private View decorView;
    private DisplayMetrics dm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initViews();
        initDatas();
        setListeners();
    }

    @Override
    public void initViews() {
        //侧滑菜单
        mDrawerLayout = getViewById(R.id.dl_left);
        lvLeftMenu = getViewById(R.id.lv_left_menu);
        //设置菜单列表
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lvs);
        lvLeftMenu.setAdapter(arrayAdapter);
        //主要布局
        decorView = getWindow().getDecorView();
        dm = getResources().getDisplayMetrics();
        sib_corner_rectangle();
        stb();
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void setListeners() {

    }

    private void sib_corner_rectangle() {
        SimpleImageBanner sib = ViewFindUtils.find(decorView, R.id.sib_corner_rectangle);
        sib
//                .setIndicatorWidth(10)
//                .setIndicatorHeight(4)
//                .setIndicatorCornerRadius(2)
                .setSource(DataProvider.getList())
                .startScroll();

        sib.setOnItemClickL(new SimpleImageBanner.OnItemClickL() {
            @Override
            public void onItemClick(int position) {
                T.showShort(mContext, "position--->" + position);
            }
        });
    }

    private void stb() {
        SimpleTextBanner stb = ViewFindUtils.find(decorView, R.id.stb);

        ArrayList<String> titles = new ArrayList<>();
        for (String title : DataProvider.titles) {
            titles.add(title);
        }
        stb
                .setSource(titles)
                .startScroll();

        stb.setOnItemClickL(new SimpleImageBanner.OnItemClickL() {
            @Override
            public void onItemClick(int position) {
                T.showShort(mContext, "position--->" + position);
            }
        });
    }


    @OnClick({R.id.btn_jwbm, R.id.btn_bmfw, R.id.btn_cjdsj, R.id.btn_xxgk, R.id.btn_tzgg, R.id.btn_hddt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_jwbm:
                T.showShort(mContext,"建委部门");
                startActivity(new Intent(mContext, DepartmentActivity.class));
                break;
            case R.id.btn_bmfw:
                break;
            case R.id.btn_cjdsj:
                break;
            case R.id.btn_xxgk:
                break;
            case R.id.btn_tzgg:
                break;
            case R.id.btn_hddt:
                break;
        }
    }
}
