package com.sunjian.bean;

import java.io.Serializable;

/*
 * 练习：单人信息管理程序：
 * 	
 * 		定义Person类：实现Serializable接口，因为要序列号对象
 */
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name ;
	private int age ;
	
	public Person(){}
	
	public Person(String name,int age){
		this.age = age;
		this.name = name;
	}
	
	public String toString(){
		return "姓名："+this.name+"，年龄："+this.age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
