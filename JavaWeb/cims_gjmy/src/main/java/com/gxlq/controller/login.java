package com.gxlq.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.gxlq.entity.Operator;
import com.gxlq.service.IOperatorService;
import com.gxlq.service.imp.OperatorService;

/**
 * Servlet implementation class OperatorAction
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("textfield");
		String password = request.getParameter("textfield2");
		System.out.println(username +","+ password);
		
		String dist = "";
		IOperatorService ios = new OperatorService();
        Operator operator = ios.find(username, password);
        if (operator.getId() > 0) {
        	System.out.println("账号密码正确");
        	//添加成功登录到会话，然后监听会话，记录用户登录、退出操作
        	HttpSession session = request.getSession();
        	session.setAttribute("USER",username);
        	session.setAttribute("OPERATOR", operator);
        	dist = "http://192.168.1.167:8080/cims_gjmy/CIMS/main.html";
        }else {
        	System.out.println("账号或密码有误");
        	dist = "http://192.168.1.167:8080/cims_gjmy/CIMS/login.html";
        }
        response.sendRedirect(dist);
        
//        
//        String  op = request.getParameter("OP");
//		if(op!=null&&"add".equals(op)) {
//			//添加数据
//			String name = request.getParameter("textfield1");
//			String parent = request.getParameter("textfield2");
//			String url = request.getParameter("textfield3");
//			Menu menu = new Menu(name,Integer.parseInt(parent),url);
//			IMenuService menuService = new MenuService();
//			menuService.add(menu);
//			response.sendRedirect("http://192.168.1.167:8080/cims_gjmy/CIMS/tab/menu.jsp");
//		}else if(op!=null&&"toupdate".equals(op)){
//			
//			String strid = request.getParameter("id");
//			int id = 0;
//			if(strid!=null) {
//				id = Integer.parseInt(strid);
//			}
//			IMenuService menuService = new MenuService();
//			Menu menu = menuService.find(id);
//			//System.out.println(menu.toString());
//			request.setAttribute("MENU", menu);
//			//请求转发可以使用相对路径
//			 //String path = request.getContextPath();
//			 //String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//			 //System.out.println(basePath);
//			request.getRequestDispatcher("/CIMS/tab/updatemenu.jsp").forward(request, response);
//
//		}else if(op!=null&&"update".equals(op)){
//			
//			String strid = request.getParameter("id");
//			int id = 0;
//			if(strid!=null) {
//				id = Integer.parseInt(strid);
//			}
//			String name = request.getParameter("textfield1");
//			String parent = request.getParameter("textfield2");
//			String url = request.getParameter("textfield3");
//			Menu menu = new Menu(id,name,Integer.parseInt(parent),url);
//			IMenuService menuService = new MenuService();
//			menuService.update(menu);
//			response.sendRedirect("http://192.168.1.167:8080/cims_gjmy/CIMS/tab/menu.jsp");
//			
//		}else {
//			
//			//删除数据
//			String strid = request.getParameter("id");
//			int id = 0;
//			if(strid!=null) {
//				id = Integer.parseInt(strid);
//			}
//			IMenuService menuService = new MenuService();
//			menuService.remove(id);
//			response.sendRedirect("http://192.168.1.167:8080/cims_gjmy/CIMS/tab/menu.jsp");
//			
//		}
	
	}

}
