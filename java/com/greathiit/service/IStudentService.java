package com.greathiit.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.greathiit.entity.Message;
import com.greathiit.entity.Student;
import com.greathiit.entity.StudentLeaveInfo;

/**
 * @author 邓世江
 * @date 2018年11月8日 下午3:43:11
 * 
 */
public interface IStudentService {
	/**
	 * 用于学生的登陆
	 * @param name 用户名
	 * @param password 密码
	 * @return student 学生全部信息<br>
	 * 	
	 * */
	public Student login(String name,String password);
	/**
	 * 用于学生的请假信息登记
	 * @param info 学生请假信息
	 * @return Boolean 请假信息保存成功与否<br>
	 * 	
	 * */
	public int addLeave(StudentLeaveInfo info, MultipartFile file,Message message,Student stu);
	/**
	 * 用于学生的请假信息查询
	 * @param info 学生请假信息
	 * @return 学生请假信息<br>
	 * 	
	 * */
	public  List<StudentLeaveInfo> queryLeave(StudentLeaveInfo info);
	/**
	 * 用于更学生信息
	 * @param info 学生信息
	 * @return 更新条数<br>
	 * 	
	 * */
	public Integer updateMessage(Map<String,String> info);
}
