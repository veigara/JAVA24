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
		System.out.println(flag ?"删除成功":"删除失败");
	}
	
	private static void createDir(String pathname) {
		File f = new File(pathname);
		boolean mkdir = false;
		if (!f.exists()) {
			//mkdir() 创建单文件夹    F:\\java24\\dir
			//mkdirs() 创建多级文件夹  F:\\java 24\\dir\\1\\2
			mkdir = f.mkdirs();//创建pathname对应的文件夹
		}
		System.out.println(mkdir?"创建成功":"创建失败");
	}
	
	/**
	 * 根据路径创建文件的操作
	 * @param pathName
	 */
	private static void createFile(String pathName) {
		File f = new File(pathName);
		//判断pathname对应的目录或文件是否存在
		if (!f.exists()) {
			try {
				f.createNewFile();//根据pathname创建对应的文件
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("文件名：" + f.getName());
	}

	/**
	 * 读取文件属性的操作
	 */
	private static void readFileByPath() {
		File f1 = new File("F:\\java 24\\JAVA24班学员档案.xlsx");
		System.out.println("判断文件或目录是否存在：" + f1.exists());
		System.out.println("判断是否为文件：" + f1.isFile());
		System.out.println("判断是否为目录：" + f1.isDirectory());
		System.out.println("文件名：" + f1.getName());
		System.out.println("绝对路径：" + f1.getAbsolutePath());
		System.out.println("文件长度（字节数）：" + f1.length() / 1024 + "KB");
	}

	/**
	 * 根据路径读取指定路径下所有的目录及文件
	 * @param pathname
	 */
	private static void readSubFiles(String pathname) {
		File f = new File(pathname);
		if (f.exists()) {
			File[] listFiles = f.listFiles();//读取pathname中所有的目录及文件，返回File对象数组
			System.out.println("名称\t\t是否目录\t\t修改时间");
			for (File file : listFiles) {
				Calendar c = Calendar.getInstance();
				c.setTime(new Date(file.lastModified()));
				StringBuilder sb = new StringBuilder()
						.append(c.get(Calendar.YEAR) + "年")
						.append(c.get(Calendar.MONTH) +  1 + "月")
						.append(c.get(Calendar.DATE) + "日");
				System.out.println(file.getName() + "\t" + file.isDirectory() + "\t" + sb.toString());
			}
		}
	}
}
