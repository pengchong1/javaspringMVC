package com.lanou.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Per extends Person {

	public Per() {
		super();
		
	}

	public Per(String name, Integer age) {
		super(name, age);
		
	}
	

}
