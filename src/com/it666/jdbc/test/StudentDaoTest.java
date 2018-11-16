package com.it666.jdbc.test;


import java.util.List;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsSame;
import org.junit.Test;

import com.it666.dao.impl.StudentDaoImpl;
import com.it666.jdbc.dao.IStudentDao;
import com.it666.jdbc.domain.Student;

public class StudentDaoTest {
	public static void main(String[] args) {
		Student stu =  new Student();
		stu.setId(01);
		stu.setName("Á÷ÀË");
		stu.setAge(12); 
		IStudentDao dao	= new StudentDaoImpl();
		dao.save(stu);
	}
	@Test
	public void update()
	{
		IStudentDao dao = new StudentDaoImpl();
		Student stu = new Student();
		stu.setName("ÄÐÇ¹");
		stu.setAge(16);
		dao.update(1,stu);
	}
	@Test 
	public void get()
	{
		IStudentDao dao = new StudentDaoImpl();
		Student stu = dao.get(1);
		System.out.println(stu);
	}
	@Test 
	public void getAll() {
	IStudentDao dao = new StudentDaoImpl();
	List<Student> allstu = dao.getAll();
	System.out.println(allstu);
	
	}
}
