package com.zgm.zen.builder.example2;

import java.util.ArrayList;

public class BMWBuilder extends CarBuilder{

	private BMWModel bmw = new BMWModel();
	
	public CarModel getCarModel(){
		return this.bmw;
	}
	
	public void setSequence(ArrayList<String> sequence){
		this.bmw.setSequence(sequence);
	}
}
