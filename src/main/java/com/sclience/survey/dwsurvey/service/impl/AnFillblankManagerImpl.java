package com.sclience.survey.dwsurvey.service.impl;

import com.sclience.survey.common.plugs.page.Page;
import com.sclience.survey.common.service.BaseServiceImpl;
import com.sclience.survey.dwsurvey.dao.AnFillblankDao;
import com.sclience.survey.dwsurvey.entity.AnFillblank;
import com.sclience.survey.dwsurvey.entity.Question;
import com.sclience.survey.dwsurvey.service.AnFillblankManager;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 填空题
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
@Service
public class AnFillblankManagerImpl extends BaseServiceImpl<AnFillblank, String> implements AnFillblankManager {

	@Autowired
	private AnFillblankDao anFillblankDao;

	@Override
	public void setBaseDao() {
		this.baseDao=anFillblankDao;
	}

	//根据exam_user信息查询答案
	public AnFillblank findAnswer(String belongAnswerId,String quId){
		//belongAnswerId quId
		Criterion criterion1=Restrictions.eq("belongAnswerId", belongAnswerId);
		Criterion criterion2=Restrictions.eq("quId", quId);
		return anFillblankDao.findUnique(criterion1,criterion2);
	}

	@Override
	public void findGroupStats(Question question) {
		anFillblankDao.findGroupStats(question);
	}


	@Override
	public Page<AnFillblank> findPage(Page<AnFillblank> page, String quId) {
		Criterion cri1 = Restrictions.eq("quId",quId);
		Criterion cri2 = Restrictions.eq("visibility",1);
		return findPage(page,cri1,cri2);
	}
}
