package com.zgm.zen.facade.example1;

public interface ILetterProcess {

	public void writeContext(String context);
	
	public void fillEnvelope(String address);
	
	public void letterInToEnvelope();
	
	public void sendLetter();
}
