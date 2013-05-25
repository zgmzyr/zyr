package com.zgm.zen.builder.example3;

import java.util.ArrayList;

public class Director {

	private ArrayList<String> sequence = new ArrayList<String>();
	
	private BenzBuilder benzBuilder = new BenzBuilder();
	private BMWBuilder bmwBuilder = new BMWBuilder();
	
	public BenzModel getABenzModel(){
		
		this.sequence.clear();
		
		this.sequence.add("start");
		this.sequence.add("stop");
		
		this.benzBuilder.setSequence(sequence);
		
		return (BenzModel) this.benzBuilder.getCarModel();
	}
	
	public BenzModel getBBenzModel(){
		
		this.sequence.clear();
		
		this.sequence.add("start");
		this.sequence.add("alarm");
		this.sequence.add("stop");
		
		this.benzBuilder.setSequence(sequence);
		
		return (BenzModel) this.benzBuilder.getCarModel();
	}
	
	public BMWModel getABMWModel(){
		this.sequence.clear();
		
		this.sequence.add("start");
		this.sequence.add("stop");
		
		this.bmwBuilder.setSequence(sequence);
		
		return (BMWModel) this.bmwBuilder.getCarModel();
	}
	
	public BMWModel getBBMWModel(){
		this.sequence.clear();
		
		this.sequence.add("start");
		this.sequence.add("alarm");
		this.sequence.add("stop");
		
		this.bmwBuilder.setSequence(sequence);
		
		return (BMWModel) this.bmwBuilder.getCarModel();
	}
}
