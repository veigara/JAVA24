package com.hxzy.file;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class Demo1 {

	public static void main(String[] args) {
		//readFile();
		//createFile("F:\\java 24\\1.txt");
		//createDir("F:\\java 24\\dir\\1\\2");
		//delete("F:\\java 24\\1.txt");
		readSubFiles("F:\\java 24");
	}
	
	
	private static void delete(String pathname) {
		File f = new File(pathname);
		boolean flag = false;
		if (f.exists()) {
			flag = f.delete();
		}
		System.out.println(flag ?"ɾ���ɹ�":"ɾ��ʧ��");
	}
	
	private static void createDir(String pathname) {
		File f = new File(pathname);
		boolean mkdir = false;
		if (!f.exists()) {
			//mkdir() �������ļ���    F:\\java24\\dir
			//mkdirs() �����༶�ļ���  F:\\java 24\\dir\\1\\2
			mkdir = f.mkdirs();//����pathname��Ӧ���ļ���
		}
		System.out.println(mkdir?"�����ɹ�":"����ʧ��");
	}
	
	/**
	 * ����·�������ļ��Ĳ���
	 * @param pathName
	 */
	private static void createFile(String pathName) {
		File f = new File(pathName);
		//�ж�pathname��Ӧ��Ŀ¼���ļ��Ƿ����
		if (!f.exists()) {
			try {
				f.createNewFile();//����pathname������Ӧ���ļ�
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("�ļ�����" + f.getName());
	}

	/**
	 * ��ȡ�ļ����ԵĲ���
	 */
	private static void readFileByPath() {
		File f1 = new File("F:\\java 24\\JAVA24��ѧԱ����.xlsx");
		System.out.println("�ж��ļ���Ŀ¼�Ƿ���ڣ�" + f1.exists());
		System.out.println("�ж��Ƿ�Ϊ�ļ���" + f1.isFile());
		System.out.println("�ж��Ƿ�ΪĿ¼��" + f1.isDirectory());
		System.out.println("�ļ�����" + f1.getName());
		System.out.println("����·����" + f1.getAbsolutePath());
		System.out.println("�ļ����ȣ��ֽ�������" + f1.length() / 1024 + "KB");
	}

	/**
	 * ����·����ȡָ��·�������е�Ŀ¼���ļ�
	 * @param pathname
	 */
	private static void readSubFiles(String pathname) {
		File f = new File(pathname);
		if (f.exists()) {
			File[] listFiles = f.listFiles();//��ȡpathname�����е�Ŀ¼���ļ�������File��������
			System.out.println("����\t\t�Ƿ�Ŀ¼\t\t�޸�ʱ��");
			for (File file : listFiles) {
				Calendar c = Calendar.getInstance();
				c.setTime(new Date(file.lastModified()));
				StringBuilder sb = new StringBuilder()
						.append(c.get(Calendar.YEAR) + "��")
						.append(c.get(Calendar.MONTH) +  1 + "��")
						.append(c.get(Calendar.DATE) + "��");
				System.out.println(file.getName() + "\t" + file.isDirectory() + "\t" + sb.toString());
			}
		}
	}
}
