package com.unknown.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.unknown.model.News;

public class NewsMapper implements IRowMapper<News> {

	@Override
	public News mapRow(ResultSet rs) {
		News news = new News();
		try {
			news.setId(rs.getInt("id"));
			news.setIdCategory(rs.getInt("idCategory"));
			news.setContent(rs.getNString("content"));
			news.setShortDescription(rs.getNString("shortDescription"));
			news.setThumbnail(rs.getString("thumbnail"));
			news.setTitle(rs.getNString("title"));
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
