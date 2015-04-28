package com.zgm.java.io.Serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = -4811716238630685410L;
	
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	private static class Employee extends Person {

		String title;

		private Employee(String name, int age, String title) {
			super(name, age);
			this.title = title;
		}

		@Override
		public String toString() {
			return "Employee{" + "name='" + name + '\'' +
					", age=" + age + '\'' +
					", title='" + title + '\'' +
					'}';
		}
	}

	public static void main(String[] args) {
		byte[] bytes;
		Person person1 = new Person("test1", 20);
		Person person2;
		Employee employee1 = new Employee("employee1", 25, "Manager");
		Employee employee2;

		ByteArrayOutputStream byteOutputStream = null;
		ObjectOutputStream objectOutputStream = null;

		ByteArrayInputStream byteArrayInputStream = null;
		ObjectInputStream objectInputStream = null;

		try {
			// generate byteArray.
			byteOutputStream = new ByteArrayOutputStream();
			objectOutputStream = new ObjectOutputStream(byteOutputStream);
			// serialize person1
			objectOutputStream.writeObject(person1);
			// serialize employee1
			objectOutputStream.writeObject(employee1);

			bytes = byteOutputStream.toByteArray();

			for (byte aByte : bytes) {
				System.out.print(aByte);
			}
			System.out.println();
			System.out.println("Bytes's length is :" + bytes.length);

			// generate Object from byteArray.
			byteArrayInputStream = new ByteArrayInputStream(bytes);
			objectInputStream = new ObjectInputStream(byteArrayInputStream);
			// deserialize person1
			person2 = (Person) objectInputStream.readObject();
			// deserialize employee1
			employee2 = (Employee) objectInputStream.readObject();
			System.out.println("person2 got from byteArray is : " + person2);
			System.out.println("employee2 got from byteArray is : " + employee2);

			System.out.println("person1's memory id :" + Integer.toHexString(person1.hashCode()));
			System.out.println("person2's memory id :" + Integer.toHexString(person2.hashCode()));
			System.out.println("employee1's memory id :" + Integer.toHexString(employee1.hashCode()));
			System.out.println("employee2's memory id :" + Integer.toHexString(employee2.hashCode()));

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} finally {
			try {
				byteOutputStream.close();
				objectOutputStream.close();
				byteArrayInputStream.close();
				objectInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
