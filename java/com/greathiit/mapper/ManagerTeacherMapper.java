package com.greathiit.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.greathiit.entity.Faculty;
import com.greathiit.entity.Message;
import com.greathiit.entity.Teacher;
import com.greathiit.entity.TeacherLeaveInfo;
import com.greathiit.entity.TeacherSituationAnalysis;

/**
 * @author 邓世江
 * @date 2018年11月13日 下午4:00:07
 * 
 */
@Repository
public interface ManagerTeacherMapper {
	/**
	 * 取得需要审批的请假申请
	 * @param leaveNum 请假编号
	 * @return List &lt;Student&gt;学生请假信息集合
	 * **/
	public List<TeacherLeaveInfo> getApprovalTeacherLeave(List<String> leaveNum);
	 /**
	  * 审批教师请假审批
	  * @param info 审批信息
	  * @return int 
	  *	  
	  **/
 	public Integer setApprovalTeacherLeave(Map<String,String> info);
	 /**
	  * 获取请假统计信息
	  * @param map 查看的教师的职工号或姓名加上查询的时间间隔
	  * @return SituationAnalysis list集合
	  *	 
	  **/
	 public List<TeacherSituationAnalysis> queryTeacherStatistics(Map<String,String> map);
	 /**
	  * 获取未审批的所有教师请假信息
	  * **/
	 public List<Message> getOneApproval();
	 /**
	  *获取教务处长编号
	  * */
	 public String getDean();
	 /**
	  * 获取学院
	  * */
	 public List<Faculty> getFaculty();
	 /**
	  * 获取教师
	  * 
	  * */
	 public List<Teacher> getTeacher(String faculty);
	
}
