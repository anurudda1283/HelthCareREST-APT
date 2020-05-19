package com.pro_rate.HelthCare;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class HospitalDataModel  {
	
	
	Connection con = null;
	
	public HospitalDataModel() {
		
		
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
	
	
	
	
	public List<Hospital> getHospital() {
		List<Hospital> pat = new ArrayList<Hospital>();
		
		String sql = "SELECT * FROM hospital";
		
		try {
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Hospital ho1 = new Hospital();
				
				ho1.setRegisterId(rs.getString(1));
				ho1.setName(rs.getString(2));
				ho1.setType(rs.getString(3));
				ho1.setAddress(rs.getString(4));
				ho1.setPhone(rs.getInt(5));
				
				pat.add(ho1);
				
			}
		} catch (Exception e) {
			System.out.println("catch 1 "+e);
		}
		return pat;

	}
	
	public Hospital getHospital(String registerId){
		
		String sqlq = "SELECT * FROM hospital WHERE registerId=" + registerId;
		Hospital ho1 = new Hospital();
		
		try {
			Statement st =  con.createStatement();
			ResultSet rs = st.executeQuery(sqlq);
					
					if(rs.next()) {	
						ho1.setRegisterId(rs.getString(1));
						ho1.setName(rs.getString(2));
						ho1.setType(rs.getString(3));
						ho1.setAddress(rs.getString(4));
						ho1.setPhone(rs.getInt(5));
					}
		
	} catch (Exception e) 
	{
		System.out.println("catch 2 "+e);
	}
	
	
		return ho1;
		
	}
	
	
	public void createHospital(Hospital hos1) {
		String sql = "INSERT INTO hospital VALUES (?,?,?,?,?)";
		
		
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
	
			st.setString(1, hos1.getRegisterId());
			st.setString(2, hos1.getName());
			st.setString(3, hos1.getType());
			st.setString(4,  hos1.getAddress());
			st.setInt(5, hos1.getPhone());
			
			st.execute();
			
		}catch(Exception e){
			
			System.out.println("catch 3 "+e);
			
		}
	}

		
	public void updateHospital(Hospital hos1) {
		String sql = "UPDATE hospital set registerId=? , Name=?, type=?, address=?, phone=?";
	
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, hos1.getRegisterId());
			st.setString(2, hos1.getName());
			st.setString(3, hos1.getType());
			st.setString(4, hos1.getAddress());
			st.setInt(5, hos1.getPhone());
			
			
			st.executeUpdate();
			
			
		}catch(Exception e){
			
			System.out.println("catch 4 "+e);
			
		}
	}
	
	
	public void deleteHospital(String registerId) {
		String sql = "delete from hospital where registerId=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, registerId);
            st.executeUpdate();
            
        } catch (Exception e){
            System.out.println("catch 5 "+e);
            
        }
            
    }
	
	
}

	
	
