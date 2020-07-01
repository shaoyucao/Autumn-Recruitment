package com.syc.g_annotaion.b_web;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentDao studentDao;
	
	@Resource(name="studentDaoId")
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public void addStudent() {
		studentDao.save();
	}

}
