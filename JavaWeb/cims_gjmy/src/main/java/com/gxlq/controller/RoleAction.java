package com.gxlq.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gxlq.entity.Role;
import com.gxlq.service.IRoleService;
import com.gxlq.service.imp.RoleService;

/**
 * Servlet implementation class RoleAction
 */
@WebServlet("/role")
public class RoleAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleAction() {
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
			//content = new String(content.getBytes("iso-8859-1"),"UTF-8") ;
			Role role = new Role(name);
			IRoleService roleService = new RoleService();
			roleService.add(role);
			response.sendRedirect("http://192.168.1.167:8080/cims_gjmy/CIMS/tab/role.jsp");
		}else if(op!=null&&"toupdate".equals(op)){
			
			String strid = request.getParameter("id");
			
			int id = 0;
			if(strid!=null) {
				id = Integer.parseInt(strid);
			}
			IRoleService roleService = new RoleService();
			Role role = roleService.find(id);
			//System.out.println(role.toString());
			request.setAttribute("ROLE", role);
			//请求转发可以使用相对路径
			 //String path = request.getContextPath();
			 //String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			 //System.out.println(basePath);
			request.getRequestDispatcher("/CIMS/tab/updaterole.jsp").forward(request, response);

		}else if(op!=null&&"update".equals(op)){
			
			String strid = request.getParameter("id");
			int id = 0;
			if(strid!=null) {
				id = Integer.parseInt(strid);
			}
			String name = request.getParameter("textfield1");
			Role role = new Role(id,name);
			IRoleService roleService = new RoleService();
			roleService.update(role);
			response.sendRedirect("http://192.168.1.167:8080/cims_gjmy/CIMS/tab/role.jsp");
			
		}else {
			
			//删除数据
			String strid = request.getParameter("id");
			int id = 0;
			if(strid!=null) {
				id = Integer.parseInt(strid);
			}
			IRoleService roleService = new RoleService();
			roleService.remove(id);
			response.sendRedirect("http://192.168.1.167:8080/cims_gjmy/CIMS/tab/role.jsp");
			
		}
	}

}
