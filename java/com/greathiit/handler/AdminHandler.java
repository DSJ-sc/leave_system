package com.greathiit.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.greathiit.entity.Course;
import com.greathiit.entity.Faculty;
import com.greathiit.entity.Specialty;
import com.greathiit.entity.StudentClass;
import com.greathiit.entity.Syllabus;
import com.greathiit.entity.Teacher;
import com.greathiit.service.AdminService;
@RequestMapping("admin")
@Controller
public class AdminHandler {
	@Autowired
	private AdminService adminService;
	@RequestMapping("queryClass")
	@ResponseBody
	public List<StudentClass> queryClass(StudentClass studentClass) {
		return adminService.queryClass(studentClass);
	}

	@RequestMapping("updateClass")
	@ResponseBody
	public Integer updateClass(StudentClass classInfo) {	
		return adminService.updateClass(classInfo);
	}

	@RequestMapping("deleteClass")
	@ResponseBody
	public Integer deleteClass(String className) {
		List<String> classNameList = JSONArray.parseArray(className,String.class);
		return adminService.deleteClass(classNameList);
	}

	@RequestMapping("insertClass")
	@ResponseBody
	public Integer insertClass(@RequestParam("classInfo")String classInfo) {
		List<StudentClass> parseArray = JSON.parseArray(classInfo, StudentClass.class);
		return adminService.insertClass(parseArray);
	}

	@RequestMapping("querySpecialty")
	@ResponseBody
	public List<Specialty> querySpecialty(Specialty specialty) {		
		return adminService.querySpecialty(specialty);
	}

	@RequestMapping("updateSpecialty")
	@ResponseBody
	public Integer updateSpecialty(Specialty specialty) {
		
		return adminService.updateSpecialty(specialty);
	}

	@RequestMapping("deleteSpecialty")
	@ResponseBody
	public Integer deleteSpecialty(@RequestParam("specialty") String specialty) {
		return adminService.deleteSpecialty(specialty);
	}

	@RequestMapping("insertSpecialty")
	@ResponseBody
	public Integer insertSpecialty(@RequestParam("specialty")String specialty) {
		List<Specialty> parseArray = JSONArray.parseArray(specialty, Specialty.class);
		return adminService.insertSpecialty(parseArray);
	}
	@RequestMapping("queryFaculty")
	@ResponseBody
	public List<Faculty> queryFaculty(Faculty faculty){
		return adminService.queryFaculty(faculty);
	}
	
	@RequestMapping("updateFaculty")
	@ResponseBody
	public Integer updateFaculty(Faculty faculty) {
		return adminService.updateFaculty(faculty);
	}
	
	@RequestMapping("deleteFaculty")
	@ResponseBody
	public Integer deleteFaculty(@RequestParam("faculty")String faculty) {
		return adminService.deleteFaculty(faculty);
	}
	
	@RequestMapping("insertFaculty")
	@ResponseBody
	public Integer insertFaculty(@RequestParam("faculty")String faculty) {
		List<Faculty> parseArray = JSONArray.parseArray(faculty, Faculty.class);
		return adminService.insertFaculty(parseArray);
	}
	
	@RequestMapping("queryCourse")
	@ResponseBody
	public List<Course> queryCourse(Course course) {
		return adminService.queryCourse(course);
	}

	@RequestMapping("updateCourse")
	@ResponseBody
	public Integer updateCourse(Course course) {
		
		return adminService.updateCourse(course);
	}

	@RequestMapping("deleteCourse")
	@ResponseBody
	public Integer deleteCourse(@RequestParam("course")String course) {
		
		return adminService.deleteCourse(course);
	}

	@RequestMapping("insertCourse")
	@ResponseBody
	public Integer insertCourse(@RequestParam("course")String course) {
		List<Course> parseArray = JSONArray.parseArray(course, Course.class);
		return adminService.insertCourse(parseArray);
	}

	@RequestMapping("querySyllabus")
	@ResponseBody
	public List<Syllabus> querySyllabus(Syllabus syllabus) {
		return adminService.querySyllabus(syllabus);
	}

	@RequestMapping("updateSyllabus")
	@ResponseBody
	public Integer updateSyllabus(Syllabus syllabus) {
		
		return adminService.updateSyllabus(syllabus);
	}

	@RequestMapping("deleteSyllabus")
	@ResponseBody
	public Integer deleteSyllabus(@RequestParam("syllabus")String syllabus) {
		List<String> parseArray = JSONArray.parseArray(syllabus, String.class);
		return adminService.deleteSyllabus(parseArray);
	}

	@RequestMapping("insertSyllabus")
	@ResponseBody
	public Integer insertSyllabus(@RequestParam("syllabus")String syllabus) {
		List<Syllabus> parseArray = JSONArray.parseArray(syllabus, Syllabus.class);
		return adminService.insertSyllabus(parseArray);
	}

	@RequestMapping("queryTeacher")
	@ResponseBody
	public List<Teacher> queryTeacher(Teacher teacher) {
		
		return adminService.queryTeacher(teacher);
	}

	@RequestMapping("updateTeacher")
	@ResponseBody
	public Integer updateTeacher(Teacher teacher) {
		return adminService.updateTeacher(teacher);
	}

	@RequestMapping("deleteTeacher")
	@ResponseBody
	public Integer deleteTeacher(@RequestParam("delteacher")String teacher) {
		List<String> parseArray = JSONArray.parseArray(teacher, String.class);
		return adminService.deleteTeacher(parseArray);
	}

	@RequestMapping("insertTeacher")
	@ResponseBody
	public Integer insertTeacher(@RequestParam("addteacher")String teacher) {
		Teacher parseArray = JSONArray.parseObject(teacher, Teacher.class);
		return adminService.insertTeacher(parseArray);
	}
	@RequestMapping("getTeacherAndSpecialty")
	@ResponseBody
	public Object getTeacherAndSpecialty() {
		List<Object> list = new ArrayList<>();
		list.add(adminService.queryTeacher(null));
		list.add(adminService.querySpecialty(null));
		return list;
	}
	 @RequestMapping("adminCancellation")
		public String cancellation(HttpSession session) {
			session.removeAttribute("admin");
			return "redirect:../login.html";
		}
}
