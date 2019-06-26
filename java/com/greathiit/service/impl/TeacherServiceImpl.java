package com.greathiit.service.impl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greathiit.entity.ApprovalInformation;
import com.greathiit.entity.ClassStudents;
import com.greathiit.entity.Message;
import com.greathiit.entity.QueryLeaveInfo;
import com.greathiit.entity.Specialty;
import com.greathiit.entity.SpecialtyClass;
import com.greathiit.entity.SpecialtySituationAnalysis;
import com.greathiit.entity.Student;
import com.greathiit.entity.StudentClass;
import com.greathiit.entity.StudentLeaveInfo;
import com.greathiit.entity.StudentSituationAnalysis;
import com.greathiit.entity.Teacher;
import com.greathiit.entity.TeacherLeaveInfo;
import com.greathiit.mapper.TeacherMapper;
import com.greathiit.service.ITeacherService;
import com.greathiit.websocket.IninService;
import com.greathiit.websocket.WebSocketSubject;

/**
 * @author 邓世江
 * @date 2018年11月13日 下午6:33:06
 * 
 */
@Service
public class TeacherServiceImpl implements ITeacherService{
	@Autowired
    private TeacherMapper mapper;
	@Override
	public Teacher login(String name,String password) {
		Map<String,String> map = new HashMap<>(2);
		map.put("teacherUname", name);
		map.put("teacherPassword", password);
		return mapper.login(map);
	}
	@Override
	public List<StudentLeaveInfo> getStudent(List<String> className) { 
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm");
		String time = ft.format(new Date());
		List<StudentLeaveInfo> list = mapper.getLeaveStudent(className,time);
		for(StudentLeaveInfo info : mapper.getWaitLeaveStudent(className, time)) {
			list.add(0,info);
		}
		return list;
	}
	@Override
	public Integer addLeave(List<TeacherLeaveInfo> info,Teacher tea) {
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		String nowTime = ft.format(new Date());
		Pattern p = Pattern.compile("[^0-9]");
		Matcher matcher = p.matcher(nowTime);
		String time = matcher.replaceAll("").trim();
		int sum = 0 ; 
		for(int i=0,j=info.size();i<j;i++) {
			TeacherLeaveInfo  leave= info.get(i);
			leave.setLeaveApplyTime(nowTime);
			leave.setOldWeek(calculateWeek(leave.getOldDay()));
			leave.setNewWeek(calculateWeek(leave.getNewDay()));
			leave.setTeacherNum(tea.getTeacherNum());
			leave.setTeacherLeaveNum(tea.getTeacherNum()+time);
			leave.setTeacherName(tea.getTeacherName());
			leave.setTeacherSpecialty(tea.getTeacherSpecialty());
			leave.setTeacherFaculty(tea.getTeacherFaculty());
		}
		try {
			sum = mapper.addLeave(info);
		} catch (Exception e) {
			return 0;
		}
		 this.pushMessage(tea, nowTime, tea.getTeacherNum()+time);
		return sum;
	}
	@Override
	public List<List<TeacherLeaveInfo>> queryLeave(String teacherNum) {
		 List<TeacherLeaveInfo> teacherLeave = mapper.queryLeave(teacherNum);
		 if(teacherLeave.size() == 0) {
			 return null;
		 }
		 List<List<TeacherLeaveInfo>> returnList = new ArrayList<>();
		 //将第一个信息的请假编号保存
		 String teacherLeaveNum = teacherLeave.get(0).getTeacherLeaveNum();
		 //临时存放调课信息的集合
		 List<TeacherLeaveInfo> tempList = new ArrayList<>();
		 //与上一个请假编号相比 相同就直接存储 
		 //不同就新建一个集合对象存放信息 
		 //再把新编号赋值给判断编号
		 for(int i=0,j=teacherLeave.size();i<j;i++) {
			 //只有一条数据
			 if(j==1) {
				 tempList = new ArrayList<>();
				 tempList.add(teacherLeave.get(i));
				 returnList.add(tempList);
				 break ;
			 }
			 //最后两个数据编号相同
			 if(i==j-1&&j>1&&teacherLeave.get(j-1).getTeacherLeaveNum().equals(teacherLeave.get(j-2).getTeacherLeaveNum())) {
				 tempList.add(teacherLeave.get(i));
				 returnList.add(tempList);
				 break ;
			 }
			 //最后两个数据编号不相同
			 if(i==j-1&&j>1&&!teacherLeave.get(j-1).getTeacherLeaveNum().equals(teacherLeave.get(j-2).getTeacherLeaveNum())) {
				 returnList.add(tempList);
				 tempList = new ArrayList<>();
				 tempList.add(teacherLeave.get(i));
				 returnList.add(tempList);
				 break;
			 }
			 if(!teacherLeaveNum.equals(teacherLeave.get(i).getTeacherLeaveNum())) {
				 teacherLeaveNum = teacherLeave.get(i).getTeacherLeaveNum();
				 returnList.add(tempList);
				 tempList = new ArrayList<>();
				 tempList.add(teacherLeave.get(i));
			 }else {
				 tempList.add(teacherLeave.get(i));
			 }
				 
		 }
		 return returnList;
	
	}
	@Override
	public List<Student> getApprovalStudentLeave(String teacher) {
		List<Message> list = IninService.getMessage(teacher);
		List<String> leaveNum = new ArrayList<>();
		for(Message ms:list) {
			if("student".equals(ms.getType())) {
				leaveNum.add(ms.getLeaveNum());
			}
		}
		if(leaveNum.size()>0) {
			return mapper.getApprovalStudentLeave(leaveNum);
		}else {
			return null;
		}
	}
	@Override
	public int setApprovalStudentLeave(ApprovalInformation approvalInfo) {
		final int day = 3;
		int flag = 0;
		StudentLeaveInfo info = mapper.getOneStudentLeave(approvalInfo.getLeaveId());
		Specialty studentSpecialty = mapper.getStudentSpecialty(info.getSpecialty());
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");	
		Date startTime;
		Date endTime;
		int between = 0;
		String time = ft.format(new Date());
		String post = approvalInfo.getIdentity();
		//计算请假天数
		try {
			SimpleDateFormat ft0 = new SimpleDateFormat ("yyyy-MM-dd");
			startTime = ft0.parse(info.getLeaveStartTime());
			endTime = ft0.parse(info.getLeaveEndTime());
			between= (int) ((endTime.getTime()-startTime.getTime())/(1000*3600*24))+1;
		} catch (ParseException e) {
			System.out.println("请假日期转换错误");
			e.printStackTrace();
		}
		//根据身份添加审批信息
		switch (post) {
		case "005": 
			//请假一天二级三级审批默认与一级审批相同
			if(between==1||"2".equals(approvalInfo.getApproval())) {
				info.setLeaveApprovalOne(approvalInfo.getApproval());
				info.setLeaveApprovalOneTime(time);
				info.setLeaveApprovalOneRemarks(approvalInfo.getRemarks());
				info.setLeaveApprovalTwo(approvalInfo.getApproval());
				info.setLeaveApprovalTwoTime(time);
				info.setLeaveApprovalThree(approvalInfo.getApproval());
				info.setLeaveApprovalThreeTime(time);
				//删除保存在内存中的请假信息
				IninService.messagesMap.remove(info.getStudentLeaveNum());
			
				flag = mapper.setApprovalStudentLeave(info);
				mapper.delStudentLeave(approvalInfo.getLeaveId());
			}else {
				info.setLeaveApprovalOne(approvalInfo.getApproval());
				info.setLeaveApprovalOneTime(time);
				info.setLeaveApprovalOneRemarks(approvalInfo.getRemarks());
				flag = mapper.setStudentLeave(info);
				Message message  =  IninService.messagesMap.get(info.getStudentLeaveNum());
				message.setRecipient(studentSpecialty.getSpecialtyTeacherNum());
				IninService.messagesMap.put(info.getStudentLeaveNum(),message);
				WebSocketSubject.Holder.getSubject(message.getRecipient()).notify(message.getRecipient());
			}
		break;
		case "003": 
			if(between<=day||"2".equals(approvalInfo.getApproval())) {
				info.setLeaveApprovalTwo(approvalInfo.getApproval());
				info.setLeaveApprovalTwoTime(time);
				info.setLeaveApprovalTwoRemarks(approvalInfo.getRemarks());
				info.setLeaveApprovalThree(approvalInfo.getApproval());
				info.setLeaveApprovalThreeTime(time);
				IninService.messagesMap.remove(info.getStudentLeaveNum());
				flag = mapper.setApprovalStudentLeave(info);
				mapper.delStudentLeave(approvalInfo.getLeaveId());
			}else {
				info.setLeaveApprovalTwo(approvalInfo.getApproval());
				info.setLeaveApprovalTwoTime(time);
				info.setLeaveApprovalTwoRemarks(approvalInfo.getRemarks());
				Message message  = IninService.messagesMap.get(info.getStudentLeaveNum());
				flag = mapper.setStudentLeave(info);
				message.setRecipient(studentSpecialty.getFacultyTeacherNum());
				IninService.messagesMap.put(info.getStudentLeaveNum(),message);
				WebSocketSubject.Holder.getSubject(message.getRecipient()).notify(message.getRecipient());
			}
		break;

		case "002": 
				info.setLeaveApprovalThreeRemarks(approvalInfo.getRemarks());
				info.setLeaveApprovalThree(approvalInfo.getApproval());
				info.setLeaveApprovalThreeTime(time);
				IninService.messagesMap.remove(info.getStudentLeaveNum());	
				flag = mapper.setApprovalStudentLeave(info);
				mapper.delStudentLeave(approvalInfo.getLeaveId());
		 default: break;
		}
		return flag;
	}
	@Override
	public List<StudentSituationAnalysis> queryStudentStatistics(QueryLeaveInfo info) {
		Map<String, Object> map = new HashMap<>(4);
		map.put("studentSno",info.getUserNum());
		map.put("startTime",info.getLeaveTime());
		map.put("time", info.getLeaveTime().length());
		map.put("className",info.getClassName());
		return mapper.queryStudentStatistics(map);
	}
	@Override
	public List<SpecialtySituationAnalysis> queryClassStatistics(QueryLeaveInfo info) {
		Map<String, Object> map = new HashMap<>(5);
		map.put("startTime",info.getLeaveTime());
		map.put("time", info.getLeaveTime().length());
		map.put("className",info.getClassName());
		map.put("specialtyName", info.getSpecialty());
		map.put("facultyName", info.getFaculty());
		return  mapper.queryClassStatistics(map);
	}
	@Override
	public List<Message> getOneApproval() {
		
		return mapper.getOneApproval();
	}
	@Override
	public List<ClassStudents> getClassName(String teacherNum) {
		
		return mapper.getClassName(teacherNum);
	}
	@Override
	public List<SpecialtyClass> getSpecialtyName(String facultyName) {
		return mapper.getSpecialtyName(facultyName);
	}
	private String calculateWeek(String date) {
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		String[] time = {"日","一","二","三","四","五","六"};
		Calendar c = Calendar.getInstance();  
		 try {
			c.setTime(ft.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int dayForWeek = c.get(Calendar.DAY_OF_WEEK);
		return time[dayForWeek-1];
		
	}
	private void pushMessage(Teacher tea,String time,String leaveNum) {
		Message ms = new Message();
		ms.setType("teacher");
		ms.setApplyTime(time);
		ms.setContent(tea.getTeacherName()+"调课待批准");
		ms.setRecipient(tea.getSpecialtyTeacherNum());	
		ms.setLeaveNum(leaveNum);
		IninService.messagesMap.put(leaveNum,ms);
		WebSocketSubject.Holder.getSubject(ms.getRecipient()).notify(ms.getRecipient());
	}
	@Override
	public int delStudentLeave(String leaveId) {
		
		return mapper.delStudentLeave(leaveId);
	}
	@Override
	public List<StudentClass> queryClass() {
		
		return mapper.queryClass();
	}
	@Override
	public List<String> queryCourse() {
		
		return mapper.queryCourse();
	}
}