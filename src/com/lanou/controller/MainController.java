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
	//请求的处理
	//http://local:8080/Spring
	@RequestMapping(value="/aa.action",method=RequestMethod.GET)
	public String frontPage(){
		
		//方法要返回jsp的文件名
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
//	怎么获取请求的参数
//	1.在请求地址上添加{}字段，{}代表参数的代号
//	2.在方法的参数位置按如下结构写
//	@PathVariable(参数代号)实际参数类型 实际使用的参数名
//	在debug模式下，参数类型可以写成
//	@pathVariable 实际参数类型  参数代号
//	在controller中方法的参数位置可以选择两种写法
//	1.@RequstParam(参数1) 类型 实际使用的参数名
//	2.@RequetParam Map< 参数类型 ，值得类型> map 参数名
	
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
	
	//redirect 重定向
	
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
