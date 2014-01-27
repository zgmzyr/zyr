/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * 
 */
package com.zgm.howTomcatWorks._2_simple_servlet_container._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;

import com.zgm.howTomcatWorks._2_simple_servlet_container._1.Request;

/**
 * 
 * @author 周光明
 * @version $FileName: RequestFacade.java $Date: 2013-7-21 下午3:55:12 -0400 2013
 * @since 1.0
 * 
 */
public class RequestFacade implements ServletRequest {

	private ServletRequest request = null;

	public RequestFacade(Request request) {
		this.request = request;
	}

	/* implementation of the ServletRequest */
	public Object getAttribute(String attribute) {
		return request.getAttribute(attribute);
	}

	public Enumeration getAttributeNames() {
		return request.getAttributeNames();
	}

	public String getRealPath(String path) {
		return request.getRealPath(path);
	}

	public RequestDispatcher getRequestDispatcher(String path) {
		return request.getRequestDispatcher(path);
	}

	public boolean isSecure() {
		return request.isSecure();
	}

	public String getCharacterEncoding() {
		return request.getCharacterEncoding();
	}

	public int getContentLength() {
		return request.getContentLength();
	}

	public String getContentType() {
		return request.getContentType();
	}

	public ServletInputStream getInputStream() throws IOException {
		return request.getInputStream();
	}

	public Locale getLocale() {
		return request.getLocale();
	}

	public Enumeration getLocales() {
		return request.getLocales();
	}

	public String getParameter(String name) {
		return request.getParameter(name);
	}

	public Map getParameterMap() {
		return request.getParameterMap();
	}

	public Enumeration getParameterNames() {
		return request.getParameterNames();
	}

	public String[] getParameterValues(String parameter) {
		return request.getParameterValues(parameter);
	}

	public String getProtocol() {
		return request.getProtocol();
	}

	public BufferedReader getReader() throws IOException {
		return request.getReader();
	}

	public String getRemoteAddr() {
		return request.getRemoteAddr();
	}

	public String getRemoteHost() {
		return request.getRemoteHost();
	}

	public String getScheme() {
		return request.getScheme();
	}

	public String getServerName() {
		return request.getServerName();
	}

	public int getServerPort() {
		return request.getServerPort();
	}

	public void removeAttribute(String attribute) {
		request.removeAttribute(attribute);
	}

	public void setAttribute(String key, Object value) {
		request.setAttribute(key, value);
	}

	public void setCharacterEncoding(String encoding)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding(encoding);
	}

	@Override
	public String getLocalAddr() {
		//TODO
		return null;
	}

	@Override
	public String getLocalName() {
		//TODO
		return null;
	}

	@Override
	public int getLocalPort() {
		//TODO
		return 0;
	}

	@Override
	public int getRemotePort() {
		//TODO
		return 0;
	}

}
