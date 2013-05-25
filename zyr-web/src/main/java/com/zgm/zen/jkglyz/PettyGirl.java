package com.zgm.zen.jkglyz;

public class PettyGirl implements IGoodBodyGirl, IGreatTemperamentGirl {
	
	private String name;
	
	public PettyGirl(String name){
		this.name = name;
	}
	
	@Override
	public void goodLooking() {
		System.out.println(this.name + "---脸蛋很漂亮！");
	}

	@Override
	public void niceFigure() {
		System.out.println(this.name + "---身材很棒！");
	}

	@Override
	public void greatTemperament() {
		System.out.println(this.name + "---气质非常好！");
	}

}
