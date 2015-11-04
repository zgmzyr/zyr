package com.zgm.org.apache.http.impl.clinet.CloseableHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.script.ScriptEngineTest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class CloseableHttpClientTest2 {
	
	private static String cookie = "JSESSIONID=bacAcyY5Yccrd4f6yTQbv";
	
	@Test
	public void test() throws UnsupportedOperationException, IOException {
		this.getUrlTitle("trade.cgws.com", "https://trade.cgws.com/cgi-bin/user/Login");
	}

	public String getUrlTitle(String domain, String url) throws UnsupportedOperationException, IOException {

		
		URI uri = null;
		try {
			uri = new URI(url);
		} catch (URISyntaxException ex) {
			String msg = "{url:'" + url + "',description:'url invalid'}";
//			throw new CompleteUrlPatternTitleException(msg, ex);
		}

		String title = "";

		// 设置Socket最大等待时间、连接最大等待时间)
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5 * 1000)
				.setConnectionRequestTimeout(5 * 1000).setSocketTimeout(5 * 1000).build();

		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
		// 设置连接池属性
		connManager.setMaxTotal(200); // Increase max total connection to 200
		connManager.setDefaultMaxPerRoute(20); // Increase default max
												// connection per route to 20
//		 connManager.setMaxPerRoute(new HttpRoute(new HttpHost("www.aicai.com", 80)), 50);
//		 Increase max connections for host to 50
		connManager.setMaxPerRoute(new HttpRoute(new HttpHost(domain, 80)), 50);

		CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(connManager)
				.setDefaultRequestConfig(requestConfig).build();

//		HttpUriRequest httpRequest = RequestBuilder.get().setUri(uri).build();
		HttpUriRequest httpRequest = RequestBuilder.post().setUri(uri).build();
		CloseableHttpResponse response = null;

		try {

			HttpParams param = new BasicHttpParams();
			param.setParameter("password", ScriptEngineTest.getPass());
			param.setParameter("password_Controls", "normal");
			param.setParameter("type", "Z");
			param.setParameter("fundAccount", "340000009785");
			param.setParameter("ticket", "");
//			param.setParameter("", "");
			httpRequest.setParams(param);
			response = httpclient.execute(httpRequest);
		} catch (Throwable throwable) {
			String msg = "{url:'" + url + "',description:'获取http响应内容异常'}";
//			throw new CompleteUrlPatternTitleException(msg, throwable);
		}

		StatusLine statusLine = response.getStatusLine();
		if (statusLine != null) {
			if (statusLine.getStatusCode() != HttpStatus.SC_OK) {
				String msg = "{url:'" + url + "',statusCode:'" + statusLine.getStatusCode() + "'}";
//				throw new CompleteUrlPatternTitleException(msg);
			} else {
				InputStream is = response.getEntity().getContent();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
				StringBuilder sb = new StringBuilder();
				String tempStr = null;
				if ((tempStr = bufferedReader.readLine()) != null) {
					sb.append(tempStr);
				}
				
				System.out.println(sb.toString());
			}
		}
		
		return null;
	}
	
	@Test
	public void getRemoteStr() {
        try {
        	String url = "https://trade.cgws.com/cgi-bin/user/Login"; 
//        	String encode;
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpParams params = httpclient.getParams();
			String pass = ScriptEngineTest.getPass();
			params.setParameter("password", pass);
			params.setParameter("password_Controls", "normal");
			params.setParameter("type", "Z");
			params.setParameter("fundAccount", "340000009785");
			params.setParameter("ticket", "6153");
			params.setParameter("retUrl", "");
			params.setParameter("mac", "");
			params.setParameter("normalpassword", "");

            HttpConnectionParams.setConnectionTimeout(params, 10*1000);
            HttpConnectionParams.setSoTimeout(params, 30000);
//            HttpUriRequest httpReq = new HttpGet(url);
            HttpPost httpPost = new HttpPost(url);
            httpPost.setParams(params);
            ResponseHandler<String> responseHandler = new MyResponseHandler("GBK");
            String returnStr = httpclient.execute(httpPost, responseHandler);
            
            System.out.println(returnStr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	@Test
	public void post() {
        try {
        	String url = "https://trade.cgws.com/cgi-bin/user/Login"; 
//        	String encode;
            DefaultHttpClient httpclient = new DefaultHttpClient();
//            httpclient.setCookieStore(cookieStore);
            Map<String, String> params = new HashMap<>();
//            HttpParams params = httpclient.getParams();
			String pass = ScriptEngineTest.getPass();
			params.put("password", pass);
			params.put("password_Controls", "normal");
			params.put("type", "Z");
			params.put("fundAccount", "340000009785");
			params.put("ticket", "6759");
			params.put("retUrl", "");
			params.put("mac", "");
			params.put("normalpassword", "");

//            HttpConnectionParams.setConnectionTimeout(params, 10*1000);
//            HttpConnectionParams.setSoTimeout(params, 30000);
//            HttpUriRequest httpReq = new HttpGet(url);
//            HttpPost httpPost = new HttpPost(url);
//            httpPost.setParams(params);
            HttpPost httpPost = postForm(url, params);
            ResponseHandler<String> responseHandler = new MyResponseHandler("GBK");
            String returnStr = httpclient.execute(httpPost, responseHandler);
            
            System.out.println(returnStr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	@Test
	public void sell() {
        try {
        	String url = "https://trade.cgws.com/cgi-bin/stock/StockEntrust?function=StockBusiness"; 
            DefaultHttpClient httpclient = new DefaultHttpClient();
            Map<String, String> params = new HashMap<>();
			String pass = ScriptEngineTest.getPass();
			params.put("type", "B");
			params.put("market", "0");
			params.put("up_limit", "7.700");
			params.put("down_limit", "6.300");
			params.put("stktype", "0");
			params.put("stkcode", "000010");
			params.put("stockName", "test");
			params.put("price", "7.280");
			params.put("fundavl", "0.00");
			params.put("maxBuy", "100");  //FIXME
			params.put("amount", "100");
//			params.put("secuid", "0184537403"); //0184537403
			params.put("secuid", "0184537403"); //0184537403
//			params.put("", "");

            HttpPost httpPost = postForm(url, params);
            ResponseHandler<String> responseHandler = new MyResponseHandler("GBK");
            String returnStr = httpclient.execute(httpPost, responseHandler);
            
            System.out.println(returnStr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	private static class MyResponseHandler implements ResponseHandler<String> {

        private String encode;

        public MyResponseHandler(String encode) {
            this.encode = encode;
        }

        public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() >= 300) {
                throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
            }

            HttpEntity entity = response.getEntity();
            return entity == null ? null : EntityUtils.toString(entity, this.encode);
        }
	}
	
	private static HttpPost postForm(String url, Map<String, String> params){
		
		HttpPost httpost = new HttpPost(url);
		
		httpost.addHeader(new BasicHeader("Cookie",cookie));
		List<NameValuePair> nvps = new ArrayList <NameValuePair>();
		
		Set<String> keySet = params.keySet();
		for(String key : keySet) {
			nvps.add(new BasicNameValuePair(key, params.get(key)));
		}
		
		try {
//			log.info("set utf-8 form entity to httppost");
			httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return httpost;
	}
}
