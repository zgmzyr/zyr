package com.zgm.zen.bridge.example3;

public abstract class Corp {
	
	private Product product;
	
	public Corp(Product product) {
		super();
		this.product = product;
	}
	
	
	
	public void makeMoney(){
		this.product.beProducted();
		this.product.beSell();
	}
}

/*public abstract class Corp {

	
	protected abstract void produce();
	protected abstract void sell();
	
	public void makeMoney(){
		this.produce();
		this.sell();
	}
}*/
