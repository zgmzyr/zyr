package com.zgm.controller.upload.HtmlUnit;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlFileInput;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;

public class UploadTest {

	
	private Server jettyServer;

	@Before
	public void before() throws Exception {
		WebAppContext webAppContext = new WebAppContext();
		webAppContext.setContextPath("/");
		webAppContext.setParentLoaderPriority(true);
		webAppContext.setResourceBase("src/test/java/com/zgm/controller/upload/HtmlUnit/webapp");

		jettyServer = new Server(7000);
		jettyServer.setHandler(webAppContext);
		jettyServer.start();
	}

	@After
	public void after() throws Exception {
		jettyServer.stop();
	}

	@Test
	public void upload() throws Exception {
		WebClient webClient = new WebClient();
//		HtmlPage page1 = webClient.getPage("http://localhost:7000/getUploadJsp");
//		HtmlPage page1 = webClient.getPage("file:/home/zgm/source/git/zyr/zyr-web/src/test/java/com/zgm/controller/upload/HtmlUnit/webapp/WEB-INF/jsp/upload.html");
		HtmlPage page1 = webClient.getPage("file:src/test/java/com/zgm/controller/upload/HtmlUnit/webapp/WEB-INF/jsp/upload.html");
		 
	    HtmlForm form = page1.getFormByName("fileForm");
	 
	    HtmlSubmitInput button = form.getInputByName("submit");
	    HtmlFileInput multipartFileInput = form.getInputByName("multipartFile");
	 
//	    multipartFileInput.setValueAttribute("/home/zgm/source/git/zyr/zyr-web/src/test/java/com/zgm/controller/upload/HtmlUnit/webapp/WEB-INF/jsp/a.txt");
	    multipartFileInput.setValueAttribute("src/test/java/com/zgm/controller/upload/HtmlUnit/webapp/WEB-INF/jsp/a.txt");
	 
	    HtmlPage page2 = button.click();	
	    

	    System.out.println(page2.getPage().asText());
//		assertEquals(textPage.getWebResponse().getStatusCode(), 200);
//		assertTrue(hasName);
	    
	    webClient.close();
	}
}
