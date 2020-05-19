package com.pro_rate.HelthCare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoctorDataModel {
	
Connection con = null;
	
	public DoctorDataModel() {
		
		
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
	
	
	
	
	public List<Doctor> getDoctor() {
		List<Doctor> pat = new ArrayList<Doctor>();
		
		String sql = "SELECT * FROM doctor";
		
		try {
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Doctor ho1 = new Doctor();
				
				ho1.setDoctorId(rs.getString(1));
				ho1.setName(rs.getString(2));
				ho1.setSpecialist(rs.getString(3));
				ho1.setPhone(rs.getInt(4));
				ho1.setEmail(rs.getString(5));
				
				pat.add(ho1);
				
			}
		} catch (Exception e) {
			System.out.println("catch 1 "+e);
		}
		return pat;

	}
	
	public Doctor getDoctor(String doctorId){
		
		String sqlq = "SELECT * FROM doctor WHERE doctorId=" + doctorId;
		Doctor do1 = new Doctor();
		
		try {
			Statement st =  con.createStatement();
			ResultSet rs = st.executeQuery(sqlq);
					
					if(rs.next()) {	
						do1.setDoctorId(rs.getString(1));
						do1.setName(rs.getString(2));
						do1.setSpecialist(rs.getString(3));
						do1.setPhone(rs.getInt(4));
						do1.setEmail(rs.getString(5));
					}
		
	} catch (Exception e) 
	{
		System.out.println("catch 2 "+e);
	}
	
	
		return do1;
		
	}
	
	
	public void createDoctor(Doctor doc1) {
		String sql = "INSERT INTO doctor VALUES (?,?,?,?,?)";
		
		
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
	
			st.setString(1, doc1.getDoctorId());
			st.setString(2, doc1.getName());
			st.setString(3, doc1.getSpecialist());
			st.setInt(4,  doc1.getPhone());
			st.setString(5, doc1.getEmail());
			
			st.execute();
			
		}catch(Exception e){
			
			System.out.println("catch 3 "+e);
			
		}
	}

		
	public void updateDoctor(Doctor doc1) {
		String sql = "UPDATE doctor set doctorId=? , name=?, specialist=?, phone=?, email=?";
	
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, doc1.getDoctorId());
			st.setString(2, doc1.getName());
			st.setString(3, doc1.getSpecialist());
			st.setInt(4, doc1.getPhone());
			st.setString(5, doc1.getEmail());
			
			
			st.executeUpdate();
			
			
		}catch(Exception e){
			
			System.out.println("catch 4 "+e);
			
		}
	}
	
	
	public void deleteDoctor(String doctorId) {
		String sql = "delete from doctor where doctorId=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, doctorId);
            st.executeUpdate();
            
        } catch (Exception e){
            System.out.println("catch 5 "+e);
            
        }
            
    }

}
