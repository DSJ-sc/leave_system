package com.greathiit.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greathiit.entity.Faculty;
import com.greathiit.entity.Specialty;
import com.greathiit.entity.Teacher;
import com.greathiit.service.IRegisterService;

/**
 * @author 邓世江
 * @date 2019年3月5日 下午9:07:33
 * 
 */
@Controller
public class RegisterHadnler {
	@Autowired
	private IRegisterService registerService;
	@RequestMapping("getFaculty")
	@ResponseBody
	public List<Faculty> getFaculty(){
	  return registerService.getFaculty();
	}
	@RequestMapping("getSpecialty")
	@ResponseBody
	public List<Specialty> getSpecialty(@RequestParam("faculty") String falulty){
	 return registerService.getSpecialty(falulty);
	}
	@RequestMapping("registers")
	@ResponseBody
	public Integer register(Teacher teacher) {
		int local = (int) (Math.random()*4);
		int num = (int) (Math.random()*9+1);
		String temp = teacher.getTeacherPhone().substring(6);
		StringBuffer teacherNum = new StringBuffer(temp);
		teacher.setTeacherNum(teacherNum.insert(local, num).toString());
		if(registerService.insterWaitTeacher(teacher)>0) {
				return 1;
			}else {
				return 0;
		 }
	}
	@RequestMapping("getWaitTeacher")
	@ResponseBody
	public List<Teacher> getWaitTeacher(){
		return  registerService.queryWaitTeacher();
	}
	
	@RequestMapping("delTeacher")
	@ResponseBody
	public Integer delTeacher(@RequestParam("delTeacher") String teacher){
			return	registerService.delTeacher(teacher);
	}
}
