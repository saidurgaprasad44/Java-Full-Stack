package javaPrograms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student>{
	
	private int rollNo;
	private String name;
	private String group;
	
	public Student(int rollNo, String name, String group) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.group = group;
	}

	public int getRollNo() {return rollNo;}
	public String getName() {return name;}
	public String getGroup() {return group;}
	
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", group=" + group + "]";
	}

	@Override
	public int compareTo(Student other) {
		// Natural order: Sort by name A to Z
		return this.getName().compareTo(other.getName());
	}
	
}


public class CollectionsWithComparableDemo {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student(101, "sai", "MPCs"), 
				new Student(102, "vaishu", "MECs"),
				new Student(103, "priya", "MPCs"),
				new Student(104, "bhuvana", "BiPC")
		);
		
		// Uses the built-in compareTo method automatically
		Collections.sort(students);
		System.out.println(students);

	}

}
