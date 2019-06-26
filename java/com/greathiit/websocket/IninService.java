package com.greathiit.websocket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.greathiit.entity.Message;
import com.greathiit.entity.StudentLeaveInfo;
import com.greathiit.service.IManagerTeacherService;
import com.greathiit.service.ITeacherService;
/**
 * @author DSJ
 * 当服务器重启后将数据库未审批的请假信息读取到内存中
 * **/
@Component
public final class IninService implements InitializingBean{
	public static Map<String,Message> messagesMap = new ConcurrentHashMap<>((int)(16/0.75)+1);
	public static Map<String, StudentLeaveInfo> studentLeaveWait = new  ConcurrentHashMap<>((int)(16/0.75)+1);
	@Autowired
	ITeacherService service; 
	@Autowired
	IManagerTeacherService teacher;
	public static String dean ;
	public void afterPropertiesSet() throws Exception {	
		dean = teacher.getDean();
		List<Message> message = null; 
		message = service.getOneApproval();
		this.pushMessage(message,"student");
		message = teacher.getOneApproval();
		this.pushMessage(message,"teacher");
	}
	private void pushMessage(List<Message> message,String post) {
		for(Message ms : message) {
			Message temp = new Message();
			temp.setType(post);
			temp.setContent(ms.getContent()+"请假待批准");
			temp.setRecipient(ms.getRecipient());
			temp.setApplyTime(ms.getApplyTime());
			temp.setLeaveNum(ms.getLeaveNum());
			messagesMap.put(ms.getLeaveNum(), temp);
		}
	}
	public static  List<Message> getMessage(String key) {
		List<Message> list = new ArrayList<>();
		for(Message ms: IninService.messagesMap.values()) {
			if(key.equals(ms.getRecipient())) {
				list.add(ms);
			}
		}
		return list;
	}	
}
