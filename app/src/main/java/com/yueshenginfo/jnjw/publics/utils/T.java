package com.yueshenginfo.jnjw.publics.utils;

import android.content.Context;
import android.widget.Toast;


/**
 * Title: T<br/>
 * Description: Toast工具类<br/>
 * 
 * Copyright: Copyright (c) 众远科技<br/>
 * Company: 济南众远信息科技有限公司<br/>
 * 
 * @author create 高越 2015年10月28日<br/>
 * @since 1.0
 * @version 1.0
 */
public class T {

	/**
	 * 
	 * Toast show
	 *
	 * @param context
	 * @param msg
	 */
	public static void show(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}
	
}
