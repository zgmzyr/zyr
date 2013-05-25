package com.zgm.zen.builder.example3;

public class BenzModel extends CarModel {

	@Override
	protected void alarm() {
		System.out.println("奔驰车的喇叭声音是这样的！");
	}

	@Override
	protected void engineBoom() {
		System.out.println("奔驰车的引擎声音是这样的！");
	}

	@Override
	protected void start() {
		System.out.println("奔驰车跑起来了！");
	}

	@Override
	protected void stop() {
		System.out.println("奔驰车停下来了！");
	}

}
