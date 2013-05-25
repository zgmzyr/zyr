package com.zgm.zen.mediator.example2;

public class Client {

	/*public static void main(String[] args){
		//采购人员采购电脑
		System.out.println("---采购人员采购电脑----");
		Purchase purchase = new Purchase();
		purchase.buyIBMcomputer(100);
		
		//销售人员销售电脑
		System.out.println("---销售人员销售电脑----");
		Sale sale = new Sale();
		sale.sellIBMComputer(1);
		
		//库房人员管理库存
		System.out.println("---库房人员清理库存----");
		Stock stock = new Stock();
		stock.clearStock();
		
	}*/
	
	public static void main(String[] args){
		
		AbstractMediator mediator = new Mediator();
		
		//采购人员采购电脑
		System.out.println("---采购人员采购电脑----");
		Purchase purchase = new Purchase(mediator);
		purchase.buyIBMcomputer(100);
		
		//销售人员销售电脑
		System.out.println("---销售人员销售电脑----");
		Sale sale = new Sale(mediator);
		sale.sellIBMComputer(1);
		
		//库房人员管理库存
		System.out.println("---库房人员清理库存----");
		Stock stock = new Stock(mediator);
		stock.clearStock();
		
	}
}
