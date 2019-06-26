package com.greathiit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greathiit.entity.Faculty;
import com.greathiit.entity.Specialty;
import com.greathiit.entity.Teacher;
import com.greathiit.mapper.RegisterMapper;
import com.greathiit.service.IRegisterService;

/**
 * @author 邓世江
 * @date 2019年3月5日 下午9:18:38
 * 
 */
@Service
public class RegisterServiceImpl implements IRegisterService {
	@Autowired
	private RegisterMapper registerMapper;
	@Override
	public List<Faculty> getFaculty() {
		
		return registerMapper.getFaculty();
	}

	@Override
	public List<Specialty> getSpecialty(String faculty) {
		
		return registerMapper.getSpecialty(faculty);
	}

	@Override
	public Integer insterWaitTeacher(Teacher teacher) {
		
		return registerMapper.insterWaitTeacher(teacher);
	}


	@Override
	public Integer delTeacher(String teacher) {
		
		return registerMapper.delTeacher(teacher);
	}

	@Override
	public List<Teacher> queryWaitTeacher() {
		
		return registerMapper.queryWaitTeacher();
	}

}
