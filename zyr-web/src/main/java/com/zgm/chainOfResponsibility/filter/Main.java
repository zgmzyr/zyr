package com.zgm.chainOfResponsibility.filter;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] strs){
		String msg = ":)这是一个敏感的话题，<script>";
		
		HtmlFilter hf = new HtmlFilter();
		SensitiveFilter sensitiveFilter = new SensitiveFilter();
		
		
		FilterChain filterChain = new FilterChain();
		filterChain.addFilter(hf)
				   .addFilter(sensitiveFilter);	
		
		FilterChain fc2 = new FilterChain();
		fc2.addFilter(new FaceFilter());
		filterChain.addFilter(fc2);
		msg = filterChain.doFilter(msg);
		
		System.out.println(msg);
		
		
		
	}
}
