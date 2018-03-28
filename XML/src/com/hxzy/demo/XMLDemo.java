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
		Document doc = DocumentHelper.createDocument();	//����һ���յ�document�ĵ�����
		Element books = doc.addElement("books");//Ϊdocument XML�ĵ���������Ӹ��ڵ�
	
		/*
		 * ����1�������������document������ĸ��ļ�
		 * ����2�����XML�ĸ�ʽ������������û��������
		 * 		createCompactFormat() ���գ�û������
		 * 		createPrettyPrint()		��������xml
		 * 
		 * */
		OutputFormat format = OutputFormat.createPrettyPrint();//����������xml
		try {
			XMLWriter writer = new XMLWriter(new FileWriter("books.xml"),format);
			writer.write(doc);  //��document�ĵ����������books.xml
			writer.close();		//�ر������
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void insert() {
		SAXReader reader = new SAXReader();//��ȡxml
		try {
			Document doc = reader.read(new FileReader("books.xml"));//����ĵ�����
			//��ȡ���ڵ�
			Element root = doc.getRootElement(); //books ���ڵ�
			if (root == null) {
				root = doc.addElement("books"); //��Ӹ��ڵ�
			}
			
			//XML�У�ֻ��ʶ�ַ���
			
			Element book1 = root.addElement("book");//�ڸ��ڵ������book�ӽڵ�
			book1.addElement("author").setText("³Ѹ");//����ӽڵ㲢���ı�ֵ
			book1.addElement("bookname").setText("����Ϧʰ");
			book1.addElement("price").setText("20");
			
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("gbk"); //���ñ��뷽ʽ
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
		SAXReader reader = new SAXReader();//��ȡxml
		try {
			Document doc = reader.read(new FileReader("books.xml"));
			Element root = doc.getRootElement();//��ȡ���ڵ�
			//List<Element> book = root.elements("book");//��ȡ���ڵ�������Ϊbook���ӽڵ�
			
			@SuppressWarnings("unchecked")
			Iterator<Element> it = root.elementIterator("book");
			while (it.hasNext()) {
				Element ele = it.next();//ÿһ��book�ڵ�
				/*
				 * Element  
				 * 		getText();	���ؽڵ���ı�����
				 * 		elementText(�ڵ�����)
				 * */
				String author = ele.elementText("author"); //��ȡbook�ڵ��У��ӽڵ�author���ı�
				String bookname = ele.elementText("bookname"); //��ȡbook�ڵ��У��ӽڵ�author���ı�
				String price = ele.elementText("price"); //��ȡbook�ڵ��У��ӽڵ�author���ı�
				
				System.out.println("���ߣ�" + author + ",������" + bookname + "�����۸�" + price );	
			}
			
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void readXPath() {
		
		/*ʹ��Xpath����XML����Ҫ���jaxen jar*/
		SAXReader reader = new SAXReader();//��ȡxml
		try {
			Document doc = reader.read(new FileReader("books.xml"));
			
			/*ͨ��Xpath��ȡ����ڵ�*/
			/*List<Element> nodes = doc.selectNodes("//books/book/bookname");
			for (Element e : nodes) {
				System.out.println(e.getText()); //��ȡ�ڵ��ı�
			}*/
			
			/*ͨ��Xpath��λ�����ڵ�*/
			Node node = doc.selectSingleNode("//books/book/price/@name");//��ȡprice�ڵ��°���name���ԵĽڵ�
			System.out.println(node.getStringValue());//��ȡ�ýڵ�name���Ե�ֵ,����۸�
			
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateAndRemove() {
		
		//��books.xml�����м۸����25��Ǯ�����Ǽ�5��
		SAXReader reader = new SAXReader();//��ȡxml
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
				Element ele = (Element) node;	//ɾ���ڵ�ʱ��Ӧ��ʹ�ñ�ɾ���ڵ�ĸ�������ɾ���ӽڵ�
				if (ele.elementText("author").equals("aaa")) {
					doc.getRootElement().remove(ele); //ͨ�����ڵ�ɾ��book�ڵ�
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
	 * ���ڴ��д���һ���յ�document����
	 * @return
	 */
	public Document createDocment() {
		Document doc = DocumentHelper.createDocument();
		return doc;
	}
	
	/**
	 * ����xml·����ȡ�Ѿ����ڵ�xml document
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
	 * ��document����д��path��Ӧ��xml
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
