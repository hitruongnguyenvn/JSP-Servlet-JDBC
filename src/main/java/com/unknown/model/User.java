package com.unknown.model;

import java.sql.Timestamp;

public class User extends AbstractModel<User> {
	private String userName;
	private String passWord;
	private String fullName;
	private int status;
	private int idRole;
	private Role role;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User() {
		super();
	}

	public User(int id, Timestamp createdDate, Timestamp modifiedDate, Timestamp createdBy, Timestamp modifiedBy,
			String userName, String passWord, String fullName, int status) {
		super(id, createdDate, modifiedDate, createdBy, modifiedBy);
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
		this.status = status;
	}
}
