package com.zgm.java.net.HttpUrlConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.StringUtil;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * 
 */
public class HttpURLConnectionTest3 {

	@Test
	public void test() {
		// final String spec =
		// "http://suggest3.sinajs.cn/suggest/type=111&key=%E6%B5%A6%E5%8F%91&name=suggestdata_1435728813537";
//		final String spec = "http://suggest3.sinajs.cn/suggest/type=111&key=银行&name=suggestdata_1435728813537";
//		final String spec = "http://suggest3.sinajs.cn/suggest/type=111&key=yh&name=suggestdata_1435728813537";
//		final String spec = "http://suggest3.sinajs.cn/suggest/type=111&key=yinhang&name=suggestdata_1435728813537";
//		final String spec = "http://suggest3.sinajs.cn/suggest/type=111&key=510050&name=suggestdata_1435728813537";
//		final String spec = "http://suggest3.sinajs.cn/suggest/type=111&key=50ETF&name=suggestdata_1435728813537";

//		final String spec = "http://suggest3.sinajs.cn/suggest/type=111&key=中航资本&name=suggestdata_1435728813537";
		final String spec = "http://suggest3.sinajs.cn/suggest/type=111&key=zhonghangziben&name=suggestdata_1435728813537";
//		final String spec = "http://suggest3.sinajs.cn/suggest/type=111&key=pfyh&name=suggestdata_1435728813537";
		
		BufferedReader bufferedReader = null;
		try {
			URL url = new URL(spec);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(10000);
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			// conn.setInstanceFollowRedirects(true);
			conn.setRequestProperty("content-type", "text/xml;charset=utf-8"); // TODO
			// conn.setRequestProperty("Accept-Charset", "GBK");
			// conn.setRequestProperty("Accept-Charset", "utf-8");
			conn.connect();
			bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "gbk"));
			String temp = null;
			StringBuilder sb = new StringBuilder(500);
			while ((temp = bufferedReader.readLine()) != null) {
				sb.append(temp);
			}

//			System.out.println(sb.toString());
//			String aa = new String(sb.subSequence(sb.indexOf("=\"")));
//			String[] stockCodeInfoArray = sb.toString().split(";");
			String substring = sb.toString().substring(sb.indexOf("=\"") + 2, sb.lastIndexOf("\";"));
			if (StringUtils.isBlank(substring)) {
				return;
			}			
			
			
			String[] stockCodeInfoArray = substring.split(";");
			List<StockCodeInfo> stockCodeInfoList = new ArrayList<>();
			if (stockCodeInfoArray != null) {
				for (String stockCodeInfoStr : stockCodeInfoArray) {
					StockCodeInfo stockCodeInfo = new StockCodeInfo();
					String[] fieldArray = stockCodeInfoStr.split(",");
					stockCodeInfo.setName(fieldArray[0]);
					stockCodeInfo.setType(fieldArray[1]);
					stockCodeInfo.setCode(fieldArray[2]);
					stockCodeInfo.setExchangeType(fieldArray[3]);
					stockCodeInfo.setExchangeName(fieldArray[4]);
					stockCodeInfo.setCode2(fieldArray[5]);
					
					stockCodeInfoList.add(stockCodeInfo);
				}
			}
			
			System.out.println(JSON.toJSONString(stockCodeInfoList));

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

class StockCodeInfo {
	private String name;
	private String type;
	private String code;
	private String exchangeType;
	private String exchangeName;
	private String code2;

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getCode() {
		return code;
	}

	public String getExchangeType() {
		return exchangeType;
	}

	public String getExchangeName() {
		return exchangeName;
	}

	public String getCode2() {
		return code2;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setExchangeType(String exchangeType) {
		this.exchangeType = exchangeType;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}
}
