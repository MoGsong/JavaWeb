package com.gxlq.upload;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class upload
 */

@WebServlet(urlPatterns={"/zzz"})
@MultipartConfig
public class upload extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		//获取请求中的文件对象
		Part p =req.getPart("pic");

		//获取请求头消息中的与上传文件有关的信息，如：
		//form-data; name="pic"; filename="car.jpg"

		String msg = p.getHeader("Content-Disposition");

		//截取文件名
		String fileName = msg.substring(msg.lastIndexOf("=")+2,msg.length()-1);
		System.out.println(fileName);

		//把上传的文件另存到磁盘上的某个位置
		//p.write("d://"+fileName);
		//保存到服务器根目录(开发环境)下，浏览器上可以访问该文件
		p.write(getServletContext().getRealPath("/")+fileName);
		System.out.println(req.getServletContext().getRealPath("/")+fileName);
		System.out.println("上传成功!");

	}
}


