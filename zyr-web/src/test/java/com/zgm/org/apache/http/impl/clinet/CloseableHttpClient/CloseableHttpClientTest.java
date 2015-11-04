package com.zgm.org.apache.http.impl.clinet.CloseableHttpClient;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.junit.Test;

public class CloseableHttpClientTest {
	
	@Test
	public void test() {
		this.getUrlTitle("m.abc.com", "http://m.abc.com/m/login/viladcode");
	}

	public String getUrlTitle(String domain, String url) {

		
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
		// connManager.setMaxPerRoute(new HttpRoute(new
		// HttpHost("www.aicai.com", 80)), 50);
		// Increase max connections for host to 50
		connManager.setMaxPerRoute(new HttpRoute(new HttpHost(domain, 80)), 50);

		CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(connManager)
				.setDefaultRequestConfig(requestConfig).build();

		HttpUriRequest httpRequest = RequestBuilder.get().setUri(uri).build();
		CloseableHttpResponse response = null;

		try {

//			HttpParams param = new BasicHttpParams();
//			param.setParameter(ClientPNames.HANDLE_REDIRECTS, true);
//			httpRequest.setParams(param);
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
			}
		}
		
		return null;
	}
}
