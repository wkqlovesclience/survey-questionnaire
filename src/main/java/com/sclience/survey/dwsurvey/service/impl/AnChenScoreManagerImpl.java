package com.sclience.survey.dwsurvey.service.impl;

import com.sclience.survey.common.service.BaseServiceImpl;
import com.sclience.survey.dwsurvey.dao.AnChenScoreDao;
import com.sclience.survey.dwsurvey.entity.AnChenScore;
import com.sclience.survey.dwsurvey.entity.Question;
import com.sclience.survey.dwsurvey.service.AnChenScoreManager;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 矩陈评分题
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
@Service
public class AnChenScoreManagerImpl extends BaseServiceImpl<AnChenScore, String> implements AnChenScoreManager {

	@Autowired
	private AnChenScoreDao anChenScoreDao;

	@Override
	public void setBaseDao() {
		this.baseDao=anChenScoreDao;
	}

	@Override
	public List<AnChenScore> findAnswer(String belongAnswerId, String quId) {//belongAnswerId quId
		Criterion criterion1=Restrictions.eq("belongAnswerId", belongAnswerId);
		Criterion criterion2=Restrictions.eq("quId", quId);
		return anChenScoreDao.find(criterion1,criterion2);
	}

	@Override
	public void findGroupStats(Question question) {
		anChenScoreDao.findGroupStats(question);
	}

}
