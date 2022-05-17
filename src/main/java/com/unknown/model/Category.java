package com.unknown.model;

import java.sql.Timestamp;

public class Category extends AbstractModel<Category> {
	private String name;
	private String code;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Category() {
		super();
	}

	public Category(int id, Timestamp createdDate, Timestamp modifiedDate, Timestamp createdBy, Timestamp modifiedBy,
			String name, String code) {
		super(id, createdDate, modifiedDate, createdBy, modifiedBy);
		this.name = name;
		this.code = code;
	}
}
