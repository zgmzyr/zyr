/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._10_demo._1_component;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: NormalComponent.java $Date: 2013-4-16 下午9:18:02 -0400
 *          2013
 * @since 1.0
 * 
 */

public class NormalComponent {
	public void render() {
		ButtonRenderer renderer = new ButtonRenderer();
		renderer.render(new Button());
		renderer.render(new Label());
	}
}

abstract class Component {
}

abstract class ComponentRenderer {
	abstract void render(Component window);
}

class Button extends Component {
}

class Label extends Component {
}

class ButtonRenderer extends ComponentRenderer {
	void render(Component window) {
		if (window instanceof Button) {
			// 界面渲染
		} else {
			throw new IllegalArgumentException();
		}
	}
}
