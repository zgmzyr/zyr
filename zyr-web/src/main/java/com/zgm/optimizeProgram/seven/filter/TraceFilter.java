package com.zgm.optimizeProgram.seven.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class TraceFilter implements Filter {

	ServletContext context = null;
	
	public void init(FilterConfig filterConfig){
		context = filterConfig.getServletContext();
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		
//		context.log("[" + request.getRemoteHost() + "] request: " + ((HttpServletRequest) request).getRequestURI() );
		context.log("[" + request.getRemoteHost() + "] request: " + ((HttpServletRequest) request).getRequestURL() );
		
		chain.doFilter(request, response );
		
		context.log("[" + request.getRemoteHost() + "] 完成！");
		System.out.println("sdfdslfjdfld");
	}
	
	public void destroy(){
		context = null;
	}
}
