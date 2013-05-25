package com.zgm.zen.facade.example2;

public class Client {

	
	public static void main(String[] args) {
		
		ModenPostOffice postOffice = new ModenPostOffice();
		
		String address = "湖南新邵陈家坊";
		String context = "你好，zyr";
		
		postOffice.sendLetter(context, address);
		
		/*ILetterProcess letterProcess = new LetterProcessImpl();
		
		letterProcess.writeContext("你好，zyr");
		letterProcess.fillEnvelope("湖南新邵陈家坊");
		letterProcess.letterInToEnvelope();
		letterProcess.sendLetter();*/
		
	}
	
	/*public static void main(String[] args) {
		
		ILetterProcess letterProcess = new LetterProcessImpl();
		
		letterProcess.writeContext("你好，zyr");
		letterProcess.fillEnvelope("湖南新邵陈家坊");
		letterProcess.letterInToEnvelope();
		letterProcess.sendLetter();
		
	}*/

}
