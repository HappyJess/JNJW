package com.yueshenginfo.jncc.publics.utils;

import android.util.Log;

/**
 * 
 * Title: L<br/>
 * Description: Log管理类<br/>
 * 
 * Copyright: Copyright (c) 众远科技<br/>
 * Company: 济南众远信息科技有限公司<br/>
 * 
 * @author create 高越 2015年10月12日<br/>
 * @since 1.0
 * @version 1.0
 */
public class L {

    private L() {
        throw new UnsupportedOperationException("L-不能被实例化");
    }

    // 是否需要打印bug，可以在application的onCreate函数里面初始化
    public static boolean isDebug = true;
    private static final String TAG = "mLog";

    // 下面四个是默认tag的函数
    public static void i(String msg) {
        if (isDebug)
            Log.i(TAG, msg);
    }

    public static void d(String msg) {
        if (isDebug)
            Log.d(TAG, msg);
    }

    public static void e(String msg) {
        if (isDebug)
            Log.e(TAG, msg);
    }

    public static void v(String msg) {
        if (isDebug)
            Log.v(TAG, msg);
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }
}