package com.greathiit.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.greathiit.entity.ApprovalInformation;
import com.greathiit.entity.ClassMap;
import com.greathiit.entity.ClassOfMonthMap;
import com.greathiit.entity.ClassOfYearMap;
import com.greathiit.entity.ClassStudents;
import com.greathiit.entity.LeaveData;
import com.greathiit.entity.Pages;
import com.greathiit.entity.QueryLeaveInfo;
import com.greathiit.entity.SpecialtyClass;
import com.greathiit.entity.SpecialtySituationAnalysis;
import com.greathiit.entity.Student;
import com.greathiit.entity.StudentClass;
import com.greathiit.entity.StudentLeaveInfo;
import com.greathiit.entity.StudentSituationAnalysis;
import com.greathiit.entity.Teacher;
import com.greathiit.entity.TeacherLeaveInfo;
import com.greathiit.service.ITeacherService;

/**
 * @author 邓世江
 * @date 2018年11月13日 下午6:35:30
 * 
 */
@Controller
@SessionAttributes(value= {"specialtyStatistics","classSituationAnalysis"})
@RequestMapping("teacher") 
public class TeacherHandler {
	@Autowired
	private ITeacherService teacherService;
	/**获取学生
	 * @param className 班级名
	 * @param time 查询的时间
	 * @param map 保存学生信息结果集
	 * @return String 返回的网页地址
	 * **/
	@RequestMapping("getStudent")
	@ResponseBody
	public List<StudentLeaveInfo> getStudent(@RequestParam("leaveClass")String className) {
			List<String> parseArray = JSONArray.parseArray(className, String.class);
			return teacherService.getStudent(parseArray);
	}
	/**添加请假信息
	 * @param info 教师请假信息
	 * @param session 保存在session中的教师信息
	 * @return String 返回的网页地址
	 * **/
	@RequestMapping("addLeave")
	@ResponseBody
	public Integer addLeave(String info,HttpSession session) {	
		List<TeacherLeaveInfo> leaveInfo = JSONObject.parseArray(info,TeacherLeaveInfo.class);
		if(leaveInfo.size()==0) {
			return 0;
		}
		Teacher tea = (Teacher) session.getAttribute("teacher");
		return teacherService.addLeave(leaveInfo,tea);
	}
	/**教师查询自己的请假信息方法
	 * @param info 教师的请假信息 如id 时间
	 * @param session 保存在session中的教师信息
	 * @param map 保存教师请假信息集合
	 * @return String 返回的网页地址
	 * **/
	@RequestMapping("queryleave")
	@ResponseBody
	public Object queryLeave(TeacherLeaveInfo info,HttpSession session) {
		Teacher tea = (Teacher)session.getAttribute("teacher");
		List<List<TeacherLeaveInfo>> teacherLeave = teacherService.queryLeave(tea.getTeacherNum());
		return teacherLeave;
	}
	/**获得请假的学生
	 * @param session 保存在session中的教师信息
	 * @param map 保存学生请假和正常上课信息集合
	 * @return String 返回的网页地址
	 * **/
	@RequestMapping("getApprovalStudentLeave")
	@ResponseBody
	public Object getApprovalStudentLeave(HttpSession session,Pages pages) {
		Page<Pages> startPage = PageHelper.startPage(pages);
		List<Student> approvalStudentLeave = teacherService.getApprovalStudentLeave(((Teacher)session.getAttribute("teacher")).getTeacherNum());
		List<Object> studentLeave = new ArrayList<>();
		pages.setPages(startPage.getPages());
		studentLeave.add(approvalStudentLeave);
		studentLeave.add(pages);
		return studentLeave;
	}
	/**审批请假请求
	 * @param info 教师审批的信息详情
	 * @param session 保存在session中的教师信息
	 * @return int 审批的条数
	 * **/
	@RequestMapping("setApprovalStudentLeave")
	@ResponseBody
	public int setApprovalStudentLeave(ApprovalInformation info,HttpSession session) {
		 info.setIdentity(((Teacher)session.getAttribute("teacher")).getTeacherPost());
		return teacherService.setApprovalStudentLeave(info);
	}
	/**查询班级请假统计信息
	 * @param situation 保存查询的条件  学院 专业 班级
	 * @param map 保存查询到的结果集
	 * @return String 返回的网页地址
	 * **/
	@RequestMapping("queryClassStatistics")
	@ResponseBody
	public Object queryClassStatistics(QueryLeaveInfo situation,Map<String, List<SpecialtySituationAnalysis>> map) {
		List<SpecialtySituationAnalysis> list = teacherService.queryClassStatistics(situation);
		map.put("specialtyStatistics",list);
		ClassMap mapInfo;
		if(situation.getLeaveTime().length()==4) {
			 mapInfo = new ClassOfYearMap();
		}else {
			 mapInfo = new ClassOfMonthMap();
		}
		for(int i=0,j=list.size();i<j;i++) {
			for(LeaveData leave : list.get(i).getLeaveData()) {
				//截取时间最后两位作为数组下标
				int day = Integer.parseInt(leave.getLeaveTime().substring(leave.getLeaveTime().length()-2));
				mapInfo.getThingNum()[day-1] += leave.getPersonaLeaveNum();
				mapInfo.getNightNum()[day-1] += leave.getNightLeaveNum();
				mapInfo.getSickNum()[day-1] += leave.getSickLeaveNum();
			}
		}
		return mapInfo;
	}
	/**
	 * @param situation 保存查询的条件  学号或姓名 查询间隔时间
	 * @param map 保存查询到的结果集
	 * @return String 返回的网页地址
	 * **/
	@RequestMapping("queryStudentStatistics")
	@ResponseBody
    public Object queryStudentStatistics(QueryLeaveInfo situation,Map<String, List<StudentSituationAnalysis>> map) {
		List<StudentSituationAnalysis> list =  teacherService.queryStudentStatistics(situation);
		map.put("classSituationAnalysis", list);
		ClassMap mapInfo;
		if(situation.getLeaveTime().length()==4) {
			 mapInfo = new ClassOfYearMap();
		}else {
			 mapInfo = new ClassOfMonthMap();
		}
		for(int i=0,j=list.size();i<j;i++) {
			for(LeaveData leave : list.get(i).getLeaveData()) {
				//截取时间最后两位作为数组下标
				int day = Integer.parseInt(leave.getLeaveTime().substring(leave.getLeaveTime().length()-2));
				mapInfo.getThingNum()[day-1] += leave.getPersonaLeaveNum();
				mapInfo.getNightNum()[day-1] += leave.getNightLeaveNum();
				mapInfo.getSickNum()[day-1] += leave.getSickLeaveNum();
			}
		}
		return mapInfo;
    }
	@RequestMapping("getClassName")
	@ResponseBody
	public List<ClassStudents> getClassName(String teacherNum){
		List<ClassStudents> className = teacherService.getClassName(teacherNum);
		return className;
	}
	@RequestMapping("queryClass")
	@ResponseBody
	public List<StudentClass> queryClass(){
		return teacherService.queryClass();
	}
	@RequestMapping("queryCourse")
	@ResponseBody
	public List<String> queryCourse(){
		return teacherService.queryCourse();
	}
	@RequestMapping("getSpecialtyName")
	@ResponseBody
	public List<SpecialtyClass> getSpecialtyName(String facultyName){
		List<SpecialtyClass> className = teacherService.getSpecialtyName(facultyName);
		return className;
	}
    @RequestMapping("cancellation")
	public String cancellation(HttpSession session) {
		session.removeAttribute("teacher");
		return "redirect:../login.html";
	}
}
