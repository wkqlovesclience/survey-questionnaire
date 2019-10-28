package com.sclience.survey.dwsurvey.service.impl;

import com.sclience.survey.common.service.BaseServiceImpl;
import com.sclience.survey.dwsurvey.dao.AnEnumquDao;
import com.sclience.survey.dwsurvey.entity.AnEnumqu;
import com.sclience.survey.dwsurvey.entity.Question;
import com.sclience.survey.dwsurvey.service.AnEnumquManager;
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
public class AnEnumquManagerImpl extends BaseServiceImpl<AnEnumqu, String> implements AnEnumquManager {

	@Autowired
	private AnEnumquDao anEnumquDao;

	@Override
	public void setBaseDao() {
		this.baseDao=anEnumquDao;
	}

	//根据exam_user信息查询答案
	public List<AnEnumqu> findAnswer(String belongAnswerId,String quId){
		//belongAnswerId quId
		Criterion criterion1=Restrictions.eq("belongAnswerId", belongAnswerId);
		Criterion criterion2=Restrictions.eq("quId", quId);
		return anEnumquDao.find(criterion1,criterion2);
	}

	@Override
	public void findGroupStats(Question question) {
		anEnumquDao.findGroupStats(question);
	}
}
