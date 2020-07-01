package com.syc.g_annotaion.b_web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("studentActionId")
public class StudentAction {

	@Autowired
	private StudentService studentService;
	
	public void execute() {
		studentService.addStudent();
	}
	
}
