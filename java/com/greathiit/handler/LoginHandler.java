package com.greathiit.handler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greathiit.entity.Student;
import com.greathiit.entity.Teacher;
import com.greathiit.service.IStudentService;
import com.greathiit.service.ITeacherService;

@Controller
public class LoginHandler {
	@Autowired
	private IStudentService sudentService;
	@Autowired
	private ITeacherService teacherService;
	@Value("${admin.password}")
	private String adminPassword;
	private final String admin = "admin";
	@RequestMapping("userLogin")
	@ResponseBody
	public int login(@RequestParam("username") String name,@RequestParam("password") String password,HttpSession session) {
		int flag = 0;
		Student student = sudentService.login(name,password);
		 if( student != null){
			 session.setAttribute("student", student);
			 flag=1;
			 return flag;
		 }
		Teacher teacher = teacherService.login(name,password);
		if(teacher != null) {
			session.setAttribute("teacher", teacher);
			switch (teacher.getTeacherPost()) {
			case "006": 
				flag=2;
				break;
			case "005":
			case "004":
				  flag = 3;
				  break;		
			case "003":
			case "002":
			case "001":
			case "000":
					flag = 4;
				break;
			default : flag = 0;
			}
		}
		if(admin.equals(name)&&adminPassword.equals(password)) {
				flag = 5;
				session.setAttribute("admin", "admin");
		}
			return flag;
	}

}
