package com.gxnu;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class I_O {
	//利用文件IO的输入->缓存->输出进行文件或目录的复制
	public static void main(String[] args) throws IOException {
		//基于C:\Users\johny\Desktop\images\wyb.jpg创建一个java.io.File对象
		File file = new File("C:");
		
		//基于d:\mylove\gg.jpg创建一个java.io.File对象
		//判断文件夹是否存在，若不存在则创建
		File dir = new File("");
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		//判断文件是否存在，若不存在则创建
		File  file2= new File("");
		if(!file2.exists()) {
			file2.createNewFile();
		}
		
		//创建字节输入流对象 
		FileInputStream   fis  =  new  FileInputStream( file );
		//创建字节输j出流对象 
		FileOutputStream fos = new FileOutputStream(file2);
		
		//创建带缓冲的字节输入流对象（提高数据传输性能）
		BufferedInputStream  bis = new  BufferedInputStream( fis  );
		//创建带缓冲的字节输出流对象（提高数据传输性能）
		BufferedOutputStream  bos = new BufferedOutputStream( fos );
		//代码简化
		//BufferedInputStream  bis = new BufferedInputStream(new FileInputStream(new File("")));
		//BufferedOutputStream  bos = new BufferedOutputStream(new FileOutputStream(new File("")));
		//通过循环，逐字节把C盘文件传输到内存,若到了文件末尾，返回-1
		int data ;
		while( (data = bis.read()) !=-1 ){
		   //System.out.println(data);
			//把数据逐字节传输到D盘文件
			bos.write(data);
		}
		//关闭流对象，先创建的后关
		bos.close();
		bis.close();
		fos.close();
		fis.close();
	}
}

