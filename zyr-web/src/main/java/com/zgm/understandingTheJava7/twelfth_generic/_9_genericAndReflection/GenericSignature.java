/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._9_genericAndReflection;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: GenericSignatures.java $Date: 2013-4-14 下午3:49:09 -0400 2013
 * @since 1.0
 * 
 */
public class GenericSignature<S extends Number> {

	public S obj;

	public S getObj() {
		return obj;
	}

	public void setObj(S obj) {
		this.obj = obj;
	}
}
