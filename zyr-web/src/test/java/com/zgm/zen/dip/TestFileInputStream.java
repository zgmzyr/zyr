package com.zgm.zen.dip;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileInputStream {
	public static void main(String [] args){
		int b = 0;
		FileReader in = null;
		FileWriter out =null;
		try{
			in = new FileReader("c:/test/TestFile.java");
			try {
				out = new FileWriter("c:\\abc.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(FileNotFoundException e){
			System.out.println("Can't Found!");
			System.exit(-1);
		}
		try{
			long num=0;
			while((b = in.read())!= -1){
			//	out.write(b);
				System.out.print((char) b);
				num++;
			}
			in.close();
		//	out.close();
			System.out.println();
			System.out.println("read in total:"+ num);
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
}
