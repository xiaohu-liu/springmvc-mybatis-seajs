package com.springmvc.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONObject;


/**
 * Json与javaBean之间的转换工具类
 */
public class JsonPluginsUtil {

	/**
	 * 将java对象转换成json字符串
	 * 
	 * @param bean
	 * @return json
	 */
	public static String beanToJson(Object bean) {

		JSONObject json = JSONObject.fromObject(bean);
		return json.toString();
	}

	/**
	 * 从一个JSON 对象字符格式中得到一个java对象
	 * 
	 * @param jsonString
	 * @param beanCalss
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T jsonToBean(String jsonString, Class<T> beanCalss) {

		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		T bean = (T) JSONObject.toBean(jsonObject, beanCalss);
		return bean;

	}

	/**
	 * 从json HASH表达式中获取一个map，改map支持嵌套功能
	 * 
	 * @param jsonString
	 * @return
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public static Map jsonToMap(String jsonString) {

		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		Iterator keyIter = jsonObject.keys();
		String key;
		Object value;
		Map valueMap = new HashMap();

		while (keyIter.hasNext()) {

			key = (String) keyIter.next();
			value = jsonObject.get(key).toString();
			valueMap.put(key, value);

		}

		return valueMap;
	}
}