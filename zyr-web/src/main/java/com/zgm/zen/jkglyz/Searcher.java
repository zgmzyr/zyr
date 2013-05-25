package com.zgm.zen.jkglyz;

public class Searcher extends AbstractSearcher{

	public Searcher(IGreatTemperamentGirl greatTemperamentGirl){
		super(greatTemperamentGirl);
	}
	
	public Searcher(IGoodBodyGirl goodBodyGirl){
		super(goodBodyGirl);
	}
	
	public void show(){
		if(goodBodyGirl != null){
			goodBodyGirl.goodLooking();
			goodBodyGirl.niceFigure();
		}
		
		if(greatTemperamentGirl != null){
			greatTemperamentGirl.greatTemperament();
		}
	}
}
