//package com.gxlq.util;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
////该注解指定当前类为过滤器类，/*表示对所有请求的资源进行过滤，即请求服务器的所有资源时均会运行当前过滤器
//@WebFilter("/*")
//public class ResourceAccessFilter implements Filter {
//
//	//用于拦截过滤的方法
//	@Override
//	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
//			throws IOException, ServletException {
//		//获取session对象中用户信息，若不为空，则表示用户已经登录，不做拦截
//		HttpServletRequest req = (HttpServletRequest)arg0;
//		HttpSession session = req.getSession();
//		Object obj = session.getAttribute("OPERATOR");
//		//通常图片、css等文件、关键面页，关键servlet直接放行
//		//获取某个请求资源的url，如http://192.168.1.55:8080/cims/images/xxx.gif
//		String url = req.getRequestURI();
//		System.out.println("请求资源对应的url"+url);
//		if(obj!=null 
//				|| url.endsWith(".jpg") 
//				|| url.endsWith(".gif")
//				|| url.endsWith(".png")
//				|| url.endsWith(".css")
//				|| url.endsWith(".js")
//				|| url.endsWith("login.html")
//				|| url.endsWith("/operator")
//				) {
//			//不做任何处理，即“直接放行”
//			arg2.doFilter(arg0, arg1);
//		}else {
//			//若无登录，则跳转到登录页面
//			HttpServletResponse resp = (HttpServletResponse)arg1;
//			//resp.sendRedirect(Data.URL+"/login.html"); //"http://192.168.1.55:8080/cims/login.html"
//			resp.setContentType("text/html;charset=UTF-8");
//			PrintWriter out = resp.getWriter();
//			//window.top表示在浏览器顶层窗口显示跳转后的页面
//			out.print("<script>window.top.location.href='http://192.168.1.167:8080/cims_gjmy/CIMS/login.html';</script>");
//		}
//	}
//}
