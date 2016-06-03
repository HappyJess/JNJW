package com.yueshenginfo.jncc;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.yueshenginfo.jncc.publics.utils.EmptyUtils;


/**
 * Title: BaseActivity<br/>
 * Description: Activity基类<br/>
 * <p/>
 * Copyright: Copyright (c) 众远科技<br/>
 * Company: 青岛美德威文化传播有限公司<br/>
 *
 * @author create 高越 2015年10月12日<br/>
 * @version 1.0
 * @since 1.0
 */
public abstract class IBaseActivity extends FragmentActivity {

    protected Context mContext;
    protected IBaseApplication mApplication;


    /**
     * onCreate
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 设定始终保持竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mContext = this;

//        FrescoConfigConstants.init(getResources());// 初始化默认图片（占位图，错误图）
        Fresco.initialize(mContext);// 图片缓存初始化配置

        mApplication = IBaseApplication.getInstance();
        mApplication.mScreenManager.pushActivity(this);// 管理Activity

    }

    /**
     * 初始化控件
     */
    public abstract void initViews();

    /**
     * 初始化数据
     */
    public abstract void initDatas();

    /**
     * 设置监听
     */
    public abstract void setListeners();

    /**
     * 根据控件id查找控件
     *
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T extends View> T getViewById(int id) {
        return (T) this.findViewById(id);
    }

    /**
     * 设置title
     */
    public void setTitle(String title) {
        TextView titleView = getViewById(R.id.titlename_txt);
        if (EmptyUtils.isNotEmpty(title)) {
            titleView.setText(title);
        }
    }

    /**
     * 返回
     *
     * @param v
     */
    public void onBackPressed(View v) {
        onBackPressed();
        // activity切换动画
    }

    /**
     * 返回
     */
    public void onBackPressed() {
        super.onBackPressed();
    }

    /**
     * onDestroy
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 方法功能
     */
    public void showProgress() {
        // 滚动条
        // progressHUD = ZProgressHUD.getInstance(this);
        // progressHUD.setMessage("请稍等..");
        // progressHUD.setSpinnerType(ZProgressHUD.FADED_ROUND_SPINNER);
        // progressHUD.show();
//		ProgressDialog.Builder builder = new ProgressDialog.Builder(mContext);
//		progressDialog = builder.create();
//		// 防止重复创建
//		if (!progressDialog.isShowing()) {
//			progressDialog.show();
//		}
    }

    /**
     * 方法功能
     */
    public void dismissProgress() {
        // if (progressHUD != null) {
        // progressHUD.dismiss();
        // progressHUD = null;
        // }

//		if (progressDialog != null) {
//			progressDialog.dismiss();
//			progressDialog = null;
//		}
    }

}