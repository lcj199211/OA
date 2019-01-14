package com.casd.controller.web.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadUtil {

	public static  void saveUrlAs(String fileurl, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			File file = new File(fileurl);  
	        String fileName = fileurl.substring(fileurl.lastIndexOf(File.separator)+1);//得到文件名  
	        fileName = new String(fileName.getBytes("UTF-8"),"ISO8859-1");
			// 将文件读入文件流
			InputStream inStream = new FileInputStream(fileurl);
			// 设置HTTP响应头
			response.setContentType("multipart/form-data");  
	        response.addHeader("Content-Disposition", "attachment;filename="+fileName);
	        String len = String.valueOf(file.length());  
	        response.setHeader("Content-Length", len);//设置内容长度  
	        OutputStream out = response.getOutputStream(); 
			// 循环取出流中的数据
	        byte[] b = new byte[1024];  
	        int n;  
	        while((n=inStream.read(b))!=-1){  
	            out.write(b, 0, n);  
	        }  
			inStream.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 //
	 public static  byte[] readInputStream(InputStream inputStream) throws IOException {    
	        byte[] buffer = new byte[1024];    
	        int len = 0;    
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();    
	        while((len = inputStream.read(buffer)) != -1) {    
	            bos.write(buffer, 0, len);    
	        }    
	        bos.close();    
	        return bos.toByteArray();    
	    }    
}