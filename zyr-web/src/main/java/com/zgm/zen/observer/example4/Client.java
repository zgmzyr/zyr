package com.zgm.zen.observer.example4;
import java.util.Observer;

/**
 * 使用JDK中的Observer和Observable
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) throws Exception{
		
//		LiSi lisi = new LiSi();
		/*HanFeizi hanFeizi = new HanFeizi();
		

		hanFeizi.haveBreakfast();
		hanFeizi.haveFun();*/
		
		Observer lisi = new LiSi();
		Observer wangsi = new WangSi();
		Observer liusi = new LiuSi();
		
		HanFeizi hanFeizi = new HanFeizi();
		hanFeizi.addObserver(lisi);
		hanFeizi.addObserver(wangsi);
		hanFeizi.addObserver(liusi);
		
		hanFeizi.haveBreakfast();
		
	}

	/*public static void main(String[] args) throws Exception{
		
//		LiSi lisi = new LiSi();
		HanFeizi hanFeizi = new HanFeizi();
		

		hanFeizi.haveBreakfast();
		hanFeizi.haveFun();
		
		Observer lisi = new LiSi();
		Observer wangsi = new WangSi();
		Observer liusi = new LiuSi();
		
		HanFeizi hanFeizi = new HanFeizi();
		hanFeizi.addOberver(lisi);
		hanFeizi.addOberver(wangsi);
		hanFeizi.addOberver(liusi);
		
		hanFeizi.haveBreakfast();
		
	}*/
	


	
}
