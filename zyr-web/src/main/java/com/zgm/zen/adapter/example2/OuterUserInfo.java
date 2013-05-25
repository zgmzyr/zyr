package com.zgm.zen.adapter.example2;

import java.util.Map;


//public class OuterUserInfo extends OuterUser implements IUserInfo {
public class OuterUserInfo  implements IUserInfo {
	private IOuterUserBaseInfo baseInfo = null;
	private IOuterUserHomeInfo homeInfo = null;
	private IOuterUserOfficeInfo officeInfo = null;
	/*private Map baseInfo = super.getUserBaseInfo();
	private Map homeInfo = super.getUserHomeInfo();
	private Map officeInfo = super.getUserOfficeInfo();*/
	
	public OuterUserInfo(IOuterUserOfficeInfo officeInfo, IOuterUserBaseInfo baseInfo, IOuterUserHomeInfo homeInfo){
		this.baseInfo = baseInfo;
		this.homeInfo = homeInfo;
		this.officeInfo = officeInfo;
	}
	
//	@Override
	public String getHomeAddress() {
//		String homeAddress = (String) this.homeInfo.get("homeAddress");
		String homeAddress = (String) this.homeInfo.getUserHomeInfo().get("homeAddress");
		System.out.println(homeAddress);
		return homeAddress;
	}

//	@Override
	public String getHomeTelNumber() {
//		String homeTelNumber = (String) this.homeInfo.get("homeTelNumber");
		String homeTelNumber = (String) this.homeInfo.getUserHomeInfo().get("homeTelNumber");
		System.out.println(homeTelNumber);
		return homeTelNumber;
	}

//	@Override
	public String getJobPosition() {
//		String jobPosition = (String) this.officeInfo.get("JobPosition");
		String jobPosition = (String) this.officeInfo.getUserOfficeInfo().get("JobPosition");
		System.out.println(jobPosition);
		return jobPosition;
	}

//	@Override
	public String getMobileNumber() {
//		String mobileNumber = (String) this.baseInfo.get("mobileNumber");
		String mobileNumber = (String) this.baseInfo.getUserBaseInfo().get("mobileNumber");
		System.out.println(mobileNumber);
		return mobileNumber;
	}

//	@Override
	public String getOfficeTelNumber() {
//		String officeTelNumber = (String) this.officeInfo.get("officeTelNumber");
		String officeTelNumber = (String) this.officeInfo.getUserOfficeInfo().get("officeTelNumber");
		System.out.println(officeTelNumber);
		return officeTelNumber;
	}

//	@Override
	public String getUserName() {
		String userName = (String) this.homeInfo.getUserHomeInfo().get("userName");
		System.out.println(userName);
		return userName;
	}

}

