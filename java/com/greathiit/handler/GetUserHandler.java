package com.greathiit.handler;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greathiit.entity.Student;
import com.greathiit.entity.Teacher;
@Controller
public class GetUserHandler {
	@RequestMapping("getUser")
	@ResponseBody
	public Object getUser(String identity,HttpSession session) {
		if("student".equals(identity)) {
			Student student = (Student) session.getAttribute("student");
			 return student;
		}
		if("teacher".equals(identity)) {
			Teacher teacher = (Teacher) session.getAttribute("teacher");
			return teacher;
		}
		return null;
	
	}
}
