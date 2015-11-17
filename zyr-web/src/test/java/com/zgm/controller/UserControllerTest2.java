package com.zgm.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author zhouguangming 
 * 创建时间: 2014年8月7日 下午3:10:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/test/webapp") //TODO
@ContextHierarchy({
//		@ContextConfiguration(name = "parent", locations = "classpath:webCommonConfig/spring-context.xml"),
//		@ContextConfiguration(name = "child", locations = "classpath:webCommonConfig/spring-mvc.xml")
		@ContextConfiguration(name = "parent", locations = "classpath:com/zgm/controller/spring-context.xml"),
		@ContextConfiguration(name = "child", locations = "classpath:com/zgm/controller/spring-mvc.xml")
})
public class UserControllerTest2 {

	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void queryUserInfoNoLogin() throws Exception {
		mockMvc
				.perform(MockMvcRequestBuilders.get("/user/queryUserInfoNoLogin/1"))
				.andExpect(MockMvcResultMatchers.view().name("user/view"))
				.andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/jsp/user/view.jsp"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("user"))
				.andExpect(MockMvcResultMatchers.content().string(Matchers.contains("zyr2")))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

}
