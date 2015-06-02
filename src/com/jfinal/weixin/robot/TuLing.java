package com.jfinal.weixin.robot;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class TuLing {
public static TuLingResponse getMessage(String param) {
		TuLingResponse result = null;
		String resultStr = null;
		try{
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet("http://www.tuling123.com/openapi/api?key=4d5ed869bfef66623dcdaf5643ff9a8f&info=" + param);
			CloseableHttpResponse response = httpclient.execute(httpGet);
			try {
				HttpEntity entity = response.getEntity();
				resultStr = EntityUtils.toString(entity);
				if(resultStr != null){
					result = gson.fromJson(resultStr,TuLingResponse.class);
				}
			} finally {
				response.close();
			}
		}catch(Exception e){
			//ignore
		}
		return result;
	}
}
