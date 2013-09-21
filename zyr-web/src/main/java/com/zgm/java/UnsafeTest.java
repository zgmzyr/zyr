/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: UnsafeTest.java $Date: 2013-5-8 下午10:23:09 -0400 2013
 * @since 1.0
 * 
 */
/*
 *Copyright 2010, the original author or authors.  All rights reserved.
 */
import java.lang.reflect.Field;
import java.util.logging.Logger;

import sun.misc.Unsafe;

/**
 * 通过反射获取rt.jar下的Unsafe类
 * 
 * @author <a href="mailto:xiao_jiang51@163.com">xiao jiang</a>
 * @version %I%, %G%
 * @history 2010-12-23
 */
public class UnsafeTest {
//  private static Logger log = Logger.getLogger(UnsafeTest.class);

  public static void main(String[] args) {
    Unsafe unsafe = UnsafeSupport.getInstance();
    // 这个很牛
    // unsafe.allocateMemory(1000000000l);

    Class clazz = AnalyzedTarget.class;
    Field[] fields = clazz.getDeclaredFields();
    System.out.println("fieldName:fieldOffset");
    // 获取属性偏移量，可以通过这个偏移量给属性设置
    for (Field f : fields) {
      System.out.println(f.getName() + ":" + unsafe.objectFieldOffset(f));
    }
    
    // arg0, arg1, arg2, arg3 分别是目标对象实例，目标对象属性偏移量，当前预期值，要设的值
    // unsafe.compareAndSwapInt(arg0, arg1, arg2, arg3)
    AnalyzedTarget target = new AnalyzedTarget();
    // 偏移量编译后一般不会变的,intParam这个属性的偏移量
    long intParamOffset = 12;
    // 给它设置,返回true表明设置成功, 基于有名的CAS算法的方法，并发包用这个方法很多
    System.out.println(unsafe.compareAndSwapInt(target, intParamOffset, 0, 3));
    System.out.println("target.getIntParam() : " + target.getIntParam());
    System.out.println("target.getDoubleParam() : " + target.getDoubleParam());
    //比较失败
    System.out.println(unsafe.compareAndSwapInt(target, intParamOffset, 0, 10));
    System.out.println("target.getIntParam() : " + target.getIntParam());
    //验证下上面是否设置成功,应该还是3，返回ture说明上面没该
    System.out.println(unsafe.compareAndSwapInt(target, intParamOffset, 3, 10));
    System.out.println("target.getIntParam() : " + target.getIntParam());
  }
}

