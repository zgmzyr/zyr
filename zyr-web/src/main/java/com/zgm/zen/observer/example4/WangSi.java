package com.zgm.zen.observer.example4;

import java.util.Observer;
import java.util.Observable;

public class WangSi implements Observer {

	/*@Override
	public void update(String context) {

		System.out.println("刘斯：观察到韩非子活动，开始向老板汇报了。。。。。");
		this.reportQiShiHuang(context);
		System.out.println("刘斯：汇报完毕。。。。。");
	}*/
	
	@Override
	public void update(Observable obserable, Object object) {

		System.out.println("王斯：观察到韩非子活动，开始向老板汇报了。。。。。");
		this.reportQiShiHuang(object.toString());
		System.out.println("王斯：汇报完毕。。。。。");
	}
	
	private void reportQiShiHuang(String reportcontext){
		System.out.println("王斯：报告，秦老板，韩非子有活动了---》" + reportcontext);
	}

}

//public class LiSi implements ILiSi {
/*public class LiuSi implements Observer {

	@Override
	public void update(String context) {

		System.out.println("刘斯：观察到韩非子活动，开始向老板汇报了。。。。。");
		this.reportQiShiHuang(context);
		System.out.println("刘斯：汇报完毕。。。。。");
	}
	
	private void reportQiShiHuang(String reportcontext){
		System.out.println("刘斯：报告，秦老板，韩非子有活动了---》" + reportcontext);
	}

}
*/
