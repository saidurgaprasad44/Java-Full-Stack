package com.webApiApp.student.resources;


import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.webApiApp.student.model.Student;
import com.webApiApp.student.service.StudentService;

@Path("students")
public class StudentResource {
	StudentService studentService;
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Student> getAllStudents()
	{
		studentService = new StudentService();
		System.out.println(studentService.getAllStudents().get(0));
		return studentService.getAllStudents();
	}
	
	@GET
	@Path("{rollNo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentbyRollNo(@PathParam("rollNo") int rollNo) 
	{
		studentService = new StudentService();
		return studentService.getStudentbyRollNo(rollNo);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
	public boolean addStudent(Student student)
	{
		studentService = new StudentService();
		
		return(studentService.addStudent(student));
	}
	
	@DELETE
	@Path("{rollNo}")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean removeStudent(@PathParam("rollNo") int rollNo) {
		studentService = new StudentService();
		
		return(studentService.removeStudent(rollNo));
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean modifyStudent(Student student) {
		studentService = new StudentService();
		
		return studentService.modifyStudent(student);
	}
	
	
}
