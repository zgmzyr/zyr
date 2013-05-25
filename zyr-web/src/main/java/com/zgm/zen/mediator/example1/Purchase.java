package com.zgm.zen.mediator.example1;

public class Purchase {

	public void buyIBMcomputer(int number){
		Stock stock = new Stock();
		
		Sale sale = new Sale();
		
		int saleStatus = sale.getSaleStatus();
		
		if(saleStatus > 80){
			System.out.println("采购IBM电脑：" + number + "台");
			
			stock.increate(number);
		}else{
			int buyNumber = number / 2;
			System.out.println("采购IBM电脑：" + buyNumber + "台");
			
			stock.increate(buyNumber);
			
		}
	}
	
	public void refuseBuyIBM(){
		System.out.println("不再采购IBM电脑!");
	}
}
