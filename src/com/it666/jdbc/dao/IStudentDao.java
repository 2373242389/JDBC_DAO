package com.it666.jdbc.dao;

import java.util.List;

import com.it666.jdbc.domain.Student;

public interface IStudentDao {
	//1���������
	void save(Student stu);
	//2���޸�ָ��ѧ����Ϣ
	void update(int id,Student stu);
	//3��ɾ��ѧ��
	void delete(int id);
	//4����ȡָ��ѧ��
	Student get(int id);
	//5����ȡ���е�ѧ�� 
	List<Student> getAll();
	
	

}
