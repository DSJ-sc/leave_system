package com.greathiit.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greathiit.entity.ApprovalInformation;
import com.greathiit.entity.Faculty;
import com.greathiit.entity.Message;
import com.greathiit.entity.Teacher;
import com.greathiit.entity.TeacherLeaveInfo;
import com.greathiit.entity.TeacherSituationAnalysis;
import com.greathiit.mapper.ManagerTeacherMapper;
import com.greathiit.service.IManagerTeacherService;
import com.greathiit.websocket.IninService;
import com.greathiit.websocket.WebSocketSubject;

/**
 * @author 邓世江
 * @date 2018年11月18日 下午3:25:31
 * 
 */
@Service
public class ManagerTeacherServiceImpl implements IManagerTeacherService {
    @Autowired
	private ManagerTeacherMapper mapper;
	@Override
	public List<List<TeacherLeaveInfo>> getApprovalTeacherLeave(Teacher teacher) {
		List<Message> list = IninService.getMessage(teacher.getTeacherNum());
		List<String> leaveNum = new ArrayList<>();
		for(Message ms:list) {
			if("teacher".equals(ms.getType()))
				leaveNum.add(ms.getLeaveNum());
		}
		if(leaveNum.size()>0) {
			 List<TeacherLeaveInfo> teacherLeave = mapper.getApprovalTeacherLeave(leaveNum);
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
		}else {
			return null;
		}
	}

	@Override
	public Integer setApprovalTeacherLeave(ApprovalInformation approvalInfo) {
		String post = approvalInfo.getIdentity();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");	
		String time = ft.format(new Date());
		Map<String,String> info = new HashMap<>();
		info.put("teacherLeaveNum", approvalInfo.getLeaveId());
		switch (post) {
		case "003":
			if("1".equals(approvalInfo.getApproval())) {
				info.put("one",approvalInfo.getApproval());
				info.put("oneTime",time);
				Message message  =  IninService.messagesMap.get(approvalInfo.getLeaveId());
				message.setRecipient(IninService.dean);
				IninService.messagesMap.put(approvalInfo.getLeaveId(),message);
				WebSocketSubject.Holder.getSubject(message.getRecipient()).notify(message.getRecipient());
				}else {
					info.put("one",approvalInfo.getApproval());
					info.put("oneTime",time);
					info.put("two",approvalInfo.getApproval());
					info.put("twoTime",time);
					IninService.messagesMap.remove(approvalInfo.getLeaveId());
				}
			break;
		case "000":
			info.put("two",approvalInfo.getApproval());
			info.put("twoTime",time);
			IninService.messagesMap.remove(approvalInfo.getLeaveId());
			break;
		default:
			break;
		}
		return mapper.setApprovalTeacherLeave(info);
	}


	@Override
	public List<TeacherSituationAnalysis> queryTeacherStatistics(Map<String,String> map) {
		
		return mapper.queryTeacherStatistics(map);
	}
	@Override
	public List<Message> getOneApproval() {
		
		return mapper.getOneApproval();
	}

	@Override
	public String getDean() {
		return mapper.getDean();
	}

	@Override
	public List<Faculty> getFaculty() {
		
		return mapper.getFaculty();
	}

	@Override
	public List<Teacher> getTeacher(String faculty) {
		
		return mapper.getTeacher(faculty);
	}
}
