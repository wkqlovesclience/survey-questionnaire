package com.sclience.survey.dwsurvey.service.impl;

import com.sclience.survey.common.service.BaseServiceImpl;
import com.sclience.survey.dwsurvey.dao.AnYesnoDao;
import com.sclience.survey.dwsurvey.entity.AnYesno;
import com.sclience.survey.dwsurvey.entity.DataCross;
import com.sclience.survey.dwsurvey.entity.Question;
import com.sclience.survey.dwsurvey.service.AnYesnoManager;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 枚举题
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
@Service
public class AnYesnoManagerImpl extends BaseServiceImpl<AnYesno, String> implements AnYesnoManager {

	@Autowired
	private AnYesnoDao anYesnoDao;

	@Override
	public void setBaseDao() {
		this.baseDao=anYesnoDao;
	}

	//根据exam_user信息查询答案
	public AnYesno findAnswer(String belongAnswerId,String quId){
		//belongAnswerId quId
		Criterion criterion1=Restrictions.eq("belongAnswerId", belongAnswerId);
		Criterion criterion2=Restrictions.eq("quId", quId);
		return anYesnoDao.findUnique(criterion1,criterion2);
	}

	@Override
	public void findGroupStats(Question question) {
		anYesnoDao.findGroupStats(question);
	}

	@Override
	public List<DataCross> findStatsDataCross(Question rowQuestion, Question colQuestion) {
		return anYesnoDao.findStatsDataCross(rowQuestion,colQuestion);
	}

	@Override
	public List<DataCross> findStatsDataChart(Question question) {
		return anYesnoDao.findStatsDataChart(question);
	}

}
