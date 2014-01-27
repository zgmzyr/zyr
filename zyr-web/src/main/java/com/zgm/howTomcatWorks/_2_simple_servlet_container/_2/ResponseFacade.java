/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * 
 */
package com.zgm.howTomcatWorks._2_simple_servlet_container._2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

import com.zgm.howTomcatWorks._2_simple_servlet_container._1.Response;

/**
 * 
 * @author 周光明
 * @version $FileName: ResponseFacade.java $Date: 2013-7-21 下午3:55:37 -0400 2013
 * @since 1.0
 * 
 */
public class ResponseFacade implements ServletResponse {

	private ServletResponse response;

	public ResponseFacade(Response response) {
		this.response = response;
	}

	public void flushBuffer() throws IOException {
		response.flushBuffer();
	}

	public int getBufferSize() {
		return response.getBufferSize();
	}

	public String getCharacterEncoding() {
		return response.getCharacterEncoding();
	}

	public Locale getLocale() {
		return response.getLocale();
	}

	public ServletOutputStream getOutputStream() throws IOException {
		return response.getOutputStream();
	}

	public PrintWriter getWriter() throws IOException {
		return response.getWriter();
	}

	public boolean isCommitted() {
		return response.isCommitted();
	}

	public void reset() {
		response.reset();
	}

	public void resetBuffer() {
		response.resetBuffer();
	}

	public void setBufferSize(int size) {
		response.setBufferSize(size);
	}

	public void setContentLength(int length) {
		response.setContentLength(length);
	}

	public void setContentType(String type) {
		response.setContentType(type);
	}

	public void setLocale(Locale locale) {
		response.setLocale(locale);
	}

	@Override
	public String getContentType() {
		// TODO
		return null;
	}

	@Override
	public void setCharacterEncoding(String arg0) {
		// TODO

	}

}
