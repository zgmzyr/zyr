package com.zgm.chainOfResponsibility.filter;

public class FaceFilter implements Filter {

	@Override
	public String doFilter(String msg) {
		
		msg = msg.replace(":)", "^V^");
		
		return msg;
	}

}
