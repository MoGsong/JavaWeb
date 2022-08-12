package com.gxnu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

@SuppressWarnings("unused")
public class Test_poi {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// apache pio ������C:\Users\johny\Desktop\xxx.xslx�ļ����С�д������
				//1������һ������������
				HSSFWorkbook workbook = new HSSFWorkbook();
				//2������һ�����������
				HSSFSheet sheetyc =  workbook.createSheet("����ʦ����ѧ�����ţ�");
				//3������һ���ж���
				HSSFRow row1 = sheetyc.createRow(0);
				//4������һ����Ԫ�����
				HSSFCell cell1 = row1.createCell(0);
				//5����Ԫ����д�����ݣ��ҿ������õ�Ԫ������
				cell1.setCellType(CellType.STRING);
				cell1.setCellValue("�Ű���");
				//4������һ����Ԫ�����
				HSSFCell cell2 = row1.createCell(1);
				//5����Ԫ����д�����ݣ��ҿ������õ�Ԫ������
				cell2.setCellType(CellType.STRING);
				cell2.setCellValue("18");
				
				//3������һ���ж���
				HSSFRow row2 = sheetyc.createRow(1);
				//4������һ����Ԫ�����
				cell1 = row2.createCell(0);
				
				//5����Ԫ����д�����ݣ��ҿ������õ�Ԫ������
				cell1.setCellType(CellType.STRING);
				cell1.setCellValue("����");
				
				//4������һ����Ԫ�����
				cell2 = row2.createCell(1);
				
				//5����Ԫ����д�����ݣ��ҿ������õ�Ԫ������
				cell2.setCellType(CellType.STRING);
				cell2.setCellValue("21");
				
				HSSFSheet sheetys =  workbook.createSheet("����ʦ����ѧ����ɽ��");
				HSSFSheet sheetwc =  workbook.createSheet("����ʦ����ѧ�����ǣ�");

				//���ڴ��еĹ���������д�뵽 excel�ļ���
				FileOutputStream fos = new FileOutputStream(new File("xxx.xlsx"));
				workbook.write(fos);
				//ˢ�´��������ǿ���κλ��������ֽڱ�д��
				fos.flush();
				fos.close();
				workbook.close();
	}

}
