package com.model;

public class Student
{
	private int sid;
	private String sname;
	private String scity;
	private double spercentage;
	private String sclass;
	private String gender;
	private byte[] simg;
	private byte[] sdocs;
	public int getSid() {
		return sid;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", scity=" + scity + ", spercentage=" + spercentage
				+ ", sclass=" + sclass + ", gender=" + gender + "]";
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getScity() {
		return scity;
	}
	public void setScity(String scity) {
		this.scity = scity;
	}
	public double getSpercentage() {
		return spercentage;
	}
	public void setSpercentage(double spercentage) {
		this.spercentage = spercentage;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public byte[] getSimg() {
		return simg;
	}
	public void setSimg(byte[] simg) {
		this.simg = simg;
	}
	public byte[] getSdocs() {
		return sdocs;
	}
	public void setSdocs(byte[] sdocs) {
		this.sdocs = sdocs;
	}
}
