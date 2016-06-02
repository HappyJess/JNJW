package com.yueshenginfo.jnjw.modules.department.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yueshenginfo.jnjw.IBaseActivity;
import com.yueshenginfo.jnjw.R;
import com.yueshenginfo.jnjw.modules.department.adapter.QuickAdapter;
import com.yueshenginfo.jnjw.modules.department.dto.Status;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DepartmentActivity extends IBaseActivity {

    @Bind(R.id.rv_list)
    RecyclerView mRecyclerView;

    private QuickAdapter mQuickAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        ButterKnife.bind(this);

        initViews();
        initDatas();
        setListeners();
    }

    @Override
    public void initViews() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void initDatas() {
        initAdapter();
    }

    @Override
    public void setListeners() {

    }

    private void initAdapter() {
        mQuickAdapter = new QuickAdapter(this);
        mQuickAdapter.openLoadAnimation();
        mQuickAdapter.setOnRecyclerViewItemChildClickListener(new BaseQuickAdapter.OnRecyclerViewItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                String content = null;
                Status status = (Status) adapter.getItem(position);
                switch (view.getId()) {
                    case R.id.tweetAvatar:
                        content = "img:" + status.getUserAvatar();
                        break;
                    case R.id.tweetName:
                        content = "name:" + status.getUserName();
                        break;
                }
                Toast.makeText(DepartmentActivity.this, content, Toast.LENGTH_LONG).show();
            }
        });
        mRecyclerView.setAdapter(mQuickAdapter);
    }
}
