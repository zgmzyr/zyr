/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * 
 */
package com.zgm.howTomcatWorks._3_connector;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import javax.servlet.Servlet;

import com.zgm.howTomcatWorks._2_simple_servlet_container._1.Constants;
import com.zgm.howTomcatWorks._3_connector.connector.http.HttpRequest;
import com.zgm.howTomcatWorks._3_connector.connector.http.HttpRequestFacade;
import com.zgm.howTomcatWorks._3_connector.connector.http.HttpResponse;
import com.zgm.howTomcatWorks._3_connector.connector.http.HttpResponseFacade;

/**
 * 
 * @author 周光明
 * @version $FileName: ServletProcessor.java $Date: 2013-7-22 下午9:33:26 -0400 2013
 * @since 1.0
 * 
 */
public class ServletProcessor {

	  public void process(HttpRequest request, HttpResponse response) {

	    String uri = request.getRequestURI();
	    String servletName = uri.substring(uri.lastIndexOf("/") + 1);
	    URLClassLoader loader = null;
	    try {
	      // create a URLClassLoader
	      URL[] urls = new URL[1];
	      URLStreamHandler streamHandler = null;
	      File classPath = new File(Constants.WEB_ROOT);
	      String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString() ;
	      urls[0] = new URL(null, repository, streamHandler);
	      loader = new URLClassLoader(urls);
	    }
	    catch (IOException e) {
	      System.out.println(e.toString() );
	    }
	    Class myClass = null;
	    try {
	      myClass = loader.loadClass(servletName);
	    }
	    catch (ClassNotFoundException e) {
	      System.out.println(e.toString());
	    }

	    Servlet servlet = null;

	    try {
	      servlet = (Servlet) myClass.newInstance();
	      HttpRequestFacade requestFacade = new HttpRequestFacade(request);
	      HttpResponseFacade responseFacade = new HttpResponseFacade(response);
	      servlet.service(requestFacade, responseFacade);
	      ((HttpResponse) response).finishResponse();
	    }
	    catch (Exception e) {
	      System.out.println(e.toString());
	    }
	    catch (Throwable e) {
	      System.out.println(e.toString());
	    }
	  }
	}
