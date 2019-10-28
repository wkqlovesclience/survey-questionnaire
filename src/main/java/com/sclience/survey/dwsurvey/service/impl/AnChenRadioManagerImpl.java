package com.sclience.survey.dwsurvey.service.impl;

import com.sclience.survey.common.service.BaseServiceImpl;
import com.sclience.survey.dwsurvey.dao.AnChenRadioDao;
import com.sclience.survey.dwsurvey.entity.AnChenRadio;
import com.sclience.survey.dwsurvey.entity.DataCross;
import com.sclience.survey.dwsurvey.entity.Question;
import com.sclience.survey.dwsurvey.service.AnChenRadioManager;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 矩陈单选题
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
@Service
public class AnChenRadioManagerImpl extends BaseServiceImpl<AnChenRadio, String> implements AnChenRadioManager {

	@Autowired
	private AnChenRadioDao anChenRadioDao;

	@Override
	public void setBaseDao() {
		this.baseDao=anChenRadioDao;
	}

	@Override
	public List<AnChenRadio> findAnswer(String belongAnswerId, String quId) {//belongAnswerId quId
		Criterion criterion1=Restrictions.eq("belongAnswerId", belongAnswerId);
		Criterion criterion2=Restrictions.eq("quId", quId);
		return anChenRadioDao.find(criterion1,criterion2);
	}

	@Override
	public void findGroupStats(Question question) {
		anChenRadioDao.findGroupStats(question);
	}

	@Override
	public List<DataCross> findStatsDataChart(Question question) {
		// TODO Auto-generated method stub
		return null;
	}
}
