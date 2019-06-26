package com.greathiit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greathiit.entity.Course;
import com.greathiit.entity.Faculty;
import com.greathiit.entity.Specialty;
import com.greathiit.entity.StudentClass;
import com.greathiit.entity.Syllabus;
import com.greathiit.entity.Teacher;
import com.greathiit.mapper.AdminMapper;
import com.greathiit.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminMapper;
	@Override
	public List<StudentClass> queryClass(StudentClass studentClass) {
		
		return adminMapper.queryClass(studentClass);
	}

	@Override
	public Integer updateClass(StudentClass classInfo) {
		
		return adminMapper.updateClass(classInfo);
	}

	@Override
	public Integer deleteClass(List<String> className) {
		
		return adminMapper.deleteClass(className);
	}

	@Override
	public Integer insertClass(List<StudentClass> classInfo) {
		
		return adminMapper.insertClass(classInfo);
	}

	@Override
	public List<Specialty> querySpecialty(Specialty specialty) {
		
		return adminMapper.querySpecialty(specialty);
	}

	@Override
	public Integer updateSpecialty(Specialty specialty) {
		
		return adminMapper.updateSpecialty(specialty);
	}

	@Override
	public Integer deleteSpecialty(String specialty) {
		
		return adminMapper.deleteSpecialty(specialty);
	}

	@Override
	public Integer insertSpecialty(List<Specialty> specialty) {
		
		return adminMapper.insertSpecialty(specialty);
	}

	@Override
	public List<Course> queryCourse(Course course) {
		
		return adminMapper.queryCourse(course);
	}

	@Override
	public Integer updateCourse(Course course) {
		
		return adminMapper.updateCourse(course);
	}

	@Override
	public Integer deleteCourse(String course) {
		
		return adminMapper.deleteCourse(course);
	}

	@Override
	public Integer insertCourse(List<Course> course) {
		
		return adminMapper.insertCourse(course);
	}

	@Override
	public List<Syllabus> querySyllabus(Syllabus syllabus) {
		
		return adminMapper.querySyllabus(syllabus);
	}

	@Override
	public Integer updateSyllabus(Syllabus syllabus) {
		
		return adminMapper.updateSyllabus(syllabus);
	}

	@Override
	public Integer deleteSyllabus(List<String> syllabus) {
		
		return adminMapper.deleteSyllabus(syllabus);
	}

	@Override
	public Integer insertSyllabus(List<Syllabus> syllabus) {
		
		return adminMapper.insertSyllabus(syllabus);
	}

	@Override
	public List<Teacher> queryTeacher(Teacher teacher) {
		
		return adminMapper.queryTeacher(teacher);
	}

	@Override
	public Integer updateTeacher(Teacher teacher) {
		
		return adminMapper.updateTeacher(teacher);
	}

	@Override
	public Integer deleteTeacher(List<String> teacher) {
		
		return adminMapper.deleteTeacher(teacher);
	}

	@Override
	public Integer insertTeacher(Teacher teacher) {
		
		return adminMapper.insertTeacher(teacher);
	}

	@Override
	public List<Faculty> queryFaculty(Faculty faculty) {
		
		return adminMapper.queryFaculty(faculty);
	}

	@Override
	public Integer updateFaculty(Faculty faculty) {
		
		return adminMapper.updateFaculty(faculty);
	}

	@Override
	public Integer deleteFaculty(String faculty) {
		
		return adminMapper.deleteFaculty(faculty);
	}

	@Override
	public Integer insertFaculty(List<Faculty> faculty) {
		
		return adminMapper.insertFaculty(faculty);
	}


}
