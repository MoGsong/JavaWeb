package com.gxnu;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class I_O {
	//�����ļ�IO������->����->��������ļ���Ŀ¼�ĸ���
	public static void main(String[] args) throws IOException {
		//����C:\Users\johny\Desktop\images\wyb.jpg����һ��java.io.File����
		File file = new File("C:");
		
		//����d:\mylove\gg.jpg����һ��java.io.File����
		//�ж��ļ����Ƿ���ڣ����������򴴽�
		File dir = new File("");
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		//�ж��ļ��Ƿ���ڣ����������򴴽�
		File  file2= new File("");
		if(!file2.exists()) {
			file2.createNewFile();
		}
		
		//�����ֽ����������� 
		FileInputStream   fis  =  new  FileInputStream( file );
		//�����ֽ���j�������� 
		FileOutputStream fos = new FileOutputStream(file2);
		
		//������������ֽ�����������������ݴ������ܣ�
		BufferedInputStream  bis = new  BufferedInputStream( fis  );
		//������������ֽ����������������ݴ������ܣ�
		BufferedOutputStream  bos = new BufferedOutputStream( fos );
		//�����
		//BufferedInputStream  bis = new BufferedInputStream(new FileInputStream(new File("")));
		//BufferedOutputStream  bos = new BufferedOutputStream(new FileOutputStream(new File("")));
		//ͨ��ѭ�������ֽڰ�C���ļ����䵽�ڴ�,�������ļ�ĩβ������-1
		int data ;
		while( (data = bis.read()) !=-1 ){
		   //System.out.println(data);
			//���������ֽڴ��䵽D���ļ�
			bos.write(data);
		}
		//�ر��������ȴ����ĺ��
		bos.close();
		bis.close();
		fos.close();
		fis.close();
	}
}

