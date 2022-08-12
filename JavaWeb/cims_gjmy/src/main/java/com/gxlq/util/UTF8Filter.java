//package com.gxlq.util;
//
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequestWrapper;
//import javax.servlet.http.HttpServletResponse;
////该注解指定当前类为过滤器类，/*表示对所有请求的资源进行过滤，即请求服务器的所有资源时均会运行当前过滤器
//
//@WebFilter("/*")
//public class UTF8Filter implements Filter{
//
//	//该方法中用于编码过滤操作功能代码，当过滤器运行时该方法自动运行
//	@Override
//	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
//			throws IOException, ServletException {
//		//请求参数中的中文设置为“UTF-8”，避免中文乱码
//		HttpServletRequest req = (HttpServletRequest)arg0; //把过滤器中的请求对象参数转换为基于http协议请求对象
//		HttpServletResponse resp = (HttpServletResponse)arg1;//把过滤器中的响应对象参数转换为基于http协议响应对象
//		
//		req.setCharacterEncoding("UTF-8"); //设置post请求参数的编码方式为UTF-8,避免中文乱码
//		//解决响应乱码
//        //resp.setContentType("text/html;charset=utf-8");
//		CharacterRequest characterRequest = new CharacterRequest(req);//设置get请求参数的编码方式为UTF-8,避免中文乱码
//		//继续执行过滤器链上的其它过滤器（若存在）
//		arg2.doFilter(characterRequest,resp);
//	}
//}
//
//class CharacterRequest extends HttpServletRequestWrapper{
//    private HttpServletRequest request;
//
//    public CharacterRequest(HttpServletRequest request) {
//        super(request);
//        this.request = request;
//    }
//
//    //增强原来的方法，在里面修改编码方式
//    @Override
//    public String getParameter(String name) {
//        String value = super.getParameter(name);
//        if(value == null){
//            return null;
//        }else{
//            String method = request.getMethod();
//            //注意请求方式
//            if("get".equalsIgnoreCase(method)){
//                try{
//                    value = new String(value.getBytes("iso-8859-1"),"UTF-8") ;
//                }catch(UnsupportedEncodingException e){
//                    throw new RuntimeException(e);
//                }
//            }/*else if("post".equalsIgnoreCase(method)) {
//            	try{
//                    value = new String(value.getBytes("iso-8859-1"),"UTF-8") ;
//                }catch(UnsupportedEncodingException e){
//                    throw new RuntimeException(e);
//                }
//            }*/
//            return value;
//     }
//   }
//}