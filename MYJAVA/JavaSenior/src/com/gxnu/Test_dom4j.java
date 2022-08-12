package com.gxnu;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * use dom4j to parser .xml file
 * @author Administrator
 */
public class Test_dom4j {
	public static void main(String[] args) throws DocumentException {
		//1、create SAXReader object 
		SAXReader saxReader = new SAXReader();
		
		//2、use saxReader.read get xml file and generate DOM tree Object
		Document dom = saxReader.read(new File("students.xml"));
		
		//3、get DOM tree root element
		Element root = dom.getRootElement();
		
		//4、get all child element of root element 
		List<Element> sons = root.elements();
		
		//5、for-each sons element and get attribution of element
		for (Element son : sons) {
			String name = son.elementText("name");
			String age = son.elementText("age");
			System.out.println(name + "," + age);
		}
	}
}
