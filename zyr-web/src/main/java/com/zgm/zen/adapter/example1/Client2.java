package com.zgm.zen.adapter.example1;
/**
 * 类适配器: 通过继承进行适配
 * @author Administrator
 *
 */
public class Client2 {

	
	public static void main(String[] args){
		
//		IUserInfo youngGirl = new UserInfo();
		IUserInfo youngGirl = new OuterUserInfo();
		
		for(int i = 0; i < 101; i++){
			youngGirl.getMobileNumber();
		}
	}
}
