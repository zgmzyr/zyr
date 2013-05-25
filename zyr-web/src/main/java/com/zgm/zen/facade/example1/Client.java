package com.zgm.zen.facade.example1;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ILetterProcess letterProcess = new LetterProcessImpl();
		
		letterProcess.writeContext("你好，zyr");
		letterProcess.fillEnvelope("湖南新邵陈家坊");
		letterProcess.letterInToEnvelope();
		letterProcess.sendLetter();
		
	}

}
