package com.zgm.zen.proxy.common;

public class Proxy implements Subject {
	//要代理哪个实现类
	private Subject subject = null;
	
	public Proxy(){
		this.subject = new Proxy(); //有点小怪
	}
	
	public Proxy(Object... objects){
		
	}
	
	@Override
	public void request() {
		this.before();
		this.subject.request();
		this.after();
		
	}
	
	private void before(){
		System.out.println("预先处理！");
	}
	
	private void after(){
		System.out.println("善后处理！");
	}

}
