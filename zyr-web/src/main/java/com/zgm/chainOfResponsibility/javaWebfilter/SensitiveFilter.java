package com.zgm.chainOfResponsibility.javaWebfilter;

public class SensitiveFilter implements Filter {

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		
		String str = request.getRequestStr().replace("敏感", "不敏感");
		request.setRequestStr(str + "request doFilter by SensitiveFilter");
		
		chain.doFilter(request, response, chain);
		
		response.setResponseStr("response dofilter by Sensitivefilter");
	}

}
