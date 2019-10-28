package com.sclience.survey.dwsurvey.service.impl;

import com.sclience.survey.common.service.BaseServiceImpl;
import com.sclience.survey.dwsurvey.dao.AnOrderDao;
import com.sclience.survey.dwsurvey.entity.AnOrder;
import com.sclience.survey.dwsurvey.entity.Question;
import com.sclience.survey.dwsurvey.service.AnOrderManager;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 排序题
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
@Service
public class AnOrderManagerImpl extends BaseServiceImpl<AnOrder, String> implements AnOrderManager {

	@Autowired
	private AnOrderDao anOrderDao;

	@Override
	public void setBaseDao() {
		this.baseDao=anOrderDao;
	}

	@Override
	public List<AnOrder> findAnswer(String belongAnswerId, String quId) {//belongAnswerId quId
		Criterion criterion1=Restrictions.eq("belongAnswerId", belongAnswerId);
		Criterion criterion2=Restrictions.eq("quId", quId);
		return anOrderDao.find(criterion1,criterion2);
	}

	@Override
	public void findGroupStats(Question question) {
		anOrderDao.findGroupStats(question);
	}

}
