package com.allen.test.space;

public class SubTest extends BaseTest {
	
	public String book = "�������ظ����book����";
	
	public void sub(){
		System.out.println("������ͨ����");
	}
	
	public void test(){
		System.out.println("���า�Ǹ���ķ���");
	}
	
	public static void main(String[] args) {
		BaseTest  base = new SubTest();
		
		System.out.println(base.book);
		
		base.test();
	}

}
