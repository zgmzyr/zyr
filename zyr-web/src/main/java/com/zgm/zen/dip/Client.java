package com.zgm.zen.dip;

import com.zgm.zen.dip.jiekou.IDriver;

public class Client {
	public static void main(String[] args){
		IDriver zgm = new Driver();
		
		zgm.drive(new Benz());
		
		//
		zgm.drive(new BMW());
	}
}
