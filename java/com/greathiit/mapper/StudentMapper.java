package com.greathiit.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.greathiit.entity.Student;
import com.greathiit.entity.StudentLeaveInfo;

/**
 * @author 邓世江
 * @date 2018年11月8日 下午3:26:49
 * 
 */
@Repository
public interface StudentMapper {
	/**
	 * 用于学生的登陆
	 * @param student 学生信息
	 * @return student 学生全部信息<br>
	 * 	
	 * */
	public Student login(Map<String,String> map);
	/**
	 * 用于学生的请假信息登记
	 * @param info 学生请假信息
	 * @return Boolean 请假信息保存成功与否<br>
	 * 	
	 * */
	public int addLeave(StudentLeaveInfo info);
	/**
	 * 用于学生的请假信息查询
	 * @param info 学生请假信息
	 * @return 学生请假信息<br>
	 * 	
	 * */
	public List<StudentLeaveInfo> queryLeave(StudentLeaveInfo info);
	/**
	 * 用于学生的请假信息查询
	 * @param info 学生请假信息
	 * @return 学生请假信息<br>
	 * 	
	 * */
	public List<StudentLeaveInfo> queryWaitLeave(StudentLeaveInfo info);
	/**
	 * 用于更学生信息
	 * @param info 学生信息
	 * @return 更新条数<br>
	 * 	
	 * */
	public Integer updateMessage(Map<String,String> info);
}
