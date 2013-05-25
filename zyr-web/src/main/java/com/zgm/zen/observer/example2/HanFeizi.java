package com.zgm.zen.observer.example2;

public class HanFeizi implements IHanFeizi {

	private ILiSi liSi = new LiSi();
	
	/*private boolean isHavingBreakfast = false;
	private boolean isHavingFun = false;*/
	
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

	/*public boolean isHavingBreakfast() {
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
	}*/

}

/*public class HanFeizi implements IHanFeizi {

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

}*/
