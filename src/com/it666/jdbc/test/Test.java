package com.it666.jdbc.test;

import com.it666.jdbc.domain.User;

class ClassTest {
	private Class c;

	public ClassTest(Class c) {
		this.c = c;
	}
}

public class Test {
	public static void main(String[] args) {
		ClassTest c = new ClassTest(User.class);
		
	}
}
