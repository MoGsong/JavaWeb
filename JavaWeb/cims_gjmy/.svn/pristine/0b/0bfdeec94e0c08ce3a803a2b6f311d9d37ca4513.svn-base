package com.gxlq.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gxlq.entity.Menu;
import com.gxlq.service.IMenuService;
import com.gxlq.service.imp.MenuService;
/**
 * Servlet implementation class MenuAction
 */
@WebServlet("/menu")
public class MenuAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  op = request.getParameter("OP");
		if(op!=null&&"add".equals(op)) {
			//添加数据
			String name = request.getParameter("textfield1");
			String parent = request.getParameter("textfield2");
			String url = request.getParameter("textfield3");
			Menu menu = new Menu(name,Integer.parseInt(parent),url);
			IMenuService menuService = new MenuService();
			menuService.add(menu);
			response.sendRedirect("http://192.168.1.167:8080/cims_gjmy/CIMS/tab/menu.jsp");
		}else if(op!=null&&"toupdate".equals(op)){
			
			String strid = request.getParameter("id");
			int id = 0;
			if(strid!=null) {
				id = Integer.parseInt(strid);
			}
			IMenuService menuService = new MenuService();
			Menu menu = menuService.find(id);
			//System.out.println(menu.toString());
			request.setAttribute("MENU", menu);
			//请求转发可以使用相对路径
			 //String path = request.getContextPath();
			 //String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			 //System.out.println(basePath);
			request.getRequestDispatcher("/CIMS/tab/updatemenu.jsp").forward(request, response);

		}else if(op!=null&&"update".equals(op)){
			
			String strid = request.getParameter("id");
			int id = 0;
			if(strid!=null) {
				id = Integer.parseInt(strid);
			}
			String name = request.getParameter("textfield1");
			String parent = request.getParameter("textfield2");
			String url = request.getParameter("textfield3");
			Menu menu = new Menu(id,name,Integer.parseInt(parent),url);
			IMenuService menuService = new MenuService();
			menuService.update(menu);
			response.sendRedirect("http://192.168.1.167:8080/cims_gjmy/CIMS/tab/menu.jsp");
			
		}else {
			
			//删除数据
			String strid = request.getParameter("id");
			int id = 0;
			if(strid!=null) {
				id = Integer.parseInt(strid);
			}
			IMenuService menuService = new MenuService();
			menuService.remove(id);
			response.sendRedirect("http://192.168.1.167:8080/cims_gjmy/CIMS/tab/menu.jsp");
			
		}
	}

}
