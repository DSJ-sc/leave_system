package com.greathiit.entity;

public class Message {
	/**类型(学生/教师)**/
	private String type;
	/**标题**/
	private String leaveNum;
	/**内容**/
	private String content;
	/**发布（接收）者**/
	private String recipient;
	/**申请（发布）时间**/
	private String applyTime;
	
	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLeaveNum() {
		return leaveNum;
	}
	public void setLeaveNum(String leaveNum) {
		this.leaveNum = leaveNum;
	}
	
	
}
