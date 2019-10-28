package com.sclience.survey.dwsurvey.service.impl;

import com.sclience.survey.common.service.BaseServiceImpl;
import com.sclience.survey.dwsurvey.dao.AnCompChenRadioDao;
import com.sclience.survey.dwsurvey.entity.AnCompChenRadio;
import com.sclience.survey.dwsurvey.service.AnCompChenRadioManager;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 复合矩陈单选题
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
@Service
public class AnCompChenRadioManagerImpl extends BaseServiceImpl<AnCompChenRadio, String> implements AnCompChenRadioManager {

	@Autowired
	private AnCompChenRadioDao anCompChenRadioDao;

	@Override
	public void setBaseDao() {
		this.baseDao=anCompChenRadioDao;
	}

	@Override
	public List<AnCompChenRadio> findAnswer(String belongAnswerId, String quId) {//belongAnswerId quId
		Criterion criterion1=Restrictions.eq("belongAnswerId", belongAnswerId);
		Criterion criterion2=Restrictions.eq("quId", quId);
		return anCompChenRadioDao.find(criterion1,criterion2);
	}
}
