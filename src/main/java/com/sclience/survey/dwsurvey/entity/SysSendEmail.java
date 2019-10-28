package com.sclience.survey.dwsurvey.entity;

import com.sclience.survey.common.base.entity.IdEntity;

import java.util.Date;

/**
 * 系统邮件
 * @author wangkeqiang
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public class SysSendEmail extends IdEntity {
	//收件用户
	private String inboxUserId;
	//1注册激活邮件  2激活邮件   3找回密码邮件
	private Integer emailType;
	//创建 时间
	private Date createDate=new Date();
	//状态 0未发送 1发送成功 2发送失败
	private Integer status=0;

	public String getInboxUserId() {
		return inboxUserId;
	}
	public void setInboxUserId(String inboxUserId) {
		this.inboxUserId = inboxUserId;
	}
	public Integer getEmailType() {
		return emailType;
	}
	public void setEmailType(Integer emailType) {
		this.emailType = emailType;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

}
