package com.zgm.zen.bridge.example3;


public class HouseCorp extends Corp {

	public HouseCorp(House house){
		super(house);
	}
	
	@Override
	public void makeMoney(){
		super.makeMoney();
		System.out.println("房地产公司赚大钱了。。。");
	}

}
/*public class HouseCorp extends Corp {

	@Override
	protected void produce() {
		System.out.println("房地产公司盖房子。。。");
	}

	@Override
	protected void sell() {
		System.out.println("房地产公司出售房子。。。");
		
	}
	
	@Override
	public void makeMoney(){
		super.makeMoney();
		System.out.println("房地产公司赚大钱了。。。");
	}

}*/
