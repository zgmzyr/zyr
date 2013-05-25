package com.zgm.zen.state.example1;

public class Lift implements ILift {

	@Override
	public void close() {

		System.out.println("电梯门关闭！");
	}

	@Override
	public void open() {
		System.out.println("电梯门打开！");
	}

	@Override
	public void run() {
		System.out.println("电梯上下运行起来！");
	}

	@Override
	public void stop() {

		System.out.println("电梯停止工作了！");
	}

}
