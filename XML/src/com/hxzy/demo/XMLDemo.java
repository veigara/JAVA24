package com.hxzy.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Ignore;
import org.junit.Test;

public class XMLDemo {
	
	
	@Test
	@Ignore
	public void createXML() {
		Document doc = DocumentHelper.createDocument();	//创建一个空的document文档对象
		Element books = doc.addElement("books");//为document XML文档对象中添加根节点
	
		/*
		 * 参数1：输出流，代表将document输出到哪个文件
		 * 参数2：输出XML的格式，（有缩进和没有缩进）
		 * 		createCompactFormat() 紧凑，没有缩进
		 * 		createPrettyPrint()		有缩进的xml
		 * 
		 * */
		OutputFormat format = OutputFormat.createPrettyPrint();//具有缩进的xml
		try {
			XMLWriter writer = new XMLWriter(new FileWriter("books.xml"),format);
			writer.write(doc);  //将document文档对象输出到books.xml
			writer.close();		//关闭输出流
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void insert() {
		SAXReader reader = new SAXReader();//读取xml
		try {
			Document doc = reader.read(new FileReader("books.xml"));//获得文档对象
			//获取根节点
			Element root = doc.getRootElement(); //books 根节点
			if (root == null) {
				root = doc.addElement("books"); //添加根节点
			}
			
			//XML中，只认识字符串
			
			Element book1 = root.addElement("book");//在根节点下添加book子节点
			book1.addElement("author").setText("鲁迅");//添加子节点并设文本值
			book1.addElement("bookname").setText("朝花夕拾");
			book1.addElement("price").setText("20");
			
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("gbk"); //设置编码方式
			XMLWriter writer = new XMLWriter(new FileWriter("books.xml"), format);
			writer.write(doc);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void readXml() {
		SAXReader reader = new SAXReader();//读取xml
		try {
			Document doc = reader.read(new FileReader("books.xml"));
			Element root = doc.getRootElement();//获取根节点
			//List<Element> book = root.elements("book");//获取根节点下名称为book的子节点
			
			@SuppressWarnings("unchecked")
			Iterator<Element> it = root.elementIterator("book");
			while (it.hasNext()) {
				Element ele = it.next();//每一个book节点
				/*
				 * Element  
				 * 		getText();	返回节点的文本内容
				 * 		elementText(节点名称)
				 * */
				String author = ele.elementText("author"); //获取book节点中，子节点author的文本
				String bookname = ele.elementText("bookname"); //获取book节点中，子节点author的文本
				String price = ele.elementText("price"); //获取book节点中，子节点author的文本
				
				System.out.println("作者：" + author + ",书名《" + bookname + "》，价格" + price );	
			}
			
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void readXPath() {
		
		/*使用Xpath解析XML，需要添加jaxen jar*/
		SAXReader reader = new SAXReader();//读取xml
		try {
			Document doc = reader.read(new FileReader("books.xml"));
			
			/*通过Xpath获取多个节点*/
			/*List<Element> nodes = doc.selectNodes("//books/book/bookname");
			for (Element e : nodes) {
				System.out.println(e.getText()); //获取节点文本
			}*/
			
			/*通过Xpath定位单个节点*/
			Node node = doc.selectSingleNode("//books/book/price/@name");//获取price节点下包含name属性的节点
			System.out.println(node.getStringValue());//获取该节点name属性的值,输出价格
			
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateAndRemove() {
		
		//将books.xml中所有价格低于25块钱的书涨价5块
		SAXReader reader = new SAXReader();//读取xml
		try {
			Document doc = reader.read(new FileReader("books.xml"));
			List<Node> list = doc.selectNodes("//books/book/price");
			for (Node node : list) {
				double price = Double.parseDouble(node.getText());
				if (price < 25) {
					price += 5;
					node.setText(Double.toString(price));
				}
			}
			
			List<Node> nodes = doc.selectNodes("//books/book");
			for (Node node : nodes) {
				Element ele = (Element) node;	//删除节点时，应该使用被删除节点的父几点来删除子节点
				if (ele.elementText("author").equals("aaa")) {
					doc.getRootElement().remove(ele); //通过根节点删除book节点
				}
			}
			
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("GBK");
			XMLWriter writer = new XMLWriter(new FileWriter("books.xml", false), format);
			writer.write(doc);
			writer.close();
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 在内存中创建一个空的document对象
	 * @return
	 */
	public Document createDocment() {
		Document doc = DocumentHelper.createDocument();
		return doc;
	}
	
	/**
	 * 根据xml路径获取已经存在的xml document
	 * @param path
	 * @return
	 */
	public Document getDocument(String path) {
		SAXReader reader = new SAXReader();
		try {
			return reader.read(new FileReader(path));
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将document对象写到path对应的xml
	 * @param doc
	 * @param path
	 */
	public void writeXml(Document doc,String path) {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");
		try {
			XMLWriter writer = new XMLWriter(new FileWriter(path), format);
			writer.write(doc);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
