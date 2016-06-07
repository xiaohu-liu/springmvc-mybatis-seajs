package com.springmvc.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description CookieTool used to operate the cookie
 * @author Administrator
 *
 */
public class CookieTool {

	
	/**
	 * @param response
	 * @param name cookie名字
	 * @param value cookie值
	 * @param maxAge 生命周期 以秒为单位
	 * @author hsq
	 */
	public static void addCookie(HttpServletResponse response,String name,String value,int maxAge){
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		if(maxAge > 0){
			cookie.setMaxAge(maxAge);
		}
		response.addCookie(cookie);
	}
	
	
	
	/**
	 * @param request
	 * @return
	 * @author hsq
	 */
	public static Map<String, Cookie> readCookieMap(HttpServletRequest request){
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if(null != cookies){
			for(Cookie cookie : cookies){
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}
	
	/**
	 * @param request
	 * @param name cookie的名字
	 * @return
	 */
	public static Cookie getCookieByName(HttpServletRequest request,String name){
		Map<String, Cookie> cookieMap = readCookieMap(request);
		if(cookieMap.containsKey(name)){
			return cookieMap.get(name);
		}else {
			return null;
		}
	}
}
