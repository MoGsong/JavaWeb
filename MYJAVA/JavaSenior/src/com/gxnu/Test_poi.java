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
		// apache pio 技术对C:\Users\johny\Desktop\xxx.xslx文件进行“写操作”
				//1、创建一个工作簿对象
				HSSFWorkbook workbook = new HSSFWorkbook();
				//2、创建一个工作表对象
				HSSFSheet sheetyc =  workbook.createSheet("广西师范大学（育才）");
				//3、创建一个行对象
				HSSFRow row1 = sheetyc.createRow(0);
				//4、创建一个单元格对象
				HSSFCell cell1 = row1.createCell(0);
				//5、向单元格中写入数据，且可以设置单元格类型
				cell1.setCellType(CellType.STRING);
				cell1.setCellValue("张阿三");
				//4、创建一个单元格对象
				HSSFCell cell2 = row1.createCell(1);
				//5、向单元格中写入数据，且可以设置单元格类型
				cell2.setCellType(CellType.STRING);
				cell2.setCellValue("18");
				
				//3、创建一个行对象
				HSSFRow row2 = sheetyc.createRow(1);
				//4、创建一个单元格对象
				cell1 = row2.createCell(0);
				
				//5、向单元格中写入数据，且可以设置单元格类型
				cell1.setCellType(CellType.STRING);
				cell1.setCellValue("李四");
				
				//4、创建一个单元格对象
				cell2 = row2.createCell(1);
				
				//5、向单元格中写入数据，且可以设置单元格类型
				cell2.setCellType(CellType.STRING);
				cell2.setCellValue("21");
				
				HSSFSheet sheetys =  workbook.createSheet("广西师范大学（雁山）");
				HSSFSheet sheetwc =  workbook.createSheet("广西师范大学（王城）");

				//把内存中的工作簿数据写入到 excel文件中
				FileOutputStream fos = new FileOutputStream(new File("xxx.xlsx"));
				workbook.write(fos);
				//刷新此输出流并强制任何缓冲的输出字节被写出
				fos.flush();
				fos.close();
				workbook.close();
	}

}
