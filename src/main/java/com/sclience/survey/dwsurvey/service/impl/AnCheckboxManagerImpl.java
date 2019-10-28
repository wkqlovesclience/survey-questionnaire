package com.sclience.survey.dwsurvey.service.impl;

import com.sclience.survey.common.service.BaseServiceImpl;
import com.sclience.survey.dwsurvey.dao.AnCheckboxDao;
import com.sclience.survey.dwsurvey.entity.AnCheckbox;
import com.sclience.survey.dwsurvey.entity.DataCross;
import com.sclience.survey.dwsurvey.entity.Question;
import com.sclience.survey.dwsurvey.service.AnCheckboxManager;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 多选题
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */

@Service
public class AnCheckboxManagerImpl extends BaseServiceImpl<AnCheckbox, String> implements AnCheckboxManager {

	@Autowired
	private AnCheckboxDao anCheckboxDao;

	@Override
	public void setBaseDao() {
		this.baseDao=anCheckboxDao;
	}

	//根据exam_user信息查询答案
		public List<AnCheckbox> findAnswer(String belongAnswerId,String quId){
			//belongAnswerId quId
			Criterion criterion1=Restrictions.eq("belongAnswerId", belongAnswerId);
			Criterion criterion2=Restrictions.eq("quId", quId);
			return anCheckboxDao.find(criterion1,criterion2);
		}

		@Override
		public void findGroupStats(Question question) {
			anCheckboxDao.findGroupStats(question);
		}

		@Override
		public List<DataCross> findStatsDataCross(Question rowQuestion,
				Question colQuestion) {
			return anCheckboxDao.findStatsDataCross(rowQuestion,colQuestion);
		}

		@Override
		public List<DataCross> findStatsDataChart(Question question) {
			return anCheckboxDao.findStatsDataChart(question);
		}


}
