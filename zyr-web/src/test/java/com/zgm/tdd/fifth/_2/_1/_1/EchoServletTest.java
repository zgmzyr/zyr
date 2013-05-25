package com.zgm.tdd.fifth._2._1._1;

import java.io.IOException;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class EchoServletTest {

	@Test
	public void testEchoingParametersWithMultipleValues() throws IOException {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		request.setParameter("p1", "value1");
		request.setParameter("p2", "value2");
		
		EchoServlet servlet = new EchoServlet();
		servlet.doGet(request, response);
		
		String[] lines = response.getContentAsString().split("\n");
		
		org.junit.Assert.assertEquals("长度不相符", 2, lines.length);
		org.junit.Assert.assertEquals("p1 = value1", lines[0]);
		org.junit.Assert.assertEquals("p2 = value2", lines[1]);
		
		
	}
}
