package com.gxlq.upload;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class multi_upload
 */
@WebServlet("/multi_upload")
@MultipartConfig
public class multi_upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			doPost(req,resp);
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			//获取请求中的文件对象

			Collection<Part> ps =req.getParts();
			for (Part p : ps) {
				//获取请求头消息中的与上传文件有关的信息，如：
				//form-data; name="pic"; filename="car.jpg"
	
				String msg = p.getHeader("Content-Disposition");
	
				//截取文件名
				String fileName = msg.substring(msg.lastIndexOf("=")+2,msg.length()-1);
	
				//把上传的文件另存到磁盘上的某个位置
				//p.write("C://"+fileName);
	
				// web项目的根目录，此处WebRoot  + 文件夹名 ，此处images  +文件名，此处为 fileName
				// 获取的是项目部署后的位置
				p.write(req.getServletContext().getRealPath("/")+fileName);
				System.out.println(req.getServletContext().getRealPath("/")+fileName);
				System.out.println(fileName + "上传成功!");
			}
		}

}
