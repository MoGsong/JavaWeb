package com.gxlq.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gxlq.entity.EmailInfo;
import com.gxlq.service.IEmailInfoService;
import com.gxlq.service.imp.EmailInfoService;
/**
 * Servlet implementation class EmailInfoAction
 */
@WebServlet("/emailinfo")
public class EmailInfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailInfoAction() {
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
			String receivenumber = request.getParameter("textfield1");
			String sendtime = request.getParameter("textfield2");
			String emailaddress = request.getParameter("textfield3");
			String content = request.getParameter("textfield4");
			//content = new String(content.getBytes("iso-8859-1"),"UTF-8") ;
			EmailInfo emailInfo = new EmailInfo(receivenumber,Timestamp.valueOf(sendtime),emailaddress,content);
			IEmailInfoService emailInfoService = new EmailInfoService();
			emailInfoService.add(emailInfo);
			response.sendRedirect("http://192.168.1.167:8080/cims_gjmy/CIMS/tab/tab.jsp");
		}else if(op!=null&&"toupdate".equals(op)){
			
			String strid = request.getParameter("id");
			
			int id = 0;
			if(strid!=null) {
				id = Integer.parseInt(strid);
			}
			IEmailInfoService emailInfoService = new EmailInfoService();
			EmailInfo emailInfo = emailInfoService.find(id);
			//System.out.println(emailInfo.toString());
			request.setAttribute("EMAILINFO", emailInfo);
			//请求转发可以使用相对路径
			 //String path = request.getContextPath();
			 //String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			 //System.out.println(basePath);
			request.getRequestDispatcher("/CIMS/tab/update.jsp").forward(request, response);

		}else if(op!=null&&"update".equals(op)){
			
			String strid = request.getParameter("id");
			int id = 0;
			if(strid!=null) {
				id = Integer.parseInt(strid);
			}
			String receivenumber = request.getParameter("textfield1");
			String sendtime = request.getParameter("textfield2");
			String emailaddress = request.getParameter("textfield3");
			String content = request.getParameter("textfield4");
			EmailInfo emailInfo = new EmailInfo(id,receivenumber,Timestamp.valueOf(sendtime),emailaddress,content);
			IEmailInfoService emailInfoService = new EmailInfoService();
			emailInfoService.update(emailInfo);
			response.sendRedirect("http://192.168.1.167:8080/cims_gjmy/CIMS/tab/tab.jsp");
			
		}else {
			
			//删除数据
			String strid = request.getParameter("id");
			int id = 0;
			if(strid!=null) {
				id = Integer.parseInt(strid);
			}
			IEmailInfoService emailInfoService = new EmailInfoService();
			emailInfoService.remove(id);
			response.sendRedirect("http://192.168.1.167:8080/cims_gjmy/CIMS/tab/tab.jsp");
			
		}
	}

}
