/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.eight._114;

import java.io.IOException;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Sub2.java $Date: 2012-5-10 下午10:02:39 -0400 2012
 * @since 1.0
 * 
 */
public class Sub2 extends Base {

	public Sub2() throws Exception {
		try {
			super(); //调用super必须为第一条语句
		} catch (IOException e) {
			//异常处理后再抛出
			
			throw e;
		} finally {
			//收尾处理
		}
		
	}
}
