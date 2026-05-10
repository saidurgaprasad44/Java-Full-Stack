package com.webApiApp.student.service;

import java.util.List;

import com.webApiApp.student.dao.StudentDao;
import com.webApiApp.student.model.Student;

public class StudentService {
	StudentDao studentDao;
	public List<Student> getAllStudents()
	{
		studentDao=new StudentDao();
		return studentDao.findAll();
	}
	public Student getStudentbyRollNo(int rollNo) {
		studentDao=new StudentDao();
		return studentDao.findByRollNo(rollNo);
	}
	public boolean addStudent(Student student) {
		studentDao=new StudentDao();
		return(studentDao.addstudent(student.getName(), student.getSubject()));
	}
	public boolean removeStudent(int rollNo) {
		studentDao=new StudentDao();
		return studentDao.deleteStudent(rollNo);
	}
	public boolean modifyStudent(Student student) {
		studentDao=new StudentDao();
		return studentDao.updateStudent(student);
	}
}
