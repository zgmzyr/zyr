package com.zgm.controller.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.http.Part;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

public class SpringMvcUploadTest {

	@Test
	public void upload() throws Exception {
		MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		request.setRequestURI("/upload");
		JSONObject obj = new JSONObject();
		byte[] aa = new byte[1];
		aa[0] = 1;
//		obj.put("avatar", aa);
//		obj.put("authType", "0");
//		obj.put("validateCode", "3265");
//		request.addParameter("buzz", obj.toJSONString());
//		MultipartFile file;
//		request.addFile(file);
		Part part = new ZyrPart();
		request.addPart(part);//.addParameter("avatar", aa);
//		request.addFile(file);
		request.setMethod("POST");
//		request.setContentType("multipart/form-data");
		// 执行URI对应的action
		
		
//		final ModelAndView mav = this.excuteAction(request, response);
//		logger.info(((JSONMessage) (mav.getModelMap().get("ro"))).toJSONString());
//		logger.info(((mav.getModelMap().get("code"))).toString());
	}
	
	public void upload2() {
		
	}
	
	
	static class ZyrPart implements Part {

		@Override
		public InputStream getInputStream() throws IOException {
			return new FileInputStream(new File("/home/zgm/share/work/cg/avatar"));
		}

		@Override
		public String getContentType() {
			// TODO Auto-generated method stub
			return "multipart/form-data";
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "avatar";
		}

//		@Override
//		public String getSubmittedFileName() {
			// TODO Auto-generated method stub
//			return "avatar";
//		}

		@Override
		public long getSize() {
			// TODO Auto-generated method stub
			return 1000;
		}

		@Override
		public void write(String fileName) throws IOException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete() throws IOException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getHeader(String name) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Collection<String> getHeaders(String name) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Collection<String> getHeaderNames() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
