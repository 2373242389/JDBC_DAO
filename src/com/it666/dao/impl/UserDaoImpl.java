package com.it666.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.it666.jdbc.dao.IUserDao;
import com.it666.jdbc.domain.User;
import com.it666.jdbc.handler.IResultSetHandler;
import com.it666.jdbc.util.CRUDTemplate;
import com.it666.jdbc.util.JDBCUtil;

public class UserDaoImpl implements IUserDao{

	@Override
	public void save(User u) {
		// TODO Auto-generated method stub
		String sql = "insert into User1(name1,pwd)values(?,?)";
		CRUDTemplate.excuteUpdate(sql, u.getName1(),u.getPwd());
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		String sql = "select * from User1";
		return CRUDTemplate.executeQuery(sql, new UserResultSetImp());
	}

}
class UserResultSetImp implements IResultSetHandler<List<User>>{

	@Override
	public List<User> handle(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<>();
		while (rs.next()) {
			User u = new User();
			u.setName1(rs.getString("name1"));
			u.setPwd(rs.getString("pwd"));
			list.add(u);
		}
		return list;
	}
}
