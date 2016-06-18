package com.allen.test.space;

/**
 * @author Administrator
 * @description 一个父的测试类
 *
 */
public class BaseTest {
	
	public int book = 6;

	public void base(){
		System.out.println("父类普通方法");
	}

	public void test(){
		System.out.println("父类要被覆盖的方法");
	}
}
