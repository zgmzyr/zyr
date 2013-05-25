package com.zgm.chainOfResponsibility.javaWebfilter;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] strs){
		String msg = ":)这是一个敏感的话题，<script>";
		Request request = new Request();
		Response response = new Response();
		request.setRequestStr(msg);
		response.setResponseStr("response: ");
		
		HtmlFilter hf = new HtmlFilter();
		SensitiveFilter sensitiveFilter = new SensitiveFilter();
		
		
		FilterChain filterChain = new FilterChain();
		filterChain.addFilter(hf)
				   .addFilter(sensitiveFilter);	
		
		filterChain.doFilter(request, response, filterChain);
		
		System.out.println(msg);
		
		
		
	}
}
