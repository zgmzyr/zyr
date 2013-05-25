package com.zgm.zen.adapter.example1;

/**
 * 
 * @author Administrator
 *
 */
public class Client {

	
	public static void main(String[] args){
		
		IUserInfo youngGirl = new UserInfo();
		
		for(int i = 0; i < 101; i++){
			youngGirl.getMobileNumber();
		}
	}
}
