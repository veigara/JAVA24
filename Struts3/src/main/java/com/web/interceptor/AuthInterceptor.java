package com.web.interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor {

	
	/**
	 * 拦截器方法
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		//获取session对象
//		Map<String,Object> session = ActionContext.getContext().getSession();
		Map<String, Object> session =  ServletActionContext.getContext().getSession();
		
		//从session中获取数据
		Object obj = session.get("admin");
		
		if(obj != null){
			//已经登录
			return invocation.invoke();
		}else{
			//没有登录
			return Action.LOGIN;//"login"
		}
	}
	
	
	

}
