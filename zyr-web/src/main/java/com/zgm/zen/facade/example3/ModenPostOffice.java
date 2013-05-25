package com.zgm.zen.facade.example3;

public class ModenPostOffice {

	private ILetterProcess letterProcess = new LetterProcessImpl();
	private Police letterPolice = new Police();
	
	public void sendLetter(String context, String address){
		letterProcess.writeContext("你好，zyr");
		letterProcess.fillEnvelope("湖南新邵陈家坊");
		
		letterPolice.checkLetter(letterProcess);
		
		letterProcess.letterInToEnvelope();
		letterProcess.sendLetter();
	}
}

/*public class ModenPostOffice {

	private ILetterProcess letterProcess = new LetterProcessImpl();
	
	public void sendLetter(String context, String address){
		letterProcess.writeContext("你好，zyr");
		letterProcess.fillEnvelope("湖南新邵陈家坊");
		letterProcess.letterInToEnvelope();
		letterProcess.sendLetter();
	}
}*/
