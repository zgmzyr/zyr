package com.zgm.controller.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhouguangming 
 * 创建时间: 2014年8月6日 下午4:52:33
 */
@Controller
@RequestMapping("/user")
public class UserController {

//	@Authorization
	@RequestMapping(value = "/queryUserInfo/{id}")
	public ModelAndView queryUserInfo(@PathVariable("id") int id, @CookieValue(value = "name", required = false) String cookieValue, 
			HttpServletResponse response) {
		User user = new User();
		user.setId(id);
		user.setName("zyr");
		
//		response.addDateHeader(paramString, paramLong);
//		response.addHeader("Set-Cookie", "name1=zyr-test");
		response.addHeader("set-Cookie", "name1=zyr-test");
		response.addCookie(new Cookie("name", cookieValue + System.currentTimeMillis()));
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("user/view");
		return mv;
	}
	
	@RequestMapping(value = "/queryUserInfoNoLogin/{id}", method = RequestMethod.GET)
	public ModelAndView queryUserInfoNoLogin(@PathVariable("id") int id) {
		User user = new User();
		user.setId(id);
		user.setName("zyr");

		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("user/view");
		return mv;
	}
}
