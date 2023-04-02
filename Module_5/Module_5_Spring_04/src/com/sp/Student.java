package com.sp;

public class Student 
{
	private int sid;
	private String fname,lname,email,mobile;
	public int getId() {
		return sid;
	}
	public void setId(int sid) {
		this.sid = sid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String toString()
	{
		return "Student "+sid+" Details:  \n Name:"+fname+" "+lname+"\nEmail"+email+"\nMobile:"+mobile;
	}
}
