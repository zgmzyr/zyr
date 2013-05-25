package com.zgm.zen.observer.example1;

public class Spy extends Thread{

	private HanFeizi hanFeizi;
	private LiSi lisi;
	private String type;
	public Spy(HanFeizi hanFeizi, LiSi lisi, String type) {
		super();
		this.hanFeizi = hanFeizi;
		this.lisi = lisi;
		this.type = type;
	}
	
	@Override
	public void run(){
		while(true){
			if(this.type.equals("breakfast")){
				this.lisi.update("韩非子在吃饭");
				
				this.hanFeizi.setHavingBreakfast(false);
			}else{
				if(this.hanFeizi.isHavingFun()){
					this.lisi.update("韩非子在娱乐");
					this.hanFeizi.setHavingFun(false);
				}
			}
			
		}
	}
	
}
