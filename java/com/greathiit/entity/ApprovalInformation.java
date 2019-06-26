package com.greathiit.entity;

/**
 * @author 邓世江
 * @date 2018年11月17日 下午9:10:03
 * 
 */
public class ApprovalInformation {
	/**请假ID**/
	private String leaveId;
	/**审批教师身份**/
	private String identity;
	/**审批信息**/
	private String approval;
	/**备注**/
	private String remarks;
	
	public String getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(String leaveId) {
		this.leaveId = leaveId;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	@Override
	public String toString() {
		return "ApprovalInformation [leaveId=" + leaveId + ", identity=" + identity + ", approval=" + approval
				+ ", remarks=" + remarks + "]";
	}
	
}
