package com.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * SpringMVC 中的Interceptor 拦截请求是通过HandlerInterceptor 来实现的。
 * 在SpringMVC 中定义一个Interceptor 非常简单，主要有两种方式，
 * 第一种方式是要定义的Interceptor类要实现了Spring 的HandlerInterceptor 接口，
 * 或者是这个类继承实现了HandlerInterceptor 接口的类，
 * 比如Spring 已经提供的实现了HandlerInterceptor 接口的抽象类HandlerInterceptorAdapter ；
 * 第二种方式是实现Spring的WebRequestInterceptor接口，或者是继承实现了WebRequestInterceptor的类。
 * @author hsq
 *
 */
public class ShareusInterceptor extends HandlerInterceptorAdapter {
	
	
	private static Logger logger = Logger.getLogger(ShareusInterceptor.class);
	/**
	 * 在请求之前调用
	 * SpringMVC 中的Interceptor 是链式的调用的，在一个应用中或者说是在一个请求中可以同时存在多个Interceptor。
	 * 每个Interceptor 的调用会依据它的声明顺序依次执行，而且最先执行的都是Interceptor 中的preHandle 方法
	 * 所以可以在这个方法中进行一些前置初始化操作或者是对当前请求的一个预处理，也可以在这个方法中进行一些判断来决定请求是否要继续进行下去。
	 * 该方法的返回值是布尔值Boolean 类型的，当它返回为false 时，表示请求结束，后续的Interceptor 和Controller 都不会再执行；
	 * 当返回值为true 时就会继续调用下一个Interceptor 的preHandle 方法，如果已经是最后一个Interceptor 的时候就会是调用当前请求的Controller 方法。
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("preHandle is executed");
		logger.info(request.getCharacterEncoding());
		logger.info(response.getCharacterEncoding());
		return true;
	}
	
	/**
	 * 在当前请求进行处理之后，也就是Controller 方法调用之后执行
	 * 但是它会在DispatcherServlet 进行视图返回渲染之前被调用，所以我们可以在这个方法中对Controller 处理之后的ModelAndView 对象进行操作。
	 * postHandle 方法被调用的方向跟preHandle 是相反的，也就是说先声明的Interceptor 的postHandle 方法反而会后执行,
	 * Struts2 里面的Interceptor 的执行过程也是链式的，只是在Struts2 里面需要手动调用ActionInvocation 的invoke 方法来触发对下一个Interceptor 或者是Action 的调用
	 * 然后每一个Interceptor 中在invoke 方法调用之前的内容都是按照声明顺序执行的，而invoke 方法之后的内容就是反向的。
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.info("postHandle is executed");
		logger.info(request.getCharacterEncoding());
		logger.info(response.getCharacterEncoding());
		super.postHandle(request, response, handler, modelAndView);
		
	}
	/**
	 * 该方法也是需要当前对应的Interceptor 的preHandle 方法的返回值为true 时才会执行。
	 * 该方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行。
	 * 这个方法的主要作用是用于进行资源清理工作的。
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
		logger.info(request.getCharacterEncoding());
		logger.info(response.getCharacterEncoding());
		logger.info("afterCompletion is executed");
		super.afterCompletion(request, response, handler, ex);
	}

}
