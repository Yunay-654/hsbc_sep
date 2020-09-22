package com.instagram.entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class ArrayList_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> l=new Stack<Employee>();
		Employee e1=new Employee();
		e1.setName("abc");
		e1.setPassword("aaa");
		Employee e2=new Employee();
		e2.setName("sqw");
		e2.setPassword("sss");
		//l.add("Rajesh");
		//l.add(new Integer(3));
		l.add(e1);
		l.add(e2);
		for(Employee oo:l) {
			System.out.println(oo.getName()+" "+oo.getPassword());
			/*
			 * if(oo instanceof Employee){
			 * Employee e=(Employee)oo;
			 * System.out.println(e.getName()+" "+e.getPassword());
			 * if(oo instanceof String){
			 * String s=(String)oo;
			 * System.out.println(s);
			 * }
			 * 
			 */
		}
		

	}

}
