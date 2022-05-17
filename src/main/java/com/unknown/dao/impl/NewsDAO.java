package com.unknown.dao.impl;

import java.util.List;

import com.unknown.dao.INewsDAO;
import com.unknown.mapper.NewsMapper;
import com.unknown.model.News;
import com.unknown.paging.Pageble;

public class NewsDAO implements INewsDAO {

	@Override
	public int save(News news) {
		String sql = "INSERT INTO News (title, shortDescription, content, idCategory)" + "VALUES (?,?,?,?)";
		return DataProvider.getInstance().executeNonQuery(sql,
				new Object[] { news.getTitle(), news.getShortDescription(), news.getContent(), news.getIdCategory() });
	}

	@Override
	public News findOne(int id) {
		String sql = "SELECT * FROM News WHERE News.id = ?";
		List<News> news = DataProvider.getInstance().executeQuery(sql, new NewsMapper(), new Object[] { id });
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public int update(News news) {
		String sql = "UPDATE News\r\n"
				+ "SET title = ?, thumbnail = ?, shortDescription = ?, content = ?, idCategory = ?, createdBy = ?\r\n"
				+ "WHERE id = ?;";
		return DataProvider.getInstance().executeNonQuery(sql,
				new Object[] { news.getTitle(), news.getThumbnail(), news.getShortDescription(), news.getContent(),
						news.getIdCategory(), news.getCreatedBy(), news.getId() });
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM News WHERE id = ?";
		return DataProvider.getInstance().executeNonQuery(sql, new Object[] { id });
	}

	@Override
	public List<News> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM News");
		if (pageble.getSort() != null) {
			if (pageble.getSort().getSortName() == null) {
				sql.append(" ORDER BY id DESC");
			} else {
				sql.append(" ORDER BY " + pageble.getSort().getSortName() + " " + pageble.getSort().getSortBy());
			}

		}
		if (pageble.getOffset() != null) {
			sql.append(" OFFSET " + pageble.getOffset() + " ROWS FETCH NEXT " + pageble.getFetchNextRows());
			sql.append(" ROWS ONLY");
		}
		return DataProvider.getInstance().executeQuery(sql.toString(), new NewsMapper(), null);
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT COUNT(*) FROM News";
		return DataProvider.getInstance().count(sql, null);
	}

}
