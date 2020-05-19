package com.pro_rate.HelthCare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDataModel {
	
	Connection con = null;
	
	public UserDataModel() {
		
		
		String url = "jdbc:mysql://localhost:3306/projectdb5";
		String username = "root";
		String password = "";
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			System.out.println(" connected");
		}
		catch(Exception e) {
			System.out.println("not connected" + e);
		}
	}
	
	
	
	
	public List<User> getUser() {
		List<User> usr = new ArrayList<User>();
		
		String sql = "SELECT * FROM user";
		
		try {
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				User ur1 = new User();
				
				ur1.setUserId(rs.getString(1));
				ur1.setName(rs.getString(2));
				ur1.setAddress(rs.getString(3));
				ur1.setPhone(rs.getInt(4));
				ur1.setEmail(rs.getString(5));
				ur1.setCard(rs.getInt(6));
				ur1.setValidDate(rs.getString(7));
				ur1.setCvcCode(rs.getInt(8));
				
				
				
				usr.add(ur1);
				
			}
		} catch (Exception e) {
			System.out.println("catch 1 "+e);
		}
		return usr;

	}
	
	public User getUser(String userId){
		
		String sqlq = "SELECT * FROM user WHERE userId=" + userId;
		User ur1 = new User();
		
		try {
			Statement st =  con.createStatement();
			ResultSet rs = st.executeQuery(sqlq);
					
					if(rs.next()) {	
						ur1.setUserId(rs.getString(1));
						ur1.setName(rs.getString(2));
						ur1.setAddress(rs.getString(3));
						ur1.setPhone(rs.getInt(4));
						ur1.setEmail(rs.getString(5));
						ur1.setCard(rs.getInt(6));
						ur1.setValidDate(rs.getString(7));
						ur1.setCvcCode(rs.getInt(8));
					}
		
	} catch (Exception e) 
	{
		System.out.println("catch 2 "+e);
	}
	
	
		return ur1;
		
	}
	
	
	public void createUser(User ur1) {
		String sql = "INSERT INTO user VALUES (?,?,?,?,?,?,?,?)";
		
		
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
	
			st.setString(1, ur1.getUserId());
			st.setString(2, ur1.getName());
			st.setString(3, ur1.getAddress());
			st.setInt(4,  ur1.getPhone());
			st.setString(5, ur1.getEmail());
			st.setInt(6, ur1.getCard());
			st.setString(7, ur1.getValidDate());
			st.setInt(8, ur1.getCvcCode());
			
			st.execute();
			
		}catch(Exception e){
			
			System.out.println("catch 3 "+e);
			
		}
	}

		
	public void updateUser(User ur1) {
		String sql = "UPDATE user set userId=? , name=?, address=?, phone=?, email=?, card=?, validDate=?, cvcCode=?";
	
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, ur1.getUserId());
			st.setString(2, ur1.getName());
			st.setString(3, ur1.getAddress());
			st.setInt(4, ur1.getPhone());
			st.setString(5, ur1.getEmail());
			st.setInt(6, ur1.getCard());
			st.setString(7, ur1.getValidDate());
			st.setInt(8, ur1.getCvcCode());
			
			st.executeUpdate();
			
			
		}catch(Exception e){
			
			System.out.println("catch 4 "+e);
			
		}
	}
	
	
	public void deleteUser(String userId) {
		String sql = "delete from user where userId=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, userId);
            st.executeUpdate();
            
        } catch (Exception e){
            System.out.println("catch 5 "+e);
            
        }
            
    }

}
