package com.zgm.java.util.Calendar;

import java.util.Calendar;

import org.junit.Test;

/**
 * @author zhouguangming
 * 创建时间: 2014年7月10日 下午3:09:09
 */
public class GregorianCalendarTest {

	@Test
	public void test() {
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.set(1999, 7, 31); // 1999-8-31

		System.out.println("=======add()================");
		System.out.println("1、规则第一条：");
		System.out.println("当被修改的字段超出它可以的范围时，那么比它大的字段会自动修正。");
		System.out.println("2、规则第二条：");
		System.out.println("当被修改的字段超出它可以的范围时，那么比它大的字段不会被修正。");
		System.out.println("****************************");

		// 规则1: 没有超出范围，不用改变大的字段(年份不变)
		c.add(Calendar.MONTH, 1); // 1999-9-31 => 1999-10-1，对吗？
		// 规则2:比其小的字段(日期改变),变化最小值，为30即可
		System.out.println(df.format(c.getTime())); // 结果是 1999-9-30

		// 再如
		c.set(1999, 7, 31); // 1999-8-31
		// 规则1:超出范围，改变大的字段(年份为2000年) 2000-9-31 9月没有31
		// 规则2:比其小的字段(日期改变),变化最小值，为30即可 ==> 变成 2000-9-30
		c.add(Calendar.MONTH, 13);
		System.out.println(df.format(c.getTime())); // 结果是 2000-9-30

		System.out.println("===========Roll()============");
		System.out.println("规则只有第二条：");
		System.out.println("当被修改的字段超出它可以的范围时，那么比它大的字段不会被修正。");
		System.out.println("*****************************");
		// 使用 roll
		c.set(1999, 7, 31); // 1999-8-31
		// 没有规则1:roll 不改变年份，1999-21-31 -->1999-9-31 9月没有31
		// 只有规则2:比其小的字段(日期改变),变化最小值，为30即可 ==> 变成 1999-9-30
//		c.add(Calendar.MONTH, 13);
		c.roll(Calendar.MONTH, 13);
		System.out.println(df.format(c.getTime())); // 1999-09-30

		// 你的代码 8 表示9月 1999-09-31，9月没有31,应该为1999-10-1
		System.out.println("=======set()================");
		System.out.println("set() 会自动转换为合法的日期,如 set(1999,8,31) ");
		System.out.println("表示的是1999-09-31，9月没有31,应该为1999-10-1 	");
		System.out.println("*****************************");
		c.set(1999, 8, 31); // 1999-09-31 9月没有31 -->1999-10-1
		System.out.println(df.format(c.getTime()));// 1999-10-1
		c.roll(Calendar.MONTH, 11); // 1999-21-01 ==>1999-09-01
		System.out.println(df.format(c.getTime())); // 1999-09-01

	}
}
