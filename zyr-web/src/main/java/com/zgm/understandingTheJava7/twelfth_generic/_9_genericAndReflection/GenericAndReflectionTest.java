/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._9_genericAndReflection;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: GenericAndReflectionTest.java $Date: 2013-4-14 下午3:58:03
 *          -0400 2013
 * @since 1.0
 * 
 */
public class GenericAndReflectionTest {

	class Target<T> implements Serializable {
		public List<? extends Comparable<T>> create(T obj) throws Exception {
			throw new Exception();
			// return null;
		}
	}
	

	public static void reflect() throws NoSuchMethodException,
			SecurityException {
		Class<?> clazz = Target.class;
		Type[] genericInterfaceTypes = clazz.getGenericInterfaces();
		for (Type genericInterfaceType : genericInterfaceTypes) {
			System.out.println("genericInterfaceType: " + genericInterfaceType);
		}
		
		Type genericSuperClassType = clazz.getGenericSuperclass();
		System.out.println("genericSuperClassType: " + genericSuperClassType);
		
		Class<?> superClass = clazz.getSuperclass();
		System.out.println("superClass: " + superClass.getCanonicalName());
		System.out.println("superClass: " + superClass.getName());
		
		
		Method method = clazz.getMethod("create",
				new Class<?>[] { Object.class });
		Type[] genericParameterTypes = method.getGenericParameterTypes();
		Type genericParameterType = genericParameterTypes[0];
		TypeVariable<?> typeVariable = (TypeVariable<?>) genericParameterType;
		System.out.println("parameterType name: " + typeVariable.getName());

		Type[] parameterTypes = method.getParameterTypes();
		if (parameterTypes != null) {
			for (Type parameterType : parameterTypes) {
				System.out.println("parameterType: " + parameterType);
			}
		}
		Type returnType = method.getReturnType();
		System.out.println("returnType: " + returnType);
		
		
		Type genericReturnType = method.getGenericReturnType();
		ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
		Type ownerType = parameterizedType.getOwnerType();
		System.out.println("ownerType: " + ownerType);
		
		Type rawType = parameterizedType.getRawType();
		System.out.println("rawType: " + rawType);
		
		Type[] actualTypes = parameterizedType.getActualTypeArguments();
		if (actualTypes != null) {
			for (Type actualType : actualTypes) {
				System.out.println("actualType: " + actualType);

				Type[] upperBounds = ((WildcardType) actualType)
						.getUpperBounds();
				if (upperBounds != null) {
					for (Type upperBound : upperBounds) {
						System.out.println("upper bound: " + upperBound);
					}
				}

				Type[] lowerBounds = ((WildcardType) actualType)
						.getLowerBounds();
				if (lowerBounds != null) {
					for (Type lowerBound : lowerBounds) {
						System.out.println("lower bound: " + lowerBound);
					}
				}
			}
		}

		Type[] exceptionTypes = method.getGenericExceptionTypes();
		if (exceptionTypes != null) {
			for (Type exceptionType : exceptionTypes) {
				System.out.println("exceptionType: " + exceptionType);
			}
		}
	}

	public static void main(String[] args) throws NoSuchMethodException,
			SecurityException {
		reflect();
	}
}
