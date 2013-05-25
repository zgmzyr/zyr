package com.zgm.zen.adapter.example1;

import java.util.Map;

public class OuterUserInfo extends OuterUser implements IUserInfo {
	private Map baseInfo = super.getUserBaseInfo();
	private Map homeInfo = super.getUserHomeInfo();
	private Map officeInfo = super.getUserOfficeInfo();
	
	
	@Override
	public String getHomeAddress() {
		String homeAddress = (String) this.homeInfo.get("homeAddress");
		System.out.println(homeAddress);
		return homeAddress;
	}

	@Override
	public String getHomeTelNumber() {
		String homeTelNumber = (String) this.homeInfo.get("homeTelNumber");
		System.out.println(homeTelNumber);
		return homeTelNumber;
	}

	@Override
	public String getJobPosition() {
		String jobPosition = (String) this.officeInfo.get("JobPosition");
		System.out.println(jobPosition);
		return jobPosition;
	}

	@Override
	public String getMobileNumber() {
		String mobileNumber = (String) this.baseInfo.get("mobileNumber");
		System.out.println(mobileNumber);
		return mobileNumber;
	}

	@Override
	public String getOfficeTelNumber() {
		String officeTelNumber = (String) this.officeInfo.get("officeTelNumber");
		System.out.println(officeTelNumber);
		return officeTelNumber;
	}

	@Override
	public String getUserName() {
		String userName = (String) this.homeInfo.get("userName");
		System.out.println(userName);
		return userName;
	}

}
