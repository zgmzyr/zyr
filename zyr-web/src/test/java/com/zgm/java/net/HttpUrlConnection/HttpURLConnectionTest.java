package com.zgm.java.net.HttpUrlConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

public class HttpURLConnectionTest {

//	private static final Logger log = LoggerFactory.getLogger(OpenAwardController.class);
	//TODO
	private static final String GD11X5KJ_URL = "http://www.xxx.com/lottery/kc!kc11x5.jhtml?gameIndex=305";
	
	@RequestMapping(value = "/queryDrawNumber")
	@ResponseBody
	public String queryDrawNumber(@RequestParam("issueNo") String issueNo) {
		BufferedReader bufferedReader = null;
		String drawNumberJsonString = "{'drawNumber':''}";
		StringBuilder sb = new StringBuilder(800);
		try {
			URL url = new URL(GD11X5KJ_URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setUseCaches(false);
			conn.setRequestProperty("content-type", "text/json;charset=utf-8"); // TODO
			conn.connect();
			bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String temp = null;
			while ((temp = bufferedReader.readLine()) != null) {
				sb.append(temp);
			}
		} catch (IOException e) {
//			log.error("{msg:'从" + GD11X5KJ_URL + "获取广东11选五开奖结果时发生异常！'}", e);
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
//					log.error("{msg:'关闭IO时发生异常！'}");
				}
			}
		}
		
		try {
			@SuppressWarnings("unchecked")
			Map<String, Object> parseObject = JSON.parseObject(sb.toString(), Map.class);
			String realIssueNo = (String) parseObject.get("openTerm");
			if (realIssueNo.equals(issueNo)) {
				String drawNumber = (String) parseObject.get("result");
				drawNumberJsonString = "{'drawNumber':'" + drawNumber + "'}";
			}
		} catch (Throwable t) {
//			log.error("{msg:'从" + GD11X5KJ_URL + "获取广东11选五开奖结果后，解析时发生异常！'}", t);
		}
		
		return drawNumberJsonString;
	}
}
