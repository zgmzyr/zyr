package com.zgm.tdd.fifth._2._1._1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EchoServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Content-Type", "text/plain");
		PrintWriter writer = response.getWriter();
		Enumeration<String> enumeration = request.getParameterNames();
		
		while (enumeration.hasMoreElements()) {
			String parameter =  enumeration.nextElement();
			String[] values = request.getParameterValues(parameter);
			
			for (int i = 0; i < values.length; i++) {
				writer.write(parameter + " = " + values[i]);
				writer.write("\n");
			}
					
		}
		
		writer.close();
	}
}
