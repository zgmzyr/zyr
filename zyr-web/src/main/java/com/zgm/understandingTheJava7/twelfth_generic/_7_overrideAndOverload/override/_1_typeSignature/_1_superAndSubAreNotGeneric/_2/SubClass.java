/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._7_overrideAndOverload.override._1_typeSignature._1_superAndSubAreNotGeneric._2;

import com.zgm.understandingTheJava7.twelfth_generic._7_overrideAndOverload.override._1_typeSignature._1_superAndSubAreNotGeneric._1.SuperClass;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SubClass.java $Date: 2013-4-7 下午9:40:09 -0400 2013
 * @since 1.0
 * 
 */
public class SubClass extends SuperClass {
	@Override
	public <S> void method(S obj) {
		
	}
	
}
