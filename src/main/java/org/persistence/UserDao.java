package org.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.controller.User;

public class UserDao {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:8888/mkjw";
	private static final String username = "study";
	private static final String password = "study";
	
	public void addUser(User user) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
			pstmt = connection.prepareStatement("INSERT INTO user(userid, username, password, country, email, createdDate, modifiedDate) VALUES (?, ?, ?, ?, ?, NOW(), NOW())");
			
			pstmt.setString(1, user.getUserid());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getCountry());
			pstmt.setString(5, user.getEmail());
			
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) {}
			try { if(connection != null) connection.close(); } catch (Exception e) {}
		}
	}
	
	public void removeUser(String userid) {
		Connection connection = null;
		Statement stmt = null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
			stmt = connection.createStatement();
			
			stmt.executeUpdate("DELETE FROM user WHERE userid='" + userid + "'");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(stmt != null) stmt.close(); } catch (Exception e) {}
			try { if(connection != null) connection.close(); } catch (Exception e) {}
		}
	}
	
	public User findByUserid(String userid) {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
			stmt = connection.createStatement();
		
			rs = stmt.executeQuery("SELECT * FROM user WHERE userid='" + userid + "'");
			
			if(rs.next()) {
				User user = new User();
				user.setUserid(rs.getString("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setCountry(rs.getString("country"));
				user.setEmail(rs.getString("email"));
				user.setCreatedDate(rs.getDate("createdDate"));
				user.setModifiedDate(rs.getDate("modifiedDate"));
				
				return user;
			}else {
				return null;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch (Exception e) {}
			try { if(stmt != null) stmt.close(); } catch (Exception e) {}
			try { if(connection != null) connection.close(); } catch (Exception e) {}
		}
		
		return null;
	}
}
