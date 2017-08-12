package com.lanou.controller;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.bean.Per;
import com.lanou.bean.Person;
import com.lanou.bean.Student;
import com.lanou.bean.User;
import com.sun.org.glassfish.gmbal.ParameterNames;

@Controller
public class MainController {
	//����Ĵ���
	//http://local:8080/Spring
	@RequestMapping(value="/aa.action",method=RequestMethod.GET)
	public String frontPage(){
		
		//����Ҫ����jsp���ļ���
		// WEB-INF/PAGE/index.jsp
		
		return "index";
	}
	@RequestMapping(value="/stu",method=RequestMethod.GET)
	@ResponseBody
	/*@XmlRootElement(name="xml")*/
	public Student jsonDate(){
		Student stu=new Student();
		stu.setAge(14);
		stu.setHabby("study");
		stu.setName("pc");

		return stu;
	}
	@RequestMapping(value="/per",method=RequestMethod.GET)
	@ResponseBody
	public Per xmlDate(){
		
		return new Per("pc", 12);

	}
	//http://.../studata/lunshun
//	��ô��ȡ����Ĳ���
//	1.�������ַ�����{}�ֶΣ�{}��������Ĵ���
//	2.�ڷ����Ĳ���λ�ð����½ṹд
//	@PathVariable(��������)ʵ�ʲ������� ʵ��ʹ�õĲ�����
//	��debugģʽ�£��������Ϳ���д��
//	@pathVariable ʵ�ʲ�������  ��������
//	��controller�з����Ĳ���λ�ÿ���ѡ������д��
//	1.@RequstParam(����1) ���� ʵ��ʹ�õĲ�����
//	2.@RequetParam Map< �������� ��ֵ������> map ������
	
	@RequestMapping(value="/studata/{name}/{age}",method=RequestMethod.GET)
	@ResponseBody
	public Student varStu(@PathVariable("name") String name, @PathVariable("age")Integer age ){
		Student stu=new Student();
		stu.setName(name);
		stu.setAge(age);
		return stu;
	}
	
	
	//http://../studata?name=xx&age=222
	@RequestMapping(value="/studata",method=RequestMethod.GET)
	@ResponseBody
	public Student paramStu(@RequestParam("na") String name,@RequestParam("age") Integer age){
		Student stu=new Student();
		stu.setName(name);
		stu.setAge(age);
		return stu;
	}
	@RequestMapping(value="/st",method=RequestMethod.GET)
	@ResponseBody
	public Student paramStu1(@RequestParam Map<String, Object> params){
		Student stu=new Student();
		System.out.println(params);
		return stu;
	}
	
	@RequestMapping(value="/user/{name}/{age}/{job}",method=RequestMethod.GET)
	@ResponseBody
	public User insert(@PathVariable("name") String name,@PathVariable("age") Integer age,@PathVariable("job") String job ){
	
		User user=new User();
		user.setAge(age);
		user.setJob(job);
		user.setName(name);
		return user;
	}
	
	@RequestMapping(value="/user1",method=RequestMethod.GET)
	@ResponseBody
	public User insert1(@RequestParam Map<String, String> param){
		User user=new User();
		user.setAge(Integer.parseInt(param.get("ag")));
		
		user.setJob(param.get("job"));
		user.setName(param.get("name"));
		System.out.println(param);
		
		return user;
	}
	@RequestMapping(value="/user2",method=RequestMethod.GET)
	@ResponseBody
	public User insert2(@RequestParam("name") String name,@RequestParam("age") Integer age ,@RequestParam("job") String job){
		User user=new User();
		user.setAge(age);
		user.setJob(job);
		user.setName(name);
		
		return user;
	}
	
	@RequestMapping(value="/s")
	@ResponseBody
	public Student stuInfo(Student student){
		System.out.println(student);
		return student;
	}
	
	//redirect �ض���
	
	@RequestMapping(value="/redi")
	public String redi(){
		return "redirect:stu";
	}
	//forward
	@RequestMapping(value="/forword")
	public String forword(){
		return "forward:stu";
	}
}
