/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.ninth_classLoader._4.isolation._3_version;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ServiceConsumer.java $Date: 2013-3-27 下午9:19:32 -0400
 *          2013
 * @since 1.0
 * 
 */
public class ServiceConsumer {
	public void consume() throws Exception {
		String serviceName = "com.zgm.understandingTheJava7.ninth_classLoader._4.isolation._3_version.impl.SampleService";
		Versionized v1 = ServiceFactory.getService(serviceName, "version1");
		Versionized v2 = ServiceFactory.getService(serviceName, "version2");
		System.out.println(v1.getVersion());
		System.out.println(v2.getVersion());
	}

	public static void main(String[] args) throws Exception {
		ServiceConsumer sc = new ServiceConsumer();
		sc.consume();
	}
}
