package com.zgm.chainOfResponsibility.filter;

public class SensitiveFilter implements Filter {

	@Override
	public String doFilter(String msg) {
		
		msg = msg.replace("敏感", "不敏感");
		
		return msg;
	}

}
