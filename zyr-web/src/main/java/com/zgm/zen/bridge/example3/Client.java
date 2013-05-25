package com.zgm.zen.bridge.example3;

public class Client {

	public static void main(String[] args) {
		
		House house = new House();
		System.out.println("-------房地产公司是这样运行的------");
		
		HouseCorp houseCorp = new HouseCorp(house);
		houseCorp.makeMoney();
		
		System.out.println("\n");
		
		/*System.out.println("-----------服装公司是这样运行的---------");
		ClothesCorp clothesCorp = new ClothesCorp();
		clothesCorp.makeMoney();*/
		
		System.out.println("-------山寨公司是这样运行的------");
//		IPodCorp iPodCorp = new IPodCorp();
//		iPodCorp.makeMoney();
		ShanZhaiCorp shanZhaiCorp = new ShanZhaiCorp(new IPod());
		shanZhaiCorp.makeMoney();
	}
	/*public static void main(String[] args) {
		
		System.out.println("-------房地产公司是这样运行的------");
		
		HouseCorp houseCorp = new HouseCorp();
		houseCorp.makeMoney();
		
		System.out.println("\n");
		
		System.out.println("-----------服装公司是这样运行的---------");
		ClothesCorp clothesCorp = new ClothesCorp();
		clothesCorp.makeMoney();
		
		System.out.println("-------山寨公司是这样运行的------");
		IPodCorp iPodCorp = new IPodCorp();
		iPodCorp.makeMoney();
	}*/

}
