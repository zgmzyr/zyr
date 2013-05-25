package com.zgm.zen.observer.example1;

public class HanFeizi implements IHanFeizi {

	private boolean isHavingBreakfast = false;
	private boolean isHavingFun = false;
	
	@Override
	public void haveBreakfast() {

		System.out.println("韩非子开始吃饭了。。。。。");
		this.isHavingBreakfast = true;
	}

	@Override
	public void haveFun() {

		System.out.println("韩非子开始娱乐了。。。。。");
		this.isHavingFun = true;
	}

	public boolean isHavingBreakfast() {
		return isHavingBreakfast;
	}

	public void setHavingBreakfast(boolean isHavingBreakfast) {
		this.isHavingBreakfast = isHavingBreakfast;
	}

	public boolean isHavingFun() {
		return isHavingFun;
	}

	public void setHavingFun(boolean isHavingFun) {
		this.isHavingFun = isHavingFun;
	}

}
