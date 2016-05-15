package com.yueshenginfo.jnjw.publics.utils;

import java.util.UUID;

/**
 * Title: UUIDUtil<br/>
 * Description: UUID工具类<br/>
 * 
 * Copyright: Copyright (c) 众远科技<br/>
 * Company: 济南众远信息科技有限公司<br/>
 * 
 * @author create 高越 2015年12月10日<br/>
 * @since 1.0
 * @version 1.0
 */
public class UUIDUtil {

	/**
	 * 获取uuid（32位）
	 * 
	 * @description
	 * 
	 * @return uuid
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
}
