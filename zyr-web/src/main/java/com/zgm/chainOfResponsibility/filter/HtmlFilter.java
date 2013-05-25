package com.zgm.chainOfResponsibility.filter;

public class HtmlFilter implements Filter {

	@Override
	public String doFilter(String msg) {
		
		msg = msg.replace("<", "[")
				 .replace(">", "]");
		
		return msg;
	}

}
