package com.zgm.optimizeProgram.four;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ReadWriterWithBuffer {

	public static void main(String[] args){
		
		ReadWriterWithBuffer rw = new ReadWriterWithBuffer();
		long startTime = 0;
		long endTime = 0;
		
		try{
			startTime = System.currentTimeMillis();
			rw.readWrite("e:/SpringReference2.0RC2.chm", "e:/zgmTest.chm");
			endTime = System.currentTimeMillis();
			
			System.out.println("直接读取用时： " + (endTime - startTime));
			
			startTime = System.currentTimeMillis();
			rw.readWriteArray("e:/SpringReference2.0RC2.chm", "e:/zgmTest2.chm");;
			endTime = System.currentTimeMillis();
			System.out.println("利用系统缓冲读取用时1： " + (endTime - startTime));
			
			
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	public static void readWrite(String fileFrom, String fileTo) throws IOException{
		InputStream is = null;
		OutputStream os = null;
		
		try{
			
			is = new FileInputStream(fileFrom);
			os = new FileOutputStream(fileTo);
			
			while(true){
				int bytedata = is.read();
				
				if(bytedata == -1){
					break;
				}
				
				os.write(bytedata);
			}
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	
	
	public static void readWriteArray (String fileFrom, String fileTo) throws IOException{
		InputStream is = null;
		OutputStream os = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try{
			is = new FileInputStream(fileFrom);
			os = new FileOutputStream(fileTo);
//			int total = is.available();
//			byte[] buffer = new byte[total];
//			byte[] buffer = new byte[100 * 1024];
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(os);
			
			while(true){
//				int num = is.read(buffer);
				int num = bis.read();
				
				if(num == -1){
					break;
				}
				
//				bos.write(buffer);
				bos.write(num);
			}
			
		}finally{
			if(bos != null){
				bos.close();
			}
			
			if(bis != null){
				bis.close();
			}
		}
		
	}	
	
}
