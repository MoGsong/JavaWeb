package com.gxnu;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
/**
 * 通过 File 类获取指定路径下的文件
 */
public class TestListFile {
    public static void main(String args[]) throws IOException {
        File f = new File("D:\\eclipse\\readme\\MY JAVA\\JavaSenior\\src\\com\\gxnu");
        System.out.println("*** 使用list()方法获取String数组 ***");
        //返回一个字符串数组，由文件名组成
        String[] fNameList = f.list();
        for (String fName : fNameList) {
            System.out.println(fName);
        }
        System.out.println("*** 使用listFiles()方法获取File数组 ***");
        //返回一个File数组，由File实例组成
        File[] fList = f.listFiles();
        for (File f1 : fList) {
            System.out.println(f1.getName());
        }
        //使用匿名内部类创建过滤器，过滤出.java结尾的文件
        System.out.println("*** 使用listFiles(filter)方法过滤出.java文件 ***");
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
