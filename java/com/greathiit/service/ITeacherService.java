package com.greathiit.service;

import java.util.List;

import com.greathiit.entity.ApprovalInformation;
import com.greathiit.entity.ClassStudents;
import com.greathiit.entity.Message;
import com.greathiit.entity.QueryLeaveInfo;
import com.greathiit.entity.SpecialtyClass;
import com.greathiit.entity.SpecialtySituationAnalysis;
import com.greathiit.entity.Student;
import com.greathiit.entity.StudentClass;
import com.greathiit.entity.StudentLeaveInfo;
import com.greathiit.entity.StudentSituationAnalysis;
import com.greathiit.entity.Teacher;
import com.greathiit.entity.TeacherLeaveInfo;

/**
 * @author 邓世江
 * @date 2018年11月13日 下午6:32:07
 * 
 */
public interface ITeacherService {
		/**
		  * 教师登陆
		  * @param name 用户名
		  * @param password 密码
		  * @return Teacher 教师的所有信息
		  *	 
		  **/
	public Teacher login(String name,String password);
		/**
		  * 获取学生集合
		  * @param className 授课班级
		  * @return StudentLeaveInfo
		  *	 
		  **/
	 public List<StudentLeaveInfo> getStudent(List<String> className);
		 /**
		  * 添加教师请假申请
		  * @param info 教师请假信息	
		  * @return TeacherLeaveInfo
		  *	 教师请假
		  * **/
	 public Integer addLeave(List<TeacherLeaveInfo> info,Teacher tea);
		 /**
		  * 查询请假请求
		  * @param info 查询的请假信息
		  * @return List &lt;TeacherLeaveInfo&gt; 请假信息结果集
		  *	 获取请假信息
		  **/
	 public List<List<TeacherLeaveInfo>> queryLeave(String teacherNum);
		/**
		 * 获取学生请假请求
		 * @param teacher 教师信息
		 * @return List &lt;Student&gt;学生请假信息集合
		 * **/
	 public List<Student> getApprovalStudentLeave(String teacher);
		 /**
		  * 审批学生请假请求
		  * @param approvalInfo 学生的请假申请id 和审批情况
		  * @return int 
		  *	  审批学生请假审批
		  **/
	 public int setApprovalStudentLeave(ApprovalInformation approvalInfo);
	 
	 /**
	  * 删除学生请假审批
	  * @param leaveId 学生的请假编号
	  * @return int 
	  *	  
	  **/
	 public int delStudentLeave(String leaveId);
	 /**
	  * 	按年查看班级或学生请假情况
	  * @param map 查看的班级学生和时间
	  * **/
	 public List<SpecialtySituationAnalysis> queryClassStatistics(QueryLeaveInfo situation);
		 /**
		  * 查看学生请假统计信息
		  * @param situation 查看的学生的学号或姓名加上查询的时间间隔
		  * @return SituationAnalysis list集合
		  *	 获取请假统计信息
		  **/
	 public List<StudentSituationAnalysis> queryStudentStatistics(QueryLeaveInfo situation);
	 /**
	  * 	查询自己带的班级
	  * */
	 public List<ClassStudents> getClassName(String teacherNum);
	 /**
	  * 	查询学院的班级
	  * */
	 public List<SpecialtyClass> getSpecialtyName(String facultyName);
	 /**
	  * 获取未审批的所有教师请假信息
	  * **/
	 public List<Message> getOneApproval();
	 public List<StudentClass> queryClass();
	 /**
	  * 查询所有课程
	  * **/
	 public List<String> queryCourse();
}
