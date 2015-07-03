package com.zgm.java.net.HttpUrlConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * 
 */
public class HttpURLConnectionTest2 {

	@Test
	public void test() {
		final String spec = "http://kaijiang.500.com/static/info/kaijiang/xml/pls/list.xml";
		BufferedReader bufferedReader = null;
		try {
			URL url = new URL(spec);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			// conn.setInstanceFollowRedirects(true);
			conn.setRequestProperty("content-type", "text/xml;charset=utf-8"); // TODO
			conn.connect();
			bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String temp = null;
			int count = 0;
			while ((temp = bufferedReader.readLine()) != null) {
				count++;
				if (count == 3) {
					System.out.println(temp);
					break;
				}
			}

			temp = temp.trim();
			int a = temp.indexOf("expect=");
			int b = temp.indexOf("\" opencode=\"");
			int c = temp.indexOf("\" opentime=\"");
			int d = temp.indexOf("\" />");
			String currentissueNo = temp.substring(a + 8, b);
			String resultNo = temp.substring(b + 12, c);
			String openTime = temp.substring(c + 12, d);

			System.out.println(currentissueNo);
			System.out.println(resultNo);
			System.out.println(openTime);
		} catch (IOException e) {
			// TODO
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
				}
			}
		}
	}
	
	@Test
	public void test2() {
		final String spec = "http://www.aicai.com/lottery/kc!kc11x5.jhtml?gameIndex=305";
		BufferedReader bufferedReader = null;
		try {
			URL url = new URL(spec);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setUseCaches(false);
			conn.setDoInput(true);
			// conn.setInstanceFollowRedirects(true);
			conn.setRequestProperty("content-type", "text/json;charset=utf-8"); // TODO
			conn.connect();
			bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String temp = null;
			int count = 0;
			StringBuilder sb = new StringBuilder(800);
			while ((temp = bufferedReader.readLine()) != null) {
				sb.append(temp);
			}
			
			System.out.println(sb);
			
			@SuppressWarnings("unchecked")
			Map<String, Object> parseObject = JSON.parseObject(sb.toString(), Map.class);
			System.out.println(parseObject);
			String drawNumber = (String) parseObject.get("result");
			System.out.println("{'drawNumber':'" + drawNumber + "'}");
			System.out.println(JSON.toJSONString(drawNumber, false));
			System.out.println(JSON.parse(drawNumber));
			

		} catch (IOException e) {
			// TODO
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
				}
			}
		}
	}
}
