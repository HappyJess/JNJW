package com.yueshenginfo.jnjw;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.yueshenginfo.jnjw.publics.utils.EmptyUtils;

/**
 * Title: IBaseFragment<br/>
 * Description: Fragment基类<br/>
 * Copyright: Copyright (c) 山东悦升<br/>
 * Company: 山东悦升信息技术有限公司<br/>
 * Author: created 李忠峰 2016/5/27<br/>
 * Since: 1.0
 * Version: 1.0
 */
public abstract class IBaseFragment extends Fragment {

    protected Context mContext;
    private View rootView;

    /**
     * onCreate
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getActivity();
    }

    /**
     * onCreateView
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = createView(inflater, container);
        }
        return rootView;
    }

    /**
     * onDestroyView
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((ViewGroup) rootView.getParent()).removeView(rootView);
    }

    /**
     * 根据控件id查找控件
     *
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T extends View> T getViewById(int id) {
        return (T) rootView.findViewById(id);
    }

    /**
     * 子类实现创建View操作
     *
     * @param inflater
     * @param container
     * @return
     */
    public abstract View createView(LayoutInflater inflater, ViewGroup container);

    /**
     * 子类初始化View操作
     */
    public abstract void initViews();

    /**
     * 子类实现初始化数据操作
     */
    public abstract void initDatas();

    /**
     * 子类实现初始化监听操作
     */
    public abstract void setListeners();

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
     * 方法功能
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * Title: MenuFragmentConfig<br/>
     * Description: 菜单列表fragment相关设置<br/>
     * <p/>
     * Copyright: Copyright (c) 众远科技<br/>
     * Company: 济南众远信息科技有限公司<br/>
     *
     * @author create 高越 2016年1月14日<br/>
     * @version 1.0
     * @since 1.0
     */
    public class MenuFragmentConfig {

        /**
         * 重新计算listview的高度并返回listview高度，解决scrollview和listview的滚动条在嵌套时冲突的问题
         */
        public int calculateListViewHeight(ListView listView) {
            // 获取listadapter
            ListAdapter adapter = listView.getAdapter();
            if (adapter == null) {
                return 0;
            }
            int totalHeight = 0;
            for (int i = 0, len = adapter.getCount(); i < len; i++) {
                View listItem = adapter.getView(i, null, listView);
                listItem.measure(0, 0);
                totalHeight += listItem.getMeasuredHeight();
            }
            int height = totalHeight
                    + (listView.getDividerHeight() * (adapter.getCount() - 1));
            return height;
        }

    }

    /**
     * 方法功能
     */
    public void showProgress() {
        // 滚动条
//		progressHUD = ZProgressHUD.getInstance(mContext);
//		progressHUD.setMessage("请稍等..");
//		progressHUD.setSpinnerType(ZProgressHUD.FADED_ROUND_SPINNER);
//		progressHUD.show();
    }

    /**
     * 方法功能
     */
    public void dismissProgress() {
//		if (progressHUD != null) {
//			progressHUD.dismiss();
//			progressHUD = null;
//		}
    }

}
