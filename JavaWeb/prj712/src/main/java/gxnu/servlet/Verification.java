package gxnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gxlq.entity.Operator;
import com.gxlq.service.IOperatorService;
import com.gxlq.service.imp.OperatorService;

/**
 * Servlet implementation class test
 */
@WebServlet("/Verification")
public class Verification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("textfield");
		String password = request.getParameter("textfield2");
		String    flag  = request.getParameter("textfield3");
		String    inputcode  = request.getParameter("textfield4");
		System.out.println(username +","+ password + "," + flag + "," + inputcode);
		HttpSession session = request.getSession();
		Object code = session.getAttribute("code");
		if(code.equals(inputcode)) {
			String dist = "";
			IOperatorService ios = new OperatorService();
	        Operator operator = ios.find(username, password);
	        if (operator.getId() > 0) {
	        	System.out.println("账号密码正确");
	        	dist = "http://192.168.1.167:8080/prj712/web/main.html";
	        	if(flag!=null) {
	        		Cookie c = new Cookie("ISACTIVE","YES");
	        		c.setMaxAge(5*24*60*60);
	        		response.addCookie(c);
	        		//System.out.println("已记住密码...");
	        	}
	        }else {
	        	System.out.println("账号或密码错误");
	        	dist = "http://192.168.1.167:8080/prj712/login/login.html";
	        }
	        response.sendRedirect(dist);
	        //使用request.getRequestDispatcher(URL).forward(request, response);可以保证数据不丢失
	      	//request.getRequestDispatcher(URL).forward(request, response);
	    }else {
	    	System.out.println("验证码有误");
	    	response.setContentType("text/html;charset=UTF-8;");
	    	PrintWriter out = response.getWriter();
	    	out.print("<script>window.alert('验证码错误');window.location.href='http://192.168.1.167:8080/prj712/login/login.html';</script>");
	    }
     }
	
}


