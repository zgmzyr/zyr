package com.zgm.chainOfResponsibility.javaWebfilter;

public interface Filter {
	public void doFilter(Request request, Response response, FilterChain chain);
}
