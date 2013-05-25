/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._2_thread_safety._2_3_compoundActions;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: CountingFactorizer.java $Date: Apr 12, 2013 11:02:12 AM
 *          -0400 2013
 * @since 1.0
 * 
 */
public class CountingFactorizer implements Servlet {
	private final AtomicLong count = new AtomicLong(0);

	public long getCount() {
		return count.get();
	}

	public void service(ServletRequest req, ServletResponse resp) {
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = factor(i);
		count.incrementAndGet();
		encodeIntoResponse(resp, factors);
	}

	void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {
	}

	BigInteger extractFromRequest(ServletRequest req) {
		return null;
	}

	BigInteger[] factor(BigInteger i) {
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
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
	public void destroy() {
		//TODO
		
	}
}
