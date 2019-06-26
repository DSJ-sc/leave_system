package com.greathiit.service;

import java.util.List;
import java.util.Map;

import com.greathiit.entity.ApprovalInformation;
import com.greathiit.entity.Faculty;
import com.greathiit.entity.Message;
import com.greathiit.entity.Teacher;
import com.greathiit.entity.TeacherLeaveInfo;
import com.greathiit.entity.TeacherSituationAnalysis;

/**
 * @author 邓世江
 * @date 2018年11月18日 下午3:02:34
 * 
 */
public interface IManagerTeacherService {
	/**
	 * 取得需要审批的请假申请
	 * @param leaveNum 请假编号
	 * @return List &lt;Teacher&gt;教师调课信息集合
	 * **/
	public List<List<TeacherLeaveInfo>> getApprovalTeacherLeave(Teacher teacher);
	 /**
	  * 审批教师请假审批
	  * @param approvalInfo 审批信息
	  * @return int 
	  *	  
	  **/
 	public Integer setApprovalTeacherLeave(ApprovalInformation approvalInfo);
	 /**
	  * 获取请假统计信息
	  * @param situation 查看的教师的职工号或姓名加上查询的时间间隔
	  * @return TeacherSituationAnalysis list集合
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
