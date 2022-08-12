package gxnu.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/CODE"})
public class Vericode extends HttpServlet {
	
	//产生随机颜色函数getRandColor
	private Color getRandColor(int fc, int bc) {
        Random r = new Random();
        if (fc > 255) fc = 255;
        if (bc > 255) bc = 255;
        int red = fc + r.nextInt(bc - fc); //红
        int green = fc + r.nextInt(bc - fc); //绿
        int blue = fc + r.nextInt(bc - fc); //蓝
        return new Color(red, green, blue);
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//当通过get方式请求当前servlet类时，响应一个验证码图片到浏览器端
		resp.setContentType("image/jpeg"); //设置响应的内容类型
		
		//设置页面不缓存
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("expires", 0);
		
		// 在内存中创建图像，宽度为width，高度为height
        int width = 60, height = 20;
        //基于特定面积和色彩创建一个Java图片对象
        BufferedImage pic = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
        
        // 获取图形上下文环境（即画图板）
        Graphics gc = pic.getGraphics();
        
        // 设定背景色并进行填充
        gc.setColor(getRandColor(200, 250));
        gc.fillRect(0, 0, width, height);
        
        //设定图形上下文环境字体
        gc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        
        Random r = new Random();
		//生成200条干扰线
        //随机产生200条干扰直线，使图像中的认证码不易被其他分析程序探测到
        for (int i = 0; i < 200; i++) {
            int x1 = r.nextInt(width);
            int y1 = r.nextInt(height);
            int x2 = r.nextInt(15);
            int y2 = r.nextInt(15);
            gc.setColor(getRandColor(160, 200));
            gc.drawLine(x1, y1, x1 + x2, y1 + y2);
        }
        //随机产生100个干扰点，使图像中的验证码不易被其他分析程序探测到
    	for (int i = 0; i < 100; i++) {
            int x = r.nextInt(width);
            int y = r.nextInt(height);
            gc.setColor(getRandColor(120, 240));
            gc.drawOval(x, y, 0, 0);
        }
    	
    	//在验证码上添加干扰
        String RS = r.nextInt(9000) + 1000 + "";   //4467
//        for (int i = 0; i < 50; i++) {
//            int x1 = r.nextInt(width);
//            int y1 = r.nextInt(height);
//            int x2 = r.nextInt(15);
//            int y2 = r.nextInt(15);
//            gc.setColor(getRandColor(160, 200));
//            gc.drawLine(x1, y1, x1 + x2, y1 + y2);
//        }
//
//    	for (int i = 0; i < 10; i++) {
//            int x = r.nextInt(width);
//            int y = r.nextInt(height);
//            gc.setColor(getRandColor(120, 240));
//            gc.drawOval(x, y, 0, 0);
//        }
    	
        
        //将认证码用drawString函数显示到图像里
        gc.setColor(new Color(20 + r.nextInt(110), 20 + r.nextInt(110),	20 + r.nextInt(110)));
        //gc.drawString(RS, 10, 16);
        //逐个显示验证码,并让每个验证码数字呈现不同的颜色
        
        gc.drawString((Integer.parseInt(RS)/1000+""), r.nextInt(5,10), r.nextInt(12,15));
        gc.setColor(getRandColor(50, 100));
        gc.drawString((Integer.parseInt(RS)%1000/100+""), r.nextInt(15, 20), r.nextInt(12, 20));
        gc.setColor(getRandColor(50, 100));
        gc.drawString((Integer.parseInt(RS)%100/10+""), r.nextInt(25, 30),r.nextInt(15, 20));
        gc.setColor(getRandColor(50, 100));
        gc.drawString((Integer.parseInt(RS)%10+""), r.nextInt(35, 40), r.nextInt(12, 20));
        gc.setColor(getRandColor(50, 100));
		System.out.println("验证码:"+ (Integer.parseInt(RS)/1000+"") +(Integer.parseInt(RS)%1000/100+"") + (Integer.parseInt(RS)%100/10+"") + (Integer.parseInt(RS)%10+""));
    	
		HttpSession session = req.getSession();
		session.setAttribute("code",RS);
		
		// 释放图形上下文环境
        gc.dispose();
		//把验证码图片传输到浏览器端
     // 输出生成后的验证码图像到页面
        ImageIO.write(pic, "JPEG", resp.getOutputStream());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
