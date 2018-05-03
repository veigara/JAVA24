package com.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class MyFileUplaodAction extends ActionSupport {
	
	private String myFile;//上传的文件
	private String myFileContentType;//上传文件的类型
	private String myFileFileName;//上传文件的名称

	
	@Override
	public String execute() throws Exception {

		 try {
			 //1.获取输入流
			 InputStream in = new FileInputStream(myFile);
			 
			 //2.上传文件的路径
			 File toDir = new File(ServletActionContext.
					 getServletContext().getRealPath("/upload"));
			 
			 if(toDir.exists() == false){
				 toDir.mkdir();//创建文件夹
			 }
			 
			 //3.获得输出流
			 OutputStream out = new FileOutputStream(new File(toDir, myFileFileName));
			 
			 byte[] bs = new byte[1024];//二进制流数组
			 
			 int len = 0;
			 
			 while((len = in.read(bs)) != -1){
				 out.write(bs, 0, len);//写
			 }
			 
			 out.flush();
			 out.close();
			 in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	
	

	public String getMyFile() {
		return myFile;
	}


	public void setMyFile(String myFile) {
		this.myFile = myFile;
	}


	public String getMyFileContentType() {
		return myFileContentType;
	}


	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}


	public String getMyFileFileName() {
		return myFileFileName;
	}


	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
	
	
	
}
