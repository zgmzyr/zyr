package com.zgm.controller.upload.HtmlUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringMvcUploadController {

	@RequestMapping("/getUploadJsp")
	public ModelAndView getUploadJsp(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
//		mv.addObject("user", user);
		mv.setViewName("upload");
		return mv;
	}
	
	@RequestMapping("/upload")
	public void upload(HttpServletRequest request, @RequestParam(value = "multipartFile", required = true) MultipartFile multipartFile,
			Model model) throws Exception {
		
		System.out.println(multipartFile.getContentType());
		System.out.println(multipartFile.getName());
		System.out.println(multipartFile.getOriginalFilename());
		System.out.println(multipartFile.getSize());
		System.out.println(multipartFile.getInputStream());
		System.out.println(multipartFile.getBytes());
		
	}
	
	
	
}
