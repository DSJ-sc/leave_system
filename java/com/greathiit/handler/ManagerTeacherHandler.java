package com.greathiit.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.greathiit.entity.ApprovalInformation;
import com.greathiit.entity.Faculty;
import com.greathiit.entity.Teacher;
import com.greathiit.entity.TeacherLeaveInfo;
import com.greathiit.entity.TeacherMap;
import com.greathiit.entity.TeacherSituationAnalysis;
import com.greathiit.service.IManagerTeacherService;

/**
 * @author 邓世江
 * @date 2018年11月18日 下午3:00:40
 * 
 */
@Controller
@SessionAttributes(value= {"teacherStatistics"})
@RequestMapping("manager")
public class ManagerTeacherHandler {
	@Autowired
	private IManagerTeacherService service;
	/**
	 * @param session 教师信息
	 * @param map 保存查到的结果集
	 * @return String 返回的网址
	 * **/
	@RequestMapping("getApprovalTeacherLeave")
	@ResponseBody
	public Object getApprovalTeacherLeave(HttpSession session) {
		List<List<TeacherLeaveInfo>> teacherLeave = service.getApprovalTeacherLeave((Teacher)session.getAttribute("teacher"));
		return teacherLeave;
	}
	 /**
	  * 审批学生请假审批
	  * @param info 学生的请假申请
	  * @return int 
	  *	  
	  **/
	@RequestMapping("setApprovalTeacherLeave")
	@ResponseBody
	public Integer setApprovalTeacherLeave(ApprovalInformation info,HttpSession session) {
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		info.setIdentity(teacher.getTeacherPost());
		return service.setApprovalTeacherLeave(info);
	}
	/**查询专业教师请假统计信息
	 * @param situation 保存查询的条件  职工号 或姓名
	 * @param map 保存查询到的结果集
	 * @return String 返回的网页地址
	 * **/
	@RequestMapping("queryTeacherStatistics")
	@ResponseBody
	public TeacherMap queryTeacherStatistics(TeacherSituationAnalysis situation,Map<String, String> map,Map<String,List<TeacherSituationAnalysis>> m) {
		map.put("teacherNum",situation.getTeacherNum());
		map.put("facultyName",situation.getFacultyName());
		map.put("startTime",situation.getLeaveTime());
		map.put("time",situation.getLeaveTime().length()+"");
		List<TeacherSituationAnalysis> teacherStatistics = service.queryTeacherStatistics(map);
		m.put("teacherStatistics", teacherStatistics);
		TeacherMap teacherMap = new TeacherMap();
		for(TeacherSituationAnalysis temp: teacherStatistics ) {
			int day = Integer.parseInt(temp.getLeaveTime().substring(5,7));
			switch (temp.getFacultyName()) {
			case "软件学院":
				 teacherMap.getSoftwareCollege()[day-1] += temp.getLeaveNum();
				break;
			case "艺术设计学院":
				 teacherMap.getArtDesignCollege()[day-1] += temp.getLeaveNum();
				break;
			case "商学院":
				 teacherMap.getBusinessCollege()[day-1] += temp.getLeaveNum();
				break;
			case "电子工程学院":
				 teacherMap.getElectronicEngineeringCollege()[day-1] += temp.getLeaveNum();
				break;
			}
		}
		return  teacherMap;
	}
	@RequestMapping("getFaculty")
	@ResponseBody
	 public List<Faculty> getFaculty(){
		 return service.getFaculty();
	 }
	 /**
	  * 获取教师
	  * 
	  * */
	@RequestMapping("getTeacher")
	@ResponseBody
	 public List<Teacher> getTeacher(String faculty){
		return  service.getTeacher(faculty);
	 }
}
