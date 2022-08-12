package com.gxnu;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties ;
import java.util.Set;

import junit.framework.Test;
@SuppressWarnings("unused")
public class Test_properties {

	public static void main(String[] args) throws IOException {
		//读取.properties文件中的数据（即从文件向内存中传输数据>
		//1、创建java.util.Properties工具类的对象
		Properties properties = new Properties();
		//2、基于xxx.properties文件，得到一个字节输入流对象
		// Test.class.getclassLoader()基于当前类，创建一个类加载器（底层使用了java反射机制)
		InputStream is = Test.class.getClassLoader().getResourceAsStream("x.properties");//默认在项目的src下查找文件
		// 3、调用properties对象的load (方法，把输入流对象加载到内存
		properties.load(is);
		//4、获取xxx.properties文件中的数据，通常根据key获取value
		System.out.println("ip"+properties.get("ip"));

//		Iterator keys =  properties.keySet().iterator();
//		while(keys.hasNext()) {
//			System.out.println(keys.next());
//			System.out.println(":");
//			System.out.println(properties.get(keys.next()));
//		}
	}

}
