package com.gxnu.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @author Administrator
 *
 */
@WebListener
public class ReqListener implements ServletRequestAttributeListener,ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("请求被销毁了");
		ServletRequestListener.super.requestDestroyed(sre);
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("请求初始化");
		ServletRequestListener.super.requestInitialized(sre);
	}

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		System.out.println("请求数据添加了");
		ServletRequestAttributeListener.super.attributeAdded(srae);
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		String name = srae.getName();
		Object value = srae.getValue();
		System.out.println("请求数据被删除了"+ name + "="+ value);
		ServletRequestAttributeListener.super.attributeRemoved(srae);
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		System.out.println("请求数据修改了");
		ServletRequestAttributeListener.super.attributeReplaced(srae);
	}
	
	
}
