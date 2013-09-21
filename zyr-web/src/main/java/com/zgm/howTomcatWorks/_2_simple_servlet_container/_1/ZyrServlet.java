/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * 
 */
package com.zgm.howTomcatWorks._2_simple_servlet_container._1;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * @author 周光明
 * @version $FileName: ZyrServlet.java $Date: 2013-7-21 下午3:38:20 -0400 2013
 * @since 1.0
 * 
 */
public class ZyrServlet implements Servlet {

	@Override
	public void destroy() {
		//TODO

	}

	@Override
	public ServletConfig getServletConfig() {
		//TODO
		return null;
	}

	@Override
	public String getServletInfo() {
		//TODO
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		//TODO

	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {

		System.out.println("zyr servlet 执行了！");
	}

}
