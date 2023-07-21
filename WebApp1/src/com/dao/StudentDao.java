package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;
import com.util.myConnection;

public class StudentDao {
	public int insertStudent(Student s) {
		int check = 0;
		String sql = "insert into student (sname,scity,spercentage,gender,sclass,simg,sdocs)values(?,?,?,?,?,?,?)";
		try (Connection con = myConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, s.getSname());
			pst.setString(2, s.getScity());
			pst.setDouble(3, s.getSpercentage());
			pst.setString(4, s.getGender());
			pst.setString(5, s.getSclass());
			pst.setBytes(6, s.getSimg());
			pst.setBytes(7, s.getSdocs());
			check = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
//--------------------------------------------------------------------------------------------------------------

	public int deleteStudentById(int sid) {
		int check = 0;
		String sql = "delete from student where sid=?";
		try (Connection con = myConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, sid);
			check = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
//--------------------------------------------------------------------------------------------------------------

	public List<Student> displayAllStudent() {
		List<Student> list = new ArrayList();
		String sql = "select sid,sname,scity,spercentage,sclass,gender,simg,sdocs from student";
		try (Connection con = myConnection.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				Student s = new Student();
				s.setSid(rs.getInt("sid"));
				s.setSname(rs.getString("sname"));
				s.setScity(rs.getString("scity"));
				s.setSpercentage(rs.getDouble("spercentage"));
				s.setSclass(rs.getString("sclass"));
				s.setGender(rs.getString("gender"));
				s.setSimg(rs.getBytes("simg"));
				s.setSdocs(rs.getBytes("sdocs"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
//--------------------------------------------------------------------------------------------------------------

	public Student displayStudentById(int sid) {
		Student s = null;
		String sql = "select sid,sname,scity,spercentage,sclass,gender,simg,sdocs from student where sid=?";
		try (Connection con = myConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, sid);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				s = new Student();
				s.setSid(rs.getInt("sid"));
				s.setSname(rs.getString("sname"));
				s.setScity(rs.getString("scity"));
				s.setSpercentage(rs.getDouble("spercentage"));
				s.setSclass(rs.getString("sclass"));
				s.setGender(rs.getString("gender"));
				s.setSimg(rs.getBytes("simg"));
				s.setSdocs(rs.getBytes("sdocs"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
//--------------------------------------------------------------------------------------------------------------

	public int updateStudentById(Student s) {
		int check = 0;
		String sql = "update student set sname=?,scity=?,spercentage=?,gender=?,sclass=?,simg=?,sdocs=? where sid=?";
		try (Connection con = myConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, s.getSname());
			pst.setString(2, s.getScity());
			pst.setDouble(3, s.getSpercentage());
			pst.setString(4, s.getGender());
			pst.setString(5, s.getSclass());
			pst.setBytes(6, s.getSimg());
			pst.setBytes(7, s.getSdocs());
			pst.setInt(8, s.getSid());
			check = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
//--------------------------------------------------------------------------------------------------------------
	
	public byte[] displayImageById(int sid) 
	{
		byte[] img=null;
		String sql="select simg from student where sid=?";
		try(Connection con=myConnection.getConnection();
				PreparedStatement pst=con.prepareStatement(sql);)
		{
			pst.setInt(1, sid);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) 
			{
				img=rs.getBytes("simg");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return img;
	}
//--------------------------------------------------------------------------------------------------------------

	public byte[] displayDocsById(int sid) 
	{
		byte[] docs=null;
		String sql="select sdocs from student where sid=?";
		try(Connection con=myConnection.getConnection();
				PreparedStatement pst=con.prepareStatement(sql);)
		{
			pst.setInt(1, sid);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) 
			{
				docs=rs.getBytes("sdocs");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return docs;
	}
}

