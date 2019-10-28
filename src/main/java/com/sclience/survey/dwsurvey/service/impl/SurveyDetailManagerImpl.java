package com.sclience.survey.dwsurvey.service.impl;

import com.sclience.survey.common.service.BaseServiceImpl;
import com.sclience.survey.common.utils.ReflectionUtils;
import com.sclience.survey.dwsurvey.dao.SurveyDetailDao;
import com.sclience.survey.dwsurvey.entity.SurveyDetail;
import com.sclience.survey.dwsurvey.service.SurveyDetailManager;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 问卷详情
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
@Service
public class SurveyDetailManagerImpl extends BaseServiceImpl<SurveyDetail, String> implements SurveyDetailManager{

	@Autowired
	private SurveyDetailDao surveyDetailDao;

	@Override
	public void setBaseDao() {
		this.baseDao=surveyDetailDao;
	}

	@Transactional
	@Override
	public void save(SurveyDetail t) {
		//判断有无，有则更新
		SurveyDetail surveyDetail=findUn(t.getDirId());
		if(surveyDetail==null){
			surveyDetail=new SurveyDetail();
		}
		ReflectionUtils.copyAttr(t,surveyDetail);
		super.save(surveyDetail);
	}

	private SurveyDetail findUn(String dirId){
		Criterion criterion=Restrictions.eq("dirId", dirId);
		 List<SurveyDetail> details=surveyDetailDao.find(criterion);
		 if(details!=null && details.size()>0){
			 return details.get(0);
		 }
		 return null;
	}

	@Override
	public SurveyDetail getBySurveyId(String surveyId) {
		 return findUn(surveyId);
	}

}
