package com.app.dao;
 
import com.app.model.User;
import java.sql.*;
import java.util.*;
 
public class UserDao {
 
    public User findByCredentials(String username, String password) {
 
        User user = null;
 
        String sql = "SELECT * FROM Users WHERE username=? AND password=?";
 
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
 
            ps.setString(1, username);
            ps.setString(2, password);
 
            ResultSet rs = ps.executeQuery();
 
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setRole(rs.getString("role"));
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return user;
    }
    
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        
        try (Connection con = DBUtil.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
        	
        	User user;
            while (rs.next()) {
                	user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setRole(rs.getString("role"));
                    users.add(user);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return users;
    }
    

    public boolean addUser(String username, String password, String role){
    	boolean rowInserted = false;
    	
    	String INSERT_SQL = 
                "INSERT INTO Users (username, password, role) VALUES (?, ?, ?::role_type);";
    	
    	// Use try-with-resources to automatically close connections
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT_SQL)) {
        
            ps.setString(1, username);
            ps.setString(2, password);
            
            // The ?::role_type in SQL handles the conversion from String to Enum
            ps.setString(3, role); 

            rowInserted = ps.executeUpdate() > 0;
        } catch (Exception e) {
			e.printStackTrace();
		}
        
        return rowInserted;
    } 
}