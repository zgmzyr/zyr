package com.zgm.zen.bridge.example1;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("-------房地产公司是这样运行的------");
		
		HouseCorp houseCorp = new HouseCorp();
		houseCorp.makeMoney();
		
		System.out.println("\n");
		
		System.out.println("-----------服装公司是这样运行的---------");
		ClothesCorp clothesCorp = new ClothesCorp();
		clothesCorp.makeMoney();
		
	}

}
