package com.jfinal.weixin.demo;

import com.jfinal.core.Controller;
import com.jfinal.weixin.sdk.api.ApiResult;
import com.jfinal.weixin.sdk.api.MenuApi;
import com.jfinal.weixin.sdk.api.UserApi;

public class ApiController extends Controller {
	
	/*
	public void index() {
		render("/api/index.html");
	}
	*/
	
	/**
	 * 获取公众号菜单
	 */
	public void getMenu() {
		ApiResult apiResult = MenuApi.getMenu();
		if (apiResult.isSucceed())
			renderText(apiResult.getJson());
		else
			renderText(apiResult.getErrorMsg());
	}
	
	/**
	 * 获取公众号关注用户
	 */
	public void getFollowers() {
		ApiResult apiResult = UserApi.getFollows();
		// TODO 用 jackson 解析结果出来
		renderText(apiResult.getJson());
	}
}




