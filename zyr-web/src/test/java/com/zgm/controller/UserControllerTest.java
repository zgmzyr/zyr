package com.zgm.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author zhouguangming
 * 创建时间: 2014年8月7日 下午3:10:55
 */
public class UserControllerTest {
	
	private MockMvc mockMvc;  
    @Before  
    public void setUp() {  
        UserController userController = new UserController();  
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();  
    }  

    @Test
    public void queryUserInfo() throws Exception {
    	MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user/queryUserInfo/1"))  
                .andExpect(MockMvcResultMatchers.view().name("user/view"))  
                .andExpect(MockMvcResultMatchers.model().attributeExists("user"))  
                .andDo(MockMvcResultHandlers.print())  
                .andReturn();  
          
        Assert.assertNotNull(result.getModelAndView().getModel().get("user")); 
    }
}
