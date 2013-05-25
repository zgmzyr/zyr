package com.zgm.zen.composite.common2;

import java.util.ArrayList;

/**
 * 叶子构件
 * @author Administrator
 *
 */
public class Leaf extends Component {

	//@Deprecated加上@Deprecated，在编译期间告诉调用者，你可以调用我这个方法，但是可能会出错
	@Deprecated
	public void add(Component component) throws UnsupportedOperationException {
		//空实现，直接抛弃一个“不支持请求”异常
		
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public ArrayList<Component> getChildren() {
		//空实现，直接抛弃一个“不支持请求”异常
		
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public void remove(Component component) {
		//空实现，直接抛弃一个“不支持请求”异常
		
		throw new UnsupportedOperationException();
	}

	/*可以覆写父类方法
	public void doSomething(){
		
	}
	*/
}
