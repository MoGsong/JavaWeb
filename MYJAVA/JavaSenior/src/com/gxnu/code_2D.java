package com.gxnu;

import com.gxlq.zyj.Code_2D;

public class code_2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//参数1:二维码中心 显示的logo图片
		//参数2:二维码生成在电脑上的存放位置
		//参数3:扫描二维码后， 跳转的网址
		//参数4:二维码显示的文本
		Code_2D.drawLogoQRCode("C:\\users\\johny\\Desktop\\images\\xxxx.jpg" ,"d:\\二维码.jpg" ,
											"http://www.baidu.com" ,"去百度");
		System.gc();
	}

}
