package com.zgm.zen.prototype.example1;

import java.util.Random;

public class Client {

	//发送账单的最大数量
	private static int MAX_COUNT = 6;
	
	public static void main(String[] args){
		
		int i = 0;
		
		Mail mail = new Mail(new AdvTemplate());
		
		mail.setTail("xx银行版权所有");
		
		while(i < MAX_COUNT){
			mail.setAppellation(getRandString(5) + "先生（女士）");
			mail.setReceiver(getRandString(5) + "@" + getRandString(8) + ".com");
			
			sendMail(mail);
			
			i++;
		}
	}
	
	public static void sendMail(Mail mail){
		System.out.println("标题： " + mail.getSubject() + "\t收件人：" + mail.getReceiver());
		
	}
	
	public static String getRandString(int maxLength){
		String source = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder sb = new StringBuilder();
		
		Random rand = new Random();
		
		for(int i = 0; i < maxLength; i++){
			sb.append(source.charAt(rand.nextInt(source.length())));
		}
		
		return sb.toString();
	}
}
