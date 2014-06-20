package com.zgm.java.net.HttpUrlConnection;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

/**
 * @author zhouguangming
 * 创建时间: 2014年5月31日 下午12:18:52
 */
public class AATest {
	
	@Test
	public void getDocument() { 
        try { 
        	URL url = new URL("http://kaijiang.500.com/pls.shtml");
            // 设置编码集 
//            org.jsoup.nodes.Document doc = Jsoup.parse(html, "UTF-8"); 
            org.jsoup.nodes.Document doc = Jsoup.parse(url, 5000);
            
            Elements resultNos = doc.select("li[class=ball_orange]");
            if (resultNos != null) {
            	for (Element element : resultNos) {
            		System.out.println(element.text());
            	}
            }
            
            Elements types = doc.select("font[class=cfont1]") ;
            if (types != null) {
            	System.out.println(types.get(0).text());
            }
            
            /*  //不支持标签span？
            Elements salePrice = doc.select("span[class=cfont1]") ;
            if (salePrice != null) {
            	for (Element element : salePrice)  {
            		System.out.println(element.text());
            	}
            }
            */
            
            
            Elements tables = doc.select("table[class=kj_tablelist02]") ;
            if (tables != null) {
            	
	            Elements issueNoFont = doc.select("font[class=cfont2]") ;
	            if (issueNoFont != null) {
	            	System.out.println(issueNoFont.get(0).child(0).text());
	            }
            	
//            	System.out.println(tables.get(0).children().get(0).child(2).child(0).child(0).text());
	            String saleValueTemp = tables.get(0).children().get(0).child(2).child(0).child(0).text();
	            saleValueTemp = saleValueTemp.substring(0, saleValueTemp.length() - 1);
	            System.out.println(saleValueTemp.replace(",", ""));
            	
//            	for (Element table : tables.get(1).children())  {
            	for (Element tbody : tables.get(1).children())  {
            		for (Element tr : tbody.children()) {
            			for (Element td : tr.children()) {
            				if (td.text().equals("排列三直选")) {
            					//TODO
            					System.out.println("排列三直选中奖注数:" + td.nextElementSibling().text());
            					System.out.println("排列三直选奖金:" + td.nextElementSibling().nextElementSibling().text());
            				} else if (td.text().equals("排列三组三")) {
            					//TODO
            					System.out.println("排列三组三中奖注数:" + td.nextElementSibling().text());
            					System.out.println("排列三组三奖金:" + td.nextElementSibling().nextElementSibling().text());
            				} else if (td.text().equals("排列三组六")) {
            					//TODO
            					System.out.println("排列三组六中奖注数:" + td.nextElementSibling().text());
            					System.out.println("排列三组六奖金:" + td.nextElementSibling().nextElementSibling().text());
            				}
            			}
            			
//            			System.out.println(td.text());
            		}
            	}
            }
            
            /*
            // 提取标题信息 
            Elements title = doc.select("title"); 
            for (org.jsoup.nodes.Element link : title) { 
                text += link.text() + " "; 
            } 
            // 提取table中的文本信息 
            Elements links = doc.select("table"); 
            for (org.jsoup.nodes.Element link : links) { 
                text += link.text() + " "; 
            } 
            // 提取div中的文本信息 
            Elements divs = doc.select("div[class=post]"); 
            for (org.jsoup.nodes.Element link : divs) { 
                text += link.text() + " "; 
            } 
           */ 
            
        } catch (IOException e) { 
            e.printStackTrace(); 
        } catch (Throwable t) {
        	t.printStackTrace();
        }
    }
}
