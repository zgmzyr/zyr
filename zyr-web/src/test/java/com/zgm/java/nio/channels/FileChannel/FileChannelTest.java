package com.zgm.java.nio.channels.FileChannel;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class FileChannelTest {

	@Test
	public void write() throws IOException {
		File file = new File("/home/zgm/test", "zyr.json");
		if (!file.exists()) {
//			if (file.mkdirs()) {
				file.createNewFile();
//			};
		}
		try (FileChannel fileChannel = new FileOutputStream(file).getChannel()) {
			ClassA classA = new ClassA();
			classA.setAge(20);
			classA.setName("自由人");
			String jsonString = JSON.toJSONString(classA);
//			byte[] jsonByteArray = JSON.toJSONBytes(classA);

//			CharBuffer byteBuffer = CharBuffer.allocate(1024);
//			byte[] bytes = jsonString.getBytes("GBK");
//			byte[] bytes = jsonString.getBytes("UTF-8");
			byte[] bytes = jsonString.getBytes();
//			ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
			int capacity = 1024;
			ByteBuffer byteBuffer = ByteBuffer.allocate(capacity);
			
			assertEquals(byteBuffer.position(),  0);
			assertEquals(byteBuffer.capacity(), capacity);
			assertEquals(byteBuffer.limit(), capacity);
			assertEquals(byteBuffer.remaining(), byteBuffer.limit() - byteBuffer.position());
			
			byteBuffer.put(bytes);

			assertEquals(byteBuffer.position(), bytes.length);
			assertEquals(byteBuffer.capacity(), capacity);
			assertEquals(byteBuffer.limit(), capacity);
			assertEquals(byteBuffer.remaining(), capacity - bytes.length);

			byteBuffer.flip();

			assertEquals(byteBuffer.position(), 0);
			assertEquals(byteBuffer.capacity(), capacity);
			assertEquals(byteBuffer.limit(), bytes.length);
			assertEquals(byteBuffer.remaining(), bytes.length);

//			byteBuffer.put(jsonByteArray);
//			byteBuffer.wrap(array);
			fileChannel.write(byteBuffer);

			assertEquals(byteBuffer.position(), bytes.length);
			assertEquals(byteBuffer.capacity(), capacity);
			assertEquals(byteBuffer.limit(), bytes.length);
			assertEquals(byteBuffer.remaining(), 0);
			
			byteBuffer.mark();
			assertEquals(byteBuffer.position(), bytes.length);
			assertEquals(byteBuffer.capacity(), capacity);
			assertEquals(byteBuffer.limit(), bytes.length);
			assertEquals(byteBuffer.remaining(), 0);
			
//			byteBuffer.position(byteBuffer.positon() - 1);
			byteBuffer.limit(byteBuffer.limit() + 1);
			byteBuffer.put((byte)1);
//			byteBuffer.position(byteBuffer.position());
			assertEquals(byteBuffer.position(), bytes.length + 1);
			assertEquals(byteBuffer.capacity(), capacity);
			assertEquals(byteBuffer.limit(), bytes.length + 1);
			assertEquals(byteBuffer.remaining(), 0);

			byteBuffer.reset();
			assertEquals(byteBuffer.position(), bytes.length); //回到mark时的大小
			assertEquals(byteBuffer.capacity(), capacity);
			assertEquals(byteBuffer.limit(), bytes.length + 1); //不会回
			assertEquals(byteBuffer.remaining(), 1);

			byteBuffer.rewind();
			assertEquals(byteBuffer.position(), 0);
			assertEquals(byteBuffer.capacity(), capacity);
			assertEquals(byteBuffer.limit(), bytes.length + 1);
			assertEquals(byteBuffer.remaining(), bytes.length + 1);
			
			
			
			byteBuffer.clear();
			assertEquals(byteBuffer.position(), 0);
			assertEquals(byteBuffer.capacity(), capacity);
			assertEquals(byteBuffer.limit(), capacity);
			assertEquals(byteBuffer.remaining(), capacity);

			fileChannel.force(true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void read() {
		File file = new File("/home/zgm/test", "zyr.json");
		
		try (FileChannel fileChannel = new FileInputStream(file).getChannel()) {
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			
			fileChannel.read(byteBuffer);
			byteBuffer.flip();
//			byteBuffer.rewind();
			
			byte[] dst = new byte[byteBuffer.limit()];
			byteBuffer.get(dst);
			String x = new String(dst);
//			String x = new String(dst, "GBK");
			System.out.println(x);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static class ClassA {
		private String name;
		private int age;
		public String getName() {
			return name;
		}
		public int getAge() {
			return age;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
		
	}
}
