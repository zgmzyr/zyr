package com.zgm.zen.observer.example3;

//public class LiSi implements ILiSi {
public class WangSi implements Observer {

	@Override
	public void update(String context) {

		System.out.println("王斯：观察到韩非子活动，开始向老板汇报了。。。。。");
		this.reportQiShiHuang(context);
		System.out.println("王斯：汇报完毕。。。。。");
	}
	
	private void reportQiShiHuang(String reportcontext){
		System.out.println("王斯：报告，秦老板，韩非子有活动了---》" + reportcontext);
	}

}
/*public class LiSi implements ILiSi {

	@Override
	public void update(String context) {

		System.out.println("李斯：观察到韩非子活动，开始向老板汇报了。。。。。");
		this.reportQiShiHuang(context);
		System.out.println("李斯：汇报完毕。。。。。");
	}
	
	private void reportQiShiHuang(String reportcontext){
		System.out.println("李斯：报告，秦老板，韩非子有活动了---》" + reportcontext);
	}

}*/
