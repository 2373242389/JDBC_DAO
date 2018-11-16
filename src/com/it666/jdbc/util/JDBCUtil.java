package com.it666.jdbc.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.spi.DirStateFactory.Result;
import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;



public class JDBCUtil {
	
	public static DataSource ds = null; 
	static {
		try {
			Properties p = new Properties();
			FileInputStream in = new FileInputStream("resource/db.properties");
			p.load(in);
			ds = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static Connection getConn(){
		try {	
			return ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//ÊÍ·Å×ÊÔ´
	public static void close(Connection conn,Statement st,ResultSet rs)
	{
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  
	}
}
