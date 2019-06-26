package com.greathiit.handler;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.greathiit.entity.Message;
import com.greathiit.entity.Pages;
import com.greathiit.entity.Student;
import com.greathiit.entity.StudentLeaveInfo;
import com.greathiit.service.IStudentService;


/**
 * 学生的控制类
 * @author 邓世江
 * @date 2018年11月8日 下午3:46:55
 * 
 */
@Controller
@RequestMapping("student")
public class StudentHandler {
	/**service层对象 使用自动注入**/
	@Autowired
	private IStudentService studentService;
	/**学生添加请假申请方法
	 * @param info 学生请假信息
	 * @param session 保存在session的学生信息
	 * @return String 前往的网页地址
	 * @throws IOException 
	 * **/
	@RequestMapping("addleave")
	public String addLeave(StudentLeaveInfo info,@RequestParam("file") MultipartFile file,HttpSession session,Message message) throws IOException{	
	    if("".equals(info.getLeaveStartTime())||"".equals(info.getLeaveEndTime())||"".equals(info.getLeaveType())) {
	    	return "";
	    }
		Student stu=(Student)session.getAttribute("student");
		info.setStudentSno(stu.getStudentSno());
		if("3".equals(info.getLeaveType())) {
			info.setStudentLeaveNum(stu.getStudentSno()+info.getLeaveStartTime().substring(0, 10).replaceAll("-", "")+"2");
		}else {
			info.setStudentLeaveNum(stu.getStudentSno()+info.getLeaveStartTime().substring(0, 10).replaceAll("-", "")+"1");
		}
		info.setClassName(stu.getStudentClass().getClassName());
		info.setLeaveAgreement(stu.getStudentApartment());
		info.setFaculty(stu.getStudentClass().getFacultyName());
		info.setSpecialty(stu.getStudentClass().getSpecialtyId());
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm");
		info.setLeaveApplyTime(ft.format(new Date()));	
		int a =  studentService.addLeave(info,file,message,stu);
		if( a != 0 ) {
			return "redirect:studentLeaveInfo.html";
		}else {
			//说明请假时间已在数据库中
			return "redirect:studentaddleave.html?error";
		}
	}
	
	/**学生查询自己的请假信息方法
	 * @param info 查询的请假信息
	 * @param session 保存在session的学生信息
	 * @param map 保存查询的结果集
	 * @return String 返回的网页地址 
	 * **/
	@RequestMapping("queryleave")
	@ResponseBody
	public Object queryLeave(StudentLeaveInfo info,Pages pages){
		Page<Object> startPage = PageHelper.startPage(pages);
		List<StudentLeaveInfo> studentLeave = studentService.queryLeave(info);
		pages.setPages(startPage.getPages());
		List<Object> leaveInfo = new ArrayList<>(2);
		leaveInfo.add(studentLeave);
		leaveInfo.add(pages);
		return leaveInfo;
	}
	@RequestMapping("updateMessage")
	@ResponseBody
	public Integer updateMessage(@RequestParam("studentSno") String studentSno,@RequestParam("apartment") String apartment,@RequestParam("phone") String phone) {
		Map<String,String> map = new HashMap<>(3);
		map.put("studentSno", studentSno);
		map.put("apartment", apartment);
		map.put("phone", phone);
		return studentService.updateMessage(map);
	}
	/**注销*/
	@RequestMapping("cancellation")
	public String cancellation(HttpSession session) {
		session.removeAttribute("student");
		return "redirect:../login.html";
	}
}
