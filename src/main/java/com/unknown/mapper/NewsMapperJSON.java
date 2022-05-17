package com.unknown.mapper;

import java.util.ArrayList;
import java.util.List;

import com.unknown.model.News;

public class NewsMapperJSON implements IRowMapperJSON<News> {

	@Override
	public News mapRowJSON(String str) {
		List<String> result = split(str, '\"');
		News news = new News();
		for (int i = 0; i < result.size(); ++i) {
			if (result.get(i).equals("title")) {
				news.setTitle(result.get(++i));
			} else if (result.get(i).equals("thumbnail")) {
				news.setThumbnail(result.get(++i));
			} else if (result.get(i).equals("shortDescription")) {
				news.setShortDescription(result.get(++i));
			} else if (result.get(i).equals("content")) {
				news.setContent(result.get(++i));
			} else if (result.get(i).equals("categoryId")) {
				try {
					news.setIdCategory(Integer.parseInt(result.get(++i)));
				} catch (Exception e) {
				}
			}
		}
		return news;
	}

	public static List<String> split(String str, char c) {
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int j = 0;
		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) == c) {
				for (j = ++i; i < str.length(); ++j) {
					if (str.charAt(j) == c) {
						i = j;
						break;
					} else if ((str.charAt(j) >= 'a' && str.charAt(j) <= 'z')
							|| (str.charAt(j) >= 'A' && str.charAt(j) <= 'Z')
							|| (str.charAt(j) >= '0' && str.charAt(j) <= '9') || (str.charAt(j) == '.')) {
						sb.append(str.charAt(j));
					}
				}
				result.add(sb.toString());
				sb = new StringBuilder();
			} else if ((str.charAt(i) >= '0' && str.charAt(i) <= '9') || (str.charAt(i) == '.')) {
				for (j = i; j < str.length(); ++j) {
					if ((str.charAt(j) >= '0' && str.charAt(j) <= '9') || (str.charAt(j) == '.')) {
						sb.append(str.charAt(j));
					} else {
						i = j;
						break;
					}
				}
				result.add(sb.toString());
				sb = new StringBuilder();
			}
		}
		return result;
	}

}
