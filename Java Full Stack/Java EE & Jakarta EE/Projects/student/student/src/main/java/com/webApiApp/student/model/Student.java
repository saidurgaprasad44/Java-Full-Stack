package com.webApiApp.student.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	private int rollNo;
	private String name;
	private String subject;
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public Student() {
		
	}
	
	
//	public Student(int rollNo, String name, String subject) {
//		super();
//		this.rollNo = rollNo;
//		this.name = name;
//		this.subject = subject;
//	}
	
	
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", subject=" + subject + "]";
	}
}
