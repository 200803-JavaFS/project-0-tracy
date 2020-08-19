package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.utils.ConnectionUtility;

public class UserDAO implements IUserDAO {
	
	@Override
	public List<User> getAllUsers() {
		
		try (Connection con = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM users;";
			
			Statement stmt = con.createStatement();
			
			List<User> list = new ArrayList<>();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User u = new User();
				u.setUserId(rs.getInt("user_id"));
				u.setLoginName(rs.getString("login_name"));
				u.setPassword(rs.getString("pass_word"));
				u.setEndUser(rs.getString("end_user"));
				u.setFirstName(rs.getString("first_name"));
				u.setLastName(rs.getString("last_name"));
				u.setDateOfBirth(rs.getInt("date_birth"));
				list.add(u);
			}
			
			return list;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public List<User> getAllCustomers() {
		try(Connection con = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM users WHERE end_user = 'Customer';";
			
			Statement stmt = con.createStatement();
			
			List<User> list = new ArrayList<>();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User u = new User();
				u.setUserId(rs.getInt("user_id"));
				u.setLoginName(rs.getString("login_name"));
				u.setPassword(rs.getString("pass_word"));
				u.setEndUser(rs.getString("end_user"));
				u.setFirstName(rs.getString("first_name"));
				u.setLastName(rs.getString("last_name"));
				u.setDateOfBirth(rs.getInt("date_birth"));
				list.add(u);
			}
			
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public User getUserById(int userId) {
		try(Connection con = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM users WHERE user_id = "+userId+";";
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				User u = new User();
				u.setUserId(rs.getInt("user_id"));
				u.setLoginName(rs.getString("login_name"));
				u.setPassword(rs.getString("pass_word"));
				u.setEndUser(rs.getString("end_user"));
				u.setFirstName(rs.getString("first_name"));
				u.setLastName(rs.getString("last_name"));
				u.setDateOfBirth(rs.getInt("date_birth"));
				return u;
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addUser(User u) {
		
		try(Connection con = ConnectionUtility.getConnection()){
			String sql = "INSERT INTO users (login_name, pass_word, end_user, first_name, last_name, date_birth)"
					+ "VALUES (?, ?, ?, ?, ?, ?);";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			int i = 0;
			stmt.setString(++i, u.getLoginName());
			stmt.setString(++i, u.getPassword());
			stmt.setString(++i, u.getEndUser());
			stmt.setString(++i, u.getFirstName());
			stmt.setString(++i, u.getLastName());
			stmt.setInt(++i, u.getDateOfBirth());
	
			stmt.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	
	
}
