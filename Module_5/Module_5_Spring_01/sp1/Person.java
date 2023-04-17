package com.sp1;

public class Person 
{
	String pname;
	Phone phone;
	//setter getter logic
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	public void callPhone()
	{
		System.out.println("pname is:"+pname);
		phone.call();//to call the phone class method
	}
}
