package com.jfinal.weixin.robot;

import java.io.Exception;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class TuLing {
public static String getMessage(String param) {
        String result = null;
        try{
            CloseableHttpClient httpclient = HttpClients.createDefault();
    		HttpGet httpGet = new HttpGet("http://www.tuling123.com/openapi/api?key=4d5ed869bfef66623dcdaf5643ff9a8f&info=Hello");
    		CloseableHttpResponse response = httpclient.execute(httpGet);
    		try {
    			HttpEntity entity = response.getEntity();
    			result = EntityUtils.toString(entity);
    		} finally {
    			response.close();
    		}
        }catch(Exception e){
            //ignore
        }
		return result;
	}
}
