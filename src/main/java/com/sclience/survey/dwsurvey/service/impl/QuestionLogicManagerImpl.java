package com.sclience.survey.dwsurvey.service.impl;

import com.sclience.survey.dwsurvey.dao.QuestionLogicDao;
import com.sclience.survey.dwsurvey.entity.QuestionLogic;
import com.sclience.survey.dwsurvey.service.QuestionLogicManager;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 题逻辑
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
@Service
public class QuestionLogicManagerImpl implements QuestionLogicManager {
		@Autowired
		private QuestionLogicDao questionLogicDao;

		@Override
		public List<QuestionLogic> findByCkQuId(String ckQuId) {
			Criterion cri1=Restrictions.eq("ckQuId", ckQuId);
			Criterion cri2=Restrictions.eq("visibility", 1);
			return questionLogicDao.find(cri1,cri2);
		}
}
