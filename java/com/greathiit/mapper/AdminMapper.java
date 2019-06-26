package com.greathiit.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.greathiit.entity.Course;
import com.greathiit.entity.Faculty;
import com.greathiit.entity.Specialty;
import com.greathiit.entity.StudentClass;
import com.greathiit.entity.Syllabus;
import com.greathiit.entity.Teacher;

@Repository
public interface AdminMapper {
public List<StudentClass> queryClass(StudentClass studentClass);
public Integer updateClass(StudentClass classInfo);
public Integer deleteClass(List<String> className);
public Integer insertClass(List<StudentClass> classInfo);
public List<Specialty> querySpecialty(Specialty specialty);
public Integer updateSpecialty(Specialty specialty);
public Integer deleteSpecialty(String specialty);
public Integer insertSpecialty(List<Specialty> specialty);
public List<Faculty> queryFaculty(Faculty faculty);
public Integer updateFaculty(Faculty faculty);
public Integer deleteFaculty(String faculty);
public Integer insertFaculty(List<Faculty> faculty);
public List<Course> queryCourse(Course course);
public Integer updateCourse(Course course);
public Integer deleteCourse(String course);
public Integer insertCourse(List<Course> course);
public List<Syllabus> querySyllabus(Syllabus syllabus);
public Integer updateSyllabus(Syllabus syllabus);
public Integer deleteSyllabus(List<String> syllabus);
public Integer insertSyllabus(List<Syllabus> syllabus);
public List<Teacher> queryTeacher(Teacher teacher);
public Integer updateTeacher(Teacher teacher);
public Integer deleteTeacher(List<String> teacher);
public Integer insertTeacher(Teacher teacher);

}
