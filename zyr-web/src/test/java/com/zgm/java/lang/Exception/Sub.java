package com.zgm.java.lang.Exception;

public class Sub implements Super {

	@Override
//	public void test() throws Exception { //TODO
//	public void test() { //ok
	public void test() throws RuntimeException { //ok
		// TODO Auto-generated method stub

	}

	@Override
//	public void tests() throws RuntimeException {
	public void test2() {  //ok
//	public void test2() throws Exception { //TODO error
		// TODO Auto-generated method stub

	}

}
