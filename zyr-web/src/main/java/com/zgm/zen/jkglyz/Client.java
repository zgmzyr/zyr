package com.zgm.zen.jkglyz;

public class Client {

	public static void main(String[] args){
		IGreatTemperamentGirl greatTemperamentGirl = new PettyGirl("石青璇");
		IGoodBodyGirl goodBodyGirl = new PettyGirl("师妃暄");
		
		AbstractSearcher searcher = new Searcher(greatTemperamentGirl);
		AbstractSearcher searcher2 = new Searcher(goodBodyGirl);
		
		searcher.show();
		searcher2.show();
		
	}
}
