package com.webApiApp.student.dao;
 
import com.webApiApp.student.model.Student;
import java.sql.*;
import java.util.*;
 
public class StudentDao {
 
    public Student findByRollNo(int rollNo) {
 
        Student student = null;
 
        String sql = "SELECT * FROM student WHERE rollNo=?";
 
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
 
            ps.setInt(1, rollNo);
 
            ResultSet rs = ps.executeQuery();
 
            if (rs.next()) {
                student = new Student();
                student.setRollNo(rs.getInt("rollNo"));
                student.setName(rs.getString("name"));
                student.setSubject(rs.getString("subject"));
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return student;
    }
    
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student";
        
        try (Connection con = DBUtil.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
        	
        	Student student;
            while (rs.next()) {
                	student = new Student();
                    student.setRollNo(rs.getInt("rollNo"));
                    student.setName(rs.getString("name"));
                    student.setSubject(rs.getString("subject"));
                    students.add(student);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return students;
    }
    

    public boolean addstudent(String name, String subject){
    	boolean rowInserted = false;
    	
    	String INSERT_SQL = 
                "INSERT INTO student (name, subject) VALUES (?, ?);";
    	
    	// Use try-with-resources to automatically close connections
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT_SQL)) {
        
            ps.setString(1, name);
            ps.setString(2, subject);

            rowInserted = ps.executeUpdate() > 0;
        } catch (Exception e) {
			e.printStackTrace();
		}
        
        return rowInserted;
    }

	public boolean deleteStudent(int rollNo) {
		boolean rowDeleted = false;
		
		String DELETE_SQL = 
                "DELETE FROM student WHERE rollNo=?";
		try (Connection con = DBUtil.getConnection();
	             PreparedStatement ps = con.prepareStatement(DELETE_SQL)) {
	        
	            ps.setInt(1, rollNo);

	            rowDeleted = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rowDeleted;
	}

	public boolean updateStudent(Student student) {
		boolean rowUpdated = false;
		String UPDATE_SQL = 
                "UPDATE student SET name = ?, subject = ? WHERE rollNo = ? ";
		try (Connection con = DBUtil.getConnection();
	             PreparedStatement ps = con.prepareStatement(UPDATE_SQL)) {
	        
	            ps.setString(2, student.getName());
	            ps.setString(1, student.getSubject());
	            ps.setInt(3, student.getRollNo());
	            
	            rowUpdated = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowUpdated;
	} 
}