package com.allen.test.space;

public class SubTest extends BaseTest {
	
	public String book = "子类隐藏父类的book变量";
	
	public void sub(){
		System.out.println("子类普通方法");
	}
	
	public void test(){
		System.out.println("子类覆盖父类的方法");
	}
	
	public static void main(String[] args) {
		BaseTest  base = new SubTest();
		
		System.out.println(base.book);
		
		base.test();
	}

}
