package com.unknown.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unknown.mapper.IRowMapperJSON;

public class HttpUtil {
	
	private String value;

	public HttpUtil() {
		super();
	}

	public HttpUtil(String value) {
		super();
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public static HttpUtil of(BufferedReader br) {
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new HttpUtil(sb.toString());
	}
	
	public <T> T toModel(Class<T> tclass) {
		try {
			return new ObjectMapper().readValue(this.getValue(), tclass);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//---------------------- Cach 2 Dung IRowmapperJSON & NewsMapperJSON ----------------------
	public <T> T toModel2(IRowMapperJSON<T> rowMapper) {
		return rowMapper.mapRowJSON(this.getValue());
	}
}
