package com;

public class Employee {
	private String usrId;
	private String password;
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employee(String usrId, String password) {
		super();
		this.usrId = usrId;
		this.password = password;
	}



}
