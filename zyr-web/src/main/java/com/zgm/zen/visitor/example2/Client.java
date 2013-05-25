package com.zgm.zen.visitor.example2;

import java.util.ArrayList;
import java.util.List;

public class Client {

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {

		for(Employee emp : mockEmployee() ){
			emp.report();
		}
	}*/
	
	public static void main(String[] args) {

		for(Employee emp : mockEmployee() ){
//			emp.report();
			emp.accept(new Visitor());
		}
	}
	
	public static List<Employee> mockEmployee(){
		List<Employee> empList = new ArrayList<Employee>();
		
		CommonEmployee zhangSan = new CommonEmployee();
		zhangSan.setJob("编写Java程序，绝对的蓝领，苦工加搬运工");
		zhangSan.setName("张三");
		zhangSan.setSalary(1800);
		zhangSan.setSex(Employee.MALE);
		
		empList.add(zhangSan);
		
		CommonEmployee liSi = new CommonEmployee();
		liSi.setJob("页面美工，审美素质太不流行了");
		liSi.setName("李四");
		liSi.setSalary(1900);
		liSi.setSex(Employee.FEMALE);
		
		empList.add(liSi);
		
		Manager wangWu = new Manager();
		wangWu.setName("王五");
		wangWu.setPerformance("基本上是负值，但是会拍马屁");
		wangWu.setSalary(18760);
		wangWu.setSex(Employee.MALE);
		
		empList.add(wangWu);
		
		return empList;
		
	}

}
