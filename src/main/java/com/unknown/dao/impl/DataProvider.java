package com.unknown.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.unknown.mapper.IRowMapper;

public class DataProvider {

	private static String URL = "jdbc:sqlserver://DESKTOP-UNF4A4J\\SQLEXPRESS:1433;databaseName=News;user=sa;password=123456";
	private static DataProvider instance;
	private static Connection connect;
	private static PreparedStatement pstmt;
	private static ResultSet dataResult;

	private DataProvider() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connect = null;
			pstmt = null;
			dataResult = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DataProvider getInstance() {
		if (DataProvider.instance == null) {
			DataProvider.instance = new DataProvider();
		}
		return DataProvider.instance;
	}

	public <T> List<T> executeQuery(String query, IRowMapper<T> rowMapper, Object[] parameter) {
		List<T> convertResult = new ArrayList<>();
		try {
			DataProvider.connect = DriverManager.getConnection(URL);
			DataProvider.pstmt = connect.prepareStatement(query);
			if (parameter != null) {
				for (int i = 0; i < parameter.length; ++i) {
					DataProvider.pstmt.setObject(i + 1, parameter[i]);
				}
			}
			DataProvider.dataResult = DataProvider.pstmt.executeQuery();
			while (DataProvider.dataResult.next()) {
				convertResult.add(rowMapper.mapRow(DataProvider.dataResult));
			}
			return convertResult;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dataResult != null) {
					DataProvider.dataResult.close();
				}
				if (pstmt != null) {
					DataProvider.pstmt.close();
				}
				if (connect != null) {
					DataProvider.connect.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return convertResult;
	}

	public Integer executeNonQuery(String query, Object[] parameter) {
		Integer data = null;
		try {
			DataProvider.connect = DriverManager.getConnection(URL);
			connect.setAutoCommit(false);
			pstmt = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			if (parameter != null) {
				for (int i = 0; i < parameter.length; ++i) {
					pstmt.setObject(i + 1, parameter[i]);
				}
			}
			pstmt.executeUpdate();
			dataResult = pstmt.getGeneratedKeys();
			if (dataResult.next()) {
				data = dataResult.getInt(1);
			}
			connect.commit();
			return data;
		} catch (SQLException e) {
			if (connect != null) {
				try {
					connect.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (dataResult != null) {
					DataProvider.dataResult.close();
				}
				if (pstmt != null) {
					DataProvider.pstmt.close();
				}
				if (connect != null) {
					DataProvider.connect.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}

	public Object executeScalar(String query, Object[] parameter) {
		Object data = null;
		try {
			DataProvider.connect = DriverManager.getConnection(URL);
			pstmt = connect.prepareStatement(query);
			if (parameter != null) {
				for (int i = 0; i < parameter.length; ++i) {
					pstmt.setObject(i + 1, parameter[i]);
				}
			}
			data = pstmt.executeQuery().next();
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dataResult != null) {
					DataProvider.dataResult.close();
				}
				if (pstmt != null) {
					DataProvider.pstmt.close();
				}
				if (connect != null) {
					DataProvider.connect.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}

	public int count(String query, Object[] parameter) {
		int data = 0;
		try {
			DataProvider.connect = DriverManager.getConnection(URL);
			pstmt = connect.prepareStatement(query);
			if (parameter != null) {
				for (int i = 0; i < parameter.length; ++i) {
					pstmt.setObject(i + 1, parameter[i]);
				}
			}
			dataResult = pstmt.executeQuery();
			if (dataResult.next()) {
				data = dataResult.getInt(1);
			}
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dataResult != null) {
					DataProvider.dataResult.close();
				}
				if (pstmt != null) {
					DataProvider.pstmt.close();
				}
				if (connect != null) {
					DataProvider.connect.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
}