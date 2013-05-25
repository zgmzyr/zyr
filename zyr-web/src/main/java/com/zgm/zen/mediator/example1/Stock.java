package com.zgm.zen.mediator.example1;

public class Stock {

	private static int COMPUTER_NUMBER = 100;
	
	public void increate(int number){
		COMPUTER_NUMBER = COMPUTER_NUMBER + number; 
	}
	
	public void decrease(int number){
		COMPUTER_NUMBER = COMPUTER_NUMBER - number;
	}
	
	public int getStockNumber(){
		return COMPUTER_NUMBER;
	}
	
	public void clearStock(){
		Purchase purchase = new Purchase(); //不符合迪米特法则
		Sale sale = new Sale();				//不符合迪米特法则
		
		System.out.println("清理存货数量为：" + COMPUTER_NUMBER + "台");
		
		sale.offSale();
		
		purchase.refuseBuyIBM();
	}
}
