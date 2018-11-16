package com.it666.jdbc.util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.it666.jdbc.domain.Student;
import com.it666.jdbc.handler.IResultSetHandler;

public class CRUDTemplate {
	public static int excuteUpdate(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, null);
		}
		return 0;  
	}
	
	public static <T>T executeQuery(String sql,IResultSetHandler<T> rh,Object...params){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			// 3¡¢´´½¨Óï¾ä
			ps = conn.prepareStatement(sql);
			// 4¡¢Ö´ÐÐÓï¾ä
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			rs = ps.executeQuery();
			return  rh.handle(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, rs);
		}
		return null;
	}
	
}
