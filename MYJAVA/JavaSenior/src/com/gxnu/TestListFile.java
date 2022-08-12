package com.gxnu;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
/**
 * ͨ�� File ���ȡָ��·���µ��ļ�
 */
public class TestListFile {
    public static void main(String args[]) throws IOException {
        File f = new File("D:\\eclipse\\readme\\MY JAVA\\JavaSenior\\src\\com\\gxnu");
        System.out.println("*** ʹ��list()������ȡString���� ***");
        //����һ���ַ������飬���ļ������
        String[] fNameList = f.list();
        for (String fName : fNameList) {
            System.out.println(fName);
        }
        System.out.println("*** ʹ��listFiles()������ȡFile���� ***");
        //����һ��File���飬��Fileʵ�����
        File[] fList = f.listFiles();
        for (File f1 : fList) {
            System.out.println(f1.getName());
        }
        //ʹ�������ڲ��ഴ�������������˳�.java��β���ļ�
        System.out.println("*** ʹ��listFiles(filter)�������˳�.java�ļ� ***");
        File[] fileList = f.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
                return pathname.getName().contains(".java");
			}
		});
        for (File f1 : fileList) {
            System.out.println(f1.getName());
        }
    }
}
