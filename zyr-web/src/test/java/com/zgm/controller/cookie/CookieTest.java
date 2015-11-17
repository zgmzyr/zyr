package com.zgm.controller.cookie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;
import com.gargoylesoftware.htmlunit.util.NameValuePair;

/**
 * @author zhouguangming 
 * 创建时间: 2014年9月1日 下午7:28:29
 */
public class CookieTest {
	private Server jettyServer;

	@Before
	public void before() throws Exception {
		WebAppContext webAppContext = new WebAppContext();
		webAppContext.setContextPath("/");
		webAppContext.setParentLoaderPriority(true);
		webAppContext.setResourceBase("src/test/java/com/zgm/controller/cookie/webapp");

		jettyServer = new Server(7000);
		jettyServer.setHandler(webAppContext);
		jettyServer.start();
	}

	@After
	public void after() throws Exception {
		jettyServer.stop();
	}

	@Test
	public void test() throws Exception {
		String cookieName = "name";
		WebClient webClient = new WebClient();
		webClient.getCookieManager().addCookie(new Cookie("localhost", cookieName, "zyr"));
		webClient.getOptions().setTimeout(0);
//		TextPage textPage = webClient.getPage("http://localhost:7000/user/queryUserInfo/1");
		HtmlPage textPage = webClient.getPage("http://localhost:7000/user/queryUserInfo/1");
		List<NameValuePair> responseHeaders = textPage.getWebResponse().getResponseHeaders();

		boolean hasName = false;
		for (NameValuePair header : responseHeaders) {
			if (!header.getName().equalsIgnoreCase("Set-Cookie")) {
				continue;
			}
			
			String value = header.getValue();
			if (value.contains(cookieName)) {
				hasName = true;
//			} else if (value.contains(AgentIdWebUtils.COOKIE_AGENTID_NAME)) {
//			} else if (value.contains(AgentIdWebUtils.COOKIE_AGENTID_NAME)) {
//				hasAgentid = true;
			}
		}
		
//		String pageContent = htmlPage.getBody().getTextContent().trim();

		assertEquals(textPage.getWebResponse().getStatusCode(), 200);
		assertTrue(hasName);
	}
}
