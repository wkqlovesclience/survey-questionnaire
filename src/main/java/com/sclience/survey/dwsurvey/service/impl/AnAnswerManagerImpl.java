package com.sclience.survey.dwsurvey.service.impl;

import com.sclience.survey.common.service.BaseServiceImpl;
import com.sclience.survey.dwsurvey.dao.AnAnswerDao;
import com.sclience.survey.dwsurvey.entity.AnAnswer;
import com.sclience.survey.dwsurvey.entity.Question;
import com.sclience.survey.dwsurvey.service.AnAnswerManager;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangkeqiang
 * wkqsclience118706@163.com
 *
 */

@Service
public class AnAnswerManagerImpl extends BaseServiceImpl<AnAnswer, String> implements AnAnswerManager {

	@Autowired
	private AnAnswerDao anAnswerDao;

	@Override
	public void setBaseDao() {
		this.baseDao=anAnswerDao;
	}


	//根据exam_user信息查询答案
		public AnAnswer findAnswer(String belongAnswerId,String quId){
			Criterion criterion1=Restrictions.eq("belongAnswerId", belongAnswerId);
			Criterion criterion2=Restrictions.eq("quId", quId);
			return anAnswerDao.findUnique(criterion1,criterion2);
		}


		@Override
		public void findGroupStats(Question question) {
			anAnswerDao.findGroupStats(question);
		}

}
