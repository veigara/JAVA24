
package com.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class MyFileDownLoadAction extends ActionSupport {
	
	private String fileName;
	
	private InputStream inputStream;

	
	@Override
	public String execute() throws Exception {
		
		try {
			
			//1.上传文件的路径
			String path = ServletActionContext.getServletContext()
					     .getRealPath("/upload");
			
			
			path = path + "/" +fileName;		     
			 
			this.inputStream = new FileInputStream(path);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public InputStream getInputStream() {
		return inputStream;
	}


	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	
}
