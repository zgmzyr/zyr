package com.zgm.tdd.fourth._5_2;

import org.junit.Before;


/**
 * 夹具模式：
 * 1：参数化创建方法
 * 2：对象母亲
 * 3：自动清理
 * @author zgm
 *
 *以下1：参数化创建方法 的示例
 */
public class ParameterizedCreationMethodExample {
	Person alice, billy, clark;
	
	/*@Before
	public void setUp() throws Exception {
		alice = new Persion();
		
		alice.setId(1L);
		alice.setFirstName("Alice");
		alice.setLastName("Adams");
		alice.setSsn("11111");
		
		billy = new Persion();
		billy.setId(1L);
		billy.setFirstName("billy");
		billy.setLastName("Adams");
		billy.setSsn("22222");
		
		clark = new Persion();
		clark.setId(1L);
		clark.setFirstName("clark");
		clark.setLastName("Adams");
		clark.setSsn("3333");
	}*/
	
	@Before
	public void setUp() throws Exception {
		alice = this.createPerson("Alice", "Alice2");
		billy = this.createPerson("billy", "billy2");
		clark = this.createPerson("clark", "clark2");
	}

	private Person createPerson(String firstName, String lastName) {
		Person person = new Person();
		
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setId(UniqueNumber.next());
		person.setSsn(String.valueOf(UniqueNumber.next()));
		
		return person;
	}
}
