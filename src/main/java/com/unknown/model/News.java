package com.unknown.model;

import java.sql.Timestamp;

public class News extends AbstractModel<News> {
	private String title;
	private String thumbnail;
	private String shortDescription;
	private String content;
	private int idCategory;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public News() {
		super();
	}

	public News(int id, Timestamp createdDate, Timestamp modifiedDate, Timestamp createdBy, Timestamp modifiedBy,
			String title, String thumbnail, String shortDescription, String content, int idCategory) {
		super(id, createdDate, modifiedDate, createdBy, modifiedBy);
		this.title = title;
		this.thumbnail = thumbnail;
		this.shortDescription = shortDescription;
		this.content = content;
		this.idCategory = idCategory;
	}
	

}
