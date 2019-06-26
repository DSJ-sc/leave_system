package com.greathiit.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.greathiit.entity.Faculty;
import com.greathiit.entity.Specialty;
import com.greathiit.entity.Teacher;

/**
 * @author 邓世江
 * @date 2019年3月5日 下午9:15:26
 * 
 */
@Repository
public interface RegisterMapper {
 public List<Faculty> getFaculty();
 public List<Specialty> getSpecialty(String faculty);
 public Integer insterWaitTeacher(Teacher teacher);
 public Integer delTeacher(String teacher);
 public List<Teacher> queryWaitTeacher();
}
