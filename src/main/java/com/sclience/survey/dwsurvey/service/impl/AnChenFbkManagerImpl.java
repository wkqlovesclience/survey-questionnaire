package com.sclience.survey.dwsurvey.service.impl;

import com.sclience.survey.common.service.BaseServiceImpl;
import com.sclience.survey.dwsurvey.dao.AnChenFbkDao;
import com.sclience.survey.dwsurvey.entity.AnChenFbk;
import com.sclience.survey.dwsurvey.entity.Question;
import com.sclience.survey.dwsurvey.service.AnChenFbkManager;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 矩陈填空题
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
@Service
public class AnChenFbkManagerImpl extends BaseServiceImpl<AnChenFbk, String> implements AnChenFbkManager {

	@Autowired
	private AnChenFbkDao anChenFbkDao;

	@Override
	public void setBaseDao() {
		this.baseDao=anChenFbkDao;
	}

	@Override
	public List<AnChenFbk> findAnswer(String belongAnswerId, String quId) {//belongAnswerId quId
		Criterion criterion1=Restrictions.eq("belongAnswerId", belongAnswerId);
		Criterion criterion2=Restrictions.eq("quId", quId);
		return anChenFbkDao.find(criterion1,criterion2);
	}

	@Override
	public void findGroupStats(Question question) {
		anChenFbkDao.findGroupStats(question);
	}
}
