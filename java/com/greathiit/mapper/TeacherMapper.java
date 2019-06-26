package com.greathiit.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.greathiit.entity.ClassStudents;
import com.greathiit.entity.Message;
import com.greathiit.entity.Specialty;
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
 * @date 2018年11月12日 下午5:28:18
 * 
 */
@Repository
public interface TeacherMapper {
 /**
  *  教师登陆
  * @param map 登陆信息
  * @return Teacher 教师的所有信息
  *	
  **/
 public Teacher login(Map<String,String> map);
 /**
  * 获取请假学生名单
  * @param className 授课班级
  * @param time 查询的时间
  * @return List &lt;StudentLeaveInfo&gt; 学生请假信息集合
  *	 
  **/
 public List<StudentLeaveInfo> getLeaveStudent(@Param("list")List<String> className, @Param("time")String time);
 /**
  * 获取请假学生名单
  * @param className 授课班级
  * @param time 查询的时间
  * @return List &lt;StudentLeaveInfo&gt; 学生请假信息集合
  *	 
  **/
 public List<StudentLeaveInfo> getWaitLeaveStudent(@Param("list")List<String> className, @Param("time")String time);
 /**
  * 获取正常上课的名单
  * @param className 授课班级
  * @param time 查询的时间
  * @return List &lt;Student&gt; 学生信息集合
  *	
  **/
 public List<Student> getStudent(@Param("className") String className,@Param("time") String time);
 
 /**
  *  教师请假
  * @param info 教师请假信息	
  * @return TeacherLeaveInfo
  *	
  * **/
 public Integer addLeave(List<TeacherLeaveInfo> info);

	 /**
	  * 获取请假信息
	  * @param info 查询的请假信息
	  * @return List &lt;TeacherLeaveInfo&gt; 请假信息结果集
	  *	 
	  **/
 public List<TeacherLeaveInfo> queryLeave(String teacherNum);
	/**
	 * 取得需要审批的请假申请
	 * @param leaveNum 请假编号
	 * @return List &lt;Student&gt;学生请假信息集合
	 * **/
 public List<Student> getApprovalStudentLeave(List<String> leaveNum);
	 /**
	  * 获取某一具体请假申请
	  * @param  leaveId 请假id
	  * @return 具体请假信息
	  * **/
 public StudentLeaveInfo getOneStudentLeave(String leaveId);
	 /**
	  * 审批学生请假审批
	  * @param info 学生的请假申请
	  * @return int 
	  *	  
	  **/
 public int setApprovalStudentLeave(StudentLeaveInfo info);
 /**
  * 审批学生请假审批
  * @param info 学生的请假申请
  * @return int 
  *	  
  **/
  public int setStudentLeave(StudentLeaveInfo info);
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
 public List<SpecialtySituationAnalysis> queryClassStatistics(Map<String,Object> map);
 /**
  * 获取请假统计信息
  * @param map 查看的学生的学号或姓名加上查询的时间间隔
  * @return SituationAnalysis list集合
  *	 
  **/
 public List<StudentSituationAnalysis> queryStudentStatistics(Map<String,Object> map);
 /**
  * 	获取请假班级信息
  * */
 public Specialty getStudentSpecialty(String specialty);
 /**
  * 	查询自己带的班级
  * */
 public List<ClassStudents> getClassName(String teacherNum);
 /**
  * 	查询学院的班级
  * */
 public List<SpecialtyClass> getSpecialtyName(String facultyName);
 /**
  * 获取未审批的所有学生请假信息
  * */
 public List<Message> getOneApproval();
 /**
  * 获取所有班级*/
 public List<StudentClass> queryClass();
 /**
  * 查询所有课程
  * **/
 public List<String> queryCourse();
}
