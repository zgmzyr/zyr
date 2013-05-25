package com.zgm.zen.adapter.example2;

/**
 * 对象适配器： 通过关联关系
 * @author Administrator
 *
 */
public class Client {

	
	/*public static void main(String[] args){
		
		IUserInfo youngGirl = new UserInfo();
		
		for(int i = 0; i < 101; i++){
			youngGirl.getMobileNumber();
		}
	}*/
	
	public static void main(String[] args){
		
		IOuterUserBaseInfo baseInfo = new OuterUserBaseInfo();
		IOuterUserHomeInfo homeInfo = new OuterUserHomeInfo();
		IOuterUserOfficeInfo officeInfo = new OuterUserOfficeInfo();
		
		IUserInfo youngGirl = new OuterUserInfo(officeInfo, baseInfo, homeInfo);
		
		for(int i = 0; i < 101; i++){
			youngGirl.getMobileNumber();
		}
	}
}
