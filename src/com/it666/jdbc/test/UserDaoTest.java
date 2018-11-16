package com.it666.jdbc.test;

import org.junit.Test;

import com.it666.dao.impl.UserDaoImpl;
import com.it666.jdbc.dao.IUserDao;
import com.it666.jdbc.domain.User;

public class UserDaoTest {
	@Test  
	public void save() {
		User u = new User();
		u.setName1("–Ï¡˙œÛ");
		u.setPwd("12345");
		
		IUserDao dao = new UserDaoImpl();
		dao.save(u);
 } 
	@Test
	public void getAll() {
		IUserDao dao = new UserDaoImpl();
		System.out.println(dao.getAll());
	}
}
