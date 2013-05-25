package com.zgm.zen.responsibilityChain.common;

public class ConcreteHandler2 extends Handler {
	
	protected Response echo(Request request){
		//完成处理逻辑
		return null;
	}
	
	//设置自己的处理级别
	protected Level getHandlerLevel(){
		return null;
	}

}
