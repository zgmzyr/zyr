package com.zgm.zen.observer.example3;

import java.util.ArrayList;

//public class HanFeizi implements IHanFeizi{
public class HanFeizi implements IHanFeizi, Observable {

	private ArrayList<Observer> observerList = new ArrayList<Observer>();
	
//	private ILiSi liSi = new LiSi();
	
	
	
	@Override
	public void haveBreakfast() {

		System.out.println("韩非子开始吃饭了。。。。。");
//		this.liSi.update("韩非子吃饭");
//		this.isHavingBreakfast = true;
		this.notifyObservers("韩非子吃饭");
	}

	@Override
	public void haveFun() {

		System.out.println("韩非子开始娱乐了。。。。。");
//		this.liSi.update("韩非子娱乐");
//		this.isHavingFun = true;
		this.notifyObservers("韩非子娱乐");
	}

	@Override
	public void addOberver(Observer observer) {
		this.observerList.add(observer);
	}

	@Override
	public void deleteObserver(Observer observer) {
		this.observerList.remove(observer);
	}

	@Override
	public void notifyObservers(String context) {
		for(Observer observer : observerList){
			observer.update(context);
		}
	}
	
	

	
}
/*public class HanFeizi implements IHanFeizi {

	private ILiSi liSi = new LiSi();
	
	
	
	@Override
	public void haveBreakfast() {

		System.out.println("韩非子开始吃饭了。。。。。");
		this.liSi.update("韩非子吃饭");
//		this.isHavingBreakfast = true;
	}

	@Override
	public void haveFun() {

		System.out.println("韩非子开始娱乐了。。。。。");
		this.liSi.update("韩非子娱乐");
//		this.isHavingFun = true;
	}

	
}*/


