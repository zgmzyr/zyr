package com.zgm.zen.bridge.example2;

import com.zgm.zen.bridge.example1.Corp;

public class IPodCorp extends Corp {

	@Override
	protected void produce() {
		System.out.println("我生产IPod");
	}

	@Override
	protected void sell() {
		System.out.println("IPod畅销中。。");

	}

	@Override
	public void makeMoney() {
		super.makeMoney();
		
		System.out.println("我赚钱了。。");
	}
	
	

}
