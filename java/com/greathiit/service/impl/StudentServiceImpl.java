package com.greathiit.service.impl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.greathiit.entity.Message;
import com.greathiit.entity.Student;
import com.greathiit.entity.StudentLeaveInfo;
import com.greathiit.mapper.StudentMapper;
import com.greathiit.service.IStudentService;
import com.greathiit.websocket.IninService;
import com.greathiit.websocket.WebSocketSubject;

/**
 * @author 邓世江
 * @date 2018年11月8日 下午3:44:12
 * 
 */
@Service
public class StudentServiceImpl implements IStudentService{
	@Autowired
	private StudentMapper mapper;
	@Override
	public Student login(String name,String password) {
		Map<String,String> map = new HashMap<>();
		map.put("studentSno", name);
		map.put("studentId", password);
		return mapper.login(map);
	}
	@Override
	public int addLeave(StudentLeaveInfo info, MultipartFile file,Message message,Student stu) {
			int flag = 0;
			//将文件上传到服务器的目录中
				InputStream input;
				OutputStream out;
				File filePath;
				try {
					input = file.getInputStream();
				
				//取得上传时的名字
				String fileName = file.getOriginalFilename().toLowerCase();
				if(fileName.endsWith("png")||fileName.endsWith("jpg")||fileName.endsWith("gif")) {
				filePath=new File("D:\\images\\"+info.getLeaveStartTime().substring(0, 10));
				//如果文件夹不存在
				if(!filePath.exists()){
					//创建文件夹
					filePath.mkdir();
				}
				String fileRoute=filePath+"\\"+stu.getStudentSno()+info.getLeaveType()+fileName.substring(fileName.indexOf("."))+info.getLeaveType();		
				info.setLeaveProve("../"+fileRoute.substring(fileRoute.indexOf("images")));
				 out = new FileOutputStream(fileRoute);
				byte[] b = new byte[1024];
				int len = -1;
				while((len=input.read(b))!=-1) {
				out.write(b, 0, len);
					}
				out.close();
				input.close();	
					}
				try {
					flag= mapper.addLeave(info);
					} catch (Exception e) {
						return 0;
					}
				} catch (IOException e) {
					e.printStackTrace();
					return 0;
				}
				message.setType("student");
				message.setContent(stu.getStudentName()+"请假待批准");
				if(info.getLeaveType().equals("3")) {
					message.setRecipient(stu.getStudentClass().getClassGuideTeacher());
				}else {
					message.setRecipient(stu.getStudentClass().getClassHeadTeacher());
				 }
				message.setApplyTime(info.getLeaveApplyTime());
				message.setLeaveNum(info.getStudentLeaveNum());
				IninService.messagesMap.put(info.getStudentLeaveNum(),message);
				WebSocketSubject.Holder.getSubject(message.getRecipient()).notify(message.getRecipient());
				return flag;
		
	}
	@Override
	public List<StudentLeaveInfo> queryLeave(StudentLeaveInfo info) {
		List<StudentLeaveInfo> list = mapper.queryLeave(info);
		for(StudentLeaveInfo leave:mapper.queryWaitLeave(info)) {
			list.add(0, leave);
		}
		return list;
	}
	@Override
	public Integer updateMessage(Map<String, String> info) {
		
		return mapper.updateMessage(info);
	}
}
