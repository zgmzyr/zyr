
package com.zgm.zen.facade.example2;

public class LetterProcessImpl implements ILetterProcess {

	@Override
	public void fillEnvelope(String address) {
		System.out.println("填写收件人的地址及姓名。。。。" +address);
		
	}

	@Override
	public void letterInToEnvelope() {
		System.out.println("把信放到信封中。。。。");
	}

	@Override
	public void sendLetter() {
		System.out.println("邮递信件。。。。");
	}

	@Override
	public void writeContext(String context) {
		System.out.println("填写信的内容。。。。" + context);
	}

}
