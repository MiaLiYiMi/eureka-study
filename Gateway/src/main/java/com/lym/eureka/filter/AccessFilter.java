package com.lym.eureka.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class AccessFilter extends ZuulFilter{
	
	
	/**
	 * 过滤器是否需要被执行 
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext context=RequestContext.getCurrentContext();
		HttpServletRequest request=context.getRequest();
		
		Object accessToken=request.getParameter("token");
		if(accessToken==null) {
			context.setSendZuulResponse(false);
			context.setResponseStatusCode(401);
			return null;
		}
		return Boolean.TRUE;
	}

	/**
	 * 过滤器执行类型
	 * pre:请求被路由之前调用
	 * routing:路由请求时被调用
	 * post:在routing和error过滤器之后被调用
	 * error:处理请求发生错误时被调用
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 过滤器执行顺序，数值越小优先级越高
	 */
	@Override
	public int filterOrder() {
		return 0;
	}
	
}
