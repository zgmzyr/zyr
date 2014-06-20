package com.zgm.test;

/**
 * @author zhouguangming
 * 创建时间: 2014年4月10日 下午3:46:53
 */
public class Pt32 {
	// 思路：辗转相除法
	int divisor1(int m, int n) { // 方法一：循环法
		int temp;
		while (m % n != 0) {
			temp = n;
			n = m % n;
			m = temp;
		}
		return n;
	}

	int divisor2(int m, int n) { // 方法二：递归法
		if (m % n == 0) {
			return n;
		} else {
			return divisor2(n, m % n);
		}
	}

	public static void main(String args[]) {
		Pt32 obj = new Pt32();
		System.out.println("input two integer:");
		int a = 217;
		int b = 218;
		System.out.println(a + "," + b + "'s greatest common divisor is " + obj.divisor2(a, b));
	}
}
