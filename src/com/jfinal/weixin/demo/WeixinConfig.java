/**
 * Copyright (c) 2011-2014, James Zhan 詹波 (jfinal@126.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */

package com.jfinal.weixin.demo;

import java.util.Properties;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.weixin.sdk.api.ApiConfig;

public class WeixinConfig extends JFinalConfig {
	
	public Properties loadProp(String pro, String dev) {
		try {return loadPropertyFile(pro);}
		catch (Exception e)
			{return loadPropertyFile(dev);}
	}
	
	public void configConstant(Constants me) {
		// 如果生产环境配置文件存在，则优先加载该配置，否则加载开发环境配置文件
		loadProp("a_little_config_pro.txt", "a_little_config.txt");
		me.setDevMode(getPropertyToBoolean("devMode", false));
		
		// 配置微信 API 相关常量
		ApiConfig.setDevMode(me.getDevMode());
		ApiConfig.setUrl(getProperty("url"));
		ApiConfig.setToken(getProperty("token"));
		ApiConfig.setAppId(getProperty("appId"));
		ApiConfig.setAppSecret(getProperty("appSecret"));
		
		/**
		 *  是否对消息进行加密，对应于微信平台的消息加解密方式：
		 *  1：true进行加密且必须配置 encodingAesKey
		 *  2：false采用明文模式，同时也支持混合模式
		 */
		ApiConfig.setEncryptMessage(getPropertyToBoolean("encryptMessage", false));
		ApiConfig.setEncodingAesKey(getProperty("encodingAesKey", "setting it in config file"));
	}
	
	public void configRoute(Routes me) {
		me.add("/weixin", DemoController.class);
		me.add("/api", ApiController.class, "/api");
	}
	
	public void configPlugin(Plugins me) {
		// C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password").trim());
		// me.add(c3p0Plugin);
		
		EhCachePlugin ecp = new EhCachePlugin();
		me.add(ecp);
	}
	
	public void configInterceptor(Interceptors me) {
		
	}
	
	public void configHandler(Handlers me) {
		
	}
	
	public static void main(String[] args) {
		JFinal.start("webapp", 80, "/", 5);
	}
}
