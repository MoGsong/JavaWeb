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
		//��ȡ.properties�ļ��е����ݣ������ļ����ڴ��д�������>
		//1������java.util.Properties������Ķ���
		Properties properties = new Properties();
		//2������xxx.properties�ļ����õ�һ���ֽ�����������
		// Test.class.getclassLoader()���ڵ�ǰ�࣬����һ������������ײ�ʹ����java�������)
		InputStream is = Test.class.getClassLoader().getResourceAsStream("x.properties");//Ĭ������Ŀ��src�²����ļ�
		// 3������properties�����load (��������������������ص��ڴ�
		properties.load(is);
		//4����ȡxxx.properties�ļ��е����ݣ�ͨ������key��ȡvalue
		System.out.println("ip"+properties.get("ip"));

//		Iterator keys =  properties.keySet().iterator();
//		while(keys.hasNext()) {
//			System.out.println(keys.next());
//			System.out.println(":");
//			System.out.println(properties.get(keys.next()));
//		}
	}

}
