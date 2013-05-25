/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._3_sharingObjects._3_threadConfinement._3_threadLocal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ConnectionDispenser.java $Date: Apr 16, 2013 9:35:47 AM
 *          -0400 2013
 * @since 1.0
 * 
 */
public class ConnectionDispenser {
	static String DB_URL = "jdbc:mysql://localhost/mydatabase";

	private ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
		@Override
		public Connection initialValue() {
			try {
				return DriverManager.getConnection(DB_URL);
			} catch (SQLException e) {
				throw new RuntimeException("Unable to acquire Connection, e");
			}
		};
	};

	public Connection getConnection() {
		return connectionHolder.get();
	}
	
	public static void main(String[] args) {
		ConnectionDispenser cd = new ConnectionDispenser();
		Connection connection = cd.getConnection();
	}
}
