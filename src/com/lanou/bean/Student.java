package com.lanou.bean;

import javax.xml.bind.annotation.XmlRootElement;


public class Student {
	private String name;
	private Integer age;
	private String habby;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getHabby() {
		return habby;
	}
	public void setHabby(String habby) {
		this.habby = habby;
	}

	
	
	
}
