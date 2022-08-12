package gxnu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckCookie
 */
@WebServlet("/Check")
public class CheckCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String URL = "http://192.168.1.167:8080/prj712/login/login.html";
		//新建Cookie对象获取请求中的cookie值
		Cookie[] cookies = request.getCookies();
		System.out.println("开始检查cookie...");
		//检查是否登录过的痕迹 ISACTIVE=YES
		if(cookies!=null) {
			for (Cookie cookie : cookies) {
				String key = cookie.getName();
				String value = cookie.getValue();
				System.out.println("Cookie:"+key+","+value);
				if("ISACTIVE".equals(key)&&"YES".equals(value)) {
					URL = "http://192.168.1.167:8080/prj712/web/main.html";
				}
			}
		}
		response.sendRedirect(URL);
	}
	
}
