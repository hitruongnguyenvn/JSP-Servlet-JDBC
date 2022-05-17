package com.unknown.model;

import java.sql.Timestamp;

public class Comment extends AbstractModel<Comment> {
	private String content;
	private int idUser;
	private int idNews;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdNews() {
		return idNews;
	}

	public void setIdNews(int idNews) {
		this.idNews = idNews;
	}

	public Comment() {
		super();
	}

	public Comment(int id, Timestamp createdDate, Timestamp modifiedDate, Timestamp createdBy, Timestamp modifiedBy,
			String content, int idUser, int idNews) {
		super(id, createdDate, modifiedDate, createdBy, modifiedBy);
		this.content = content;
		this.idUser = idUser;
		this.idNews = idNews;
	}

}
