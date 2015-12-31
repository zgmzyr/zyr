package com.zgm.javax.servlet.ServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class ServletRequestTest {
	MockHttpServletRequest request;
	MockHttpServletResponse response;
	
	@Before
	public void before() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
	}
	
	@Test
	public void test() {
		String agentId = "232762";
		request.setRequestURI("/a.jsp");
		String serverName = "www.zyr.com";
		request.setServerName(serverName);
		request.setQueryString("agentId=" + agentId);
//		request.addParameter(AgentIdWebUtils.PARAM_AGENT_ID, agentId);
		String remoteAddr = "192.168.70.64";
		request.setRemoteAddr(remoteAddr);
//		request.getServletContext().setAttribute(MultiDomainConfigConstant.KEY_CURRENT_DOMAIN_PARTNER, Partner.SINA.getName());
		
		
		System.out.println(request.getRequestURL());
		System.out.println(request.getRequestURI());
//		assertTrue(result != null);
//		assertEquals(serverName, result.getIpInfo());
//		assertEquals(remoteAddr, result.getOperIp());
//		assertEquals(Long.valueOf(agentId).longValue(), result.getSellChannel().longValue());
	}
}
