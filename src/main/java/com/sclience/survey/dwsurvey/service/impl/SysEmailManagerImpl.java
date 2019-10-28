package com.sclience.survey.dwsurvey.service.impl;

import com.sclience.survey.common.service.BaseServiceImpl;
import com.sclience.survey.dwsurvey.dao.SysEmailDao;
import com.sclience.survey.dwsurvey.entity.SysEmail;
import com.sclience.survey.dwsurvey.service.SysEmailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysEmailManagerImpl extends BaseServiceImpl<SysEmail, String> implements SysEmailManager {

	@Autowired
	private SysEmailDao sysEmailDao;

	@Override
	public void setBaseDao() {
		this.baseDao=sysEmailDao;
	}

}
