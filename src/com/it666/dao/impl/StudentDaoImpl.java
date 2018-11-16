package com.it666.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.it666.jdbc.dao.IStudentDao;
import com.it666.jdbc.domain.Student;
import com.it666.jdbc.handler.IResultSetHandler;
import com.it666.jdbc.util.CRUDTemplate;


public class StudentDaoImpl implements IStudentDao {


	@Override
	public void save(Student stu) {
		// 3¡¢´´½¨Óï¾ä
		String sql = "insert into student(id,name,age) values(?,?,?)";
		CRUDTemplate.excuteUpdate(sql, stu.getId(), stu.getName(), stu.getAge());
	}

	@Override
	public void update(int id, Student stu) {
		String sql = "update student set name=?,age=? where id=? ";
		CRUDTemplate.excuteUpdate(sql, stu.getName(), stu.getAge(), stu.getId());
	}
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from student where id = ?";
		CRUDTemplate.excuteUpdate(sql, id);
	}

	@Override
	public Student get(int id) {
		// TODO Auto-generated method stub
		
		String sql = "select * from student where id = ?";
		IResultSetHandler<List<Student>> rh = new StuResultSetHandImp();
		List<Student> list = CRUDTemplate.executeQuery(sql,rh, id);
		return list.size() == 1 ? list.get(0) : null;
	}

	@Override
	public List<Student> getAll() {

	String sql = "select * from student";
	return CRUDTemplate.executeQuery(sql,new StuResultSetHandImp());
	
	}
}

class StuResultSetHandImp implements IResultSetHandler<List<Student>>{
	@Override
	public List<Student> handle(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<Student>();
		while (rs.next()) {
			Student stu = new Student();
			stu.setName(rs.getString("name"));
			stu.setAge(rs.getInt("age"));
			stu.setId(rs.getInt("id"));
			list.add(stu);
		}
		return list;
	}
	
}