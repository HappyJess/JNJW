package com.yueshenginfo.jncc;

import android.app.Application;
import android.content.Context;

import com.yueshenginfo.jncc.publics.utils.ScreenManager;

public class IBaseApplication extends Application {

	@SuppressWarnings("unused")
	private Context mContext;
	
	/**
	 * 单例
	 */
	private static IBaseApplication mBaseApplication;

	/**
	 * 管理所有的activity
	 */
	public ScreenManager mScreenManager;

	// 单例的BaseApplication
	public static IBaseApplication getInstance() {
		if (mBaseApplication == null) {
			mBaseApplication = new IBaseApplication();
		}
		return mBaseApplication;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		mBaseApplication = this;
		mContext = this;
		// 管理所有activity
		mScreenManager = ScreenManager.getScreenManager();
		
		// 全局异常捕获类
		// CrashHandler crashHandler = CrashHandler.getInstance();
		// crashHandler.init(this);
	}

}