package com.zgm.chainOfResponsibility.javaWebfilter;

public class HtmlFilter implements Filter {

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		
		String str = request.getRequestStr().replace("<", "[").replace(">", "]");
		request.setRequestStr(str + "request doFilter by HtmlFilter");
		
		chain.doFilter(request, response, chain);
		
		response.setResponseStr("response dofilter by Htmlfilter");
	}

}
