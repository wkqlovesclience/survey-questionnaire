package com.sclience.survey.dwsurvey.service.impl;

import com.sclience.survey.common.service.BaseServiceImpl;
import com.sclience.survey.dwsurvey.dao.SysSendEmailDao;
import com.sclience.survey.dwsurvey.entity.SysSendEmail;
import com.sclience.survey.dwsurvey.service.SysSendEmailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysSendEmailManagerImpl extends BaseServiceImpl<SysSendEmail, String> implements SysSendEmailManager {

	@Autowired
	private SysSendEmailDao sysSendEmailDao;

	@Override
	public void setBaseDao() {
		this.baseDao=sysSendEmailDao;
	}

	@Override
	public void scanning() {
		//扫描没有发送的邮件，进行邮件发送操作，ok.

	}

}
