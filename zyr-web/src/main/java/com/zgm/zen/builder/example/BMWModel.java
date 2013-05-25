package com.zgm.zen.builder.example;

public class BMWModel extends CarModel {

	@Override
	protected void alarm() {
		System.out.println("宝马的喇叭声音是这样的！");
	}

	@Override
	protected void engineBoom() {
		System.out.println("宝马的引擎声音是这样的！");
	}

	@Override
	protected void start() {
		System.out.println("宝马跑起来了！");
	}

	@Override
	protected void stop() {
		System.out.println("宝马停下来了！");
	}

}
