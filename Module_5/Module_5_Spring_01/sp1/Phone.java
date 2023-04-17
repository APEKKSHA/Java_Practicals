package com.sp1;

public class Phone 
{
	int pno;
	// its an setter getter logic

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}
	
//	to create seperate method which is used in person class
	public void call()
	{
		System.out.println("phone no is.."+pno);
	}
}
