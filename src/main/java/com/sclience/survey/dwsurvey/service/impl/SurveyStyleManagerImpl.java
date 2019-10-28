package com.sclience.survey.dwsurvey.service.impl;

import com.sclience.survey.dwsurvey.dao.SurveyStyleDao;
import com.sclience.survey.dwsurvey.entity.SurveyStyle;
import com.sclience.survey.dwsurvey.service.SurveyStyleManager;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 问卷样式
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
@Service
public class SurveyStyleManagerImpl implements SurveyStyleManager {

	@Autowired
	private SurveyStyleDao surveyStyleDao;

	public SurveyStyle get(String id) {
		return surveyStyleDao.findUniqueBy("id", id);
	}

	public SurveyStyle getBySurveyId(String surveyId) {
		Criterion cri1=Restrictions.eq("surveyId", surveyId);
		return surveyStyleDao.findFirst(cri1);
	}

	@Transactional
	public void save(SurveyStyle surveyStyle){
		surveyStyleDao.save(surveyStyle);
	}

}
