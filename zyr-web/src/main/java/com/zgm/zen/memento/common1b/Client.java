package com.zgm.zen.memento.common1b;
/**
 * 多状态的备忘录模式
 * @author Administrator
 *
 */
public class Client {

	public static void main(String[] args) {
		
		Originator originator = new Originator();
		
		Caretaker caretaker = new Caretaker();
		
		originator.setState1("中国");
		originator.setState2("强盛");
		originator.setState3("繁荣");
		
		System.out.println("=====初始化状态======\n" + originator);
		
		caretaker.setMemento(originator.createMemento());
		
		//修改状态值
		originator.setState1("软件");
		originator.setState2("架构");
		originator.setState3("优秀");
		System.out.println("\n=====修改后状态======\n" + originator);
		
		//恢复
		originator.restoreMemento(caretaker.getMemento());
		System.out.println("\n=====恢复后状态======\n" + originator);
		
	}
	/*public static void main(String[] args) {
		
		Originator originator = new Originator();
		
		Caretaker caretaker = new Caretaker();
		
		caretaker.setMemento("001", originator.createMemento());
		
		originator.restoreMemento(caretaker.getMemento());
	}*/
	
	/*public static void main(String[] args) {
		
		Originator originator = new Originator();
		
		Caretaker caretaker = new Caretaker();
		
		caretaker.setMemento(originator.createMemento());
		
		originator.restoreMemento(caretaker.getMemento());
	}*/

}
