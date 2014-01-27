/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._10_demo._2_genericComponent;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: GenericComponent.java $Date: 2013-4-16 下午9:21:06 -0400 2013
 * @since 1.0
 * 
 */
public class GenericComponent {
    public void render() {
        ButtonRenderer renderer = new ButtonRenderer();
        renderer.render(new Button());
    }
}

abstract class Component {
}

abstract class ComponentRenderer <C extends Component> {
    abstract void render(C component);
}

class Button extends Component {
}

class ButtonRenderer extends ComponentRenderer<Button> {
    void render(Button button) {
        //界面渲染
    }
}


