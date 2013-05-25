package com.zgm.zen.composite.common1b;

import java.util.ArrayList;

/**
 * 树枝构件
 * @author Administrator
 *
 */
public class Composite extends Component {

	//构件容器
	private ArrayList<Component> componentArrayList = new ArrayList<Component>();
	
	public void add(Component component){
		component.setParent(this);
		this.componentArrayList.add(component);
	}
	
	public void remove(Component component){
		this.componentArrayList.remove(component);
	}
	
	public ArrayList<Component> getChildren(){
		return this.componentArrayList;
	}
}
