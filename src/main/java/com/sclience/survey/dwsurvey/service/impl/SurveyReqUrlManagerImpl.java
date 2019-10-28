package com.sclience.survey.dwsurvey.service.impl;

import com.sclience.survey.common.utils.RandomUtils;
import com.sclience.survey.dwsurvey.dao.SurveyReqUrlDao;
import com.sclience.survey.dwsurvey.entity.SurveyReqUrl;
import com.sclience.survey.dwsurvey.service.SurveyReqUrlManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 短链地址
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
@Service
public class SurveyReqUrlManagerImpl  implements SurveyReqUrlManager {

	@Autowired
	private SurveyReqUrlDao surveyReqUrlDao;

	@Transactional
	public void save(SurveyReqUrl entity){
		String sId=entity.getSid();
		if(sId==null || "".equals(sId)){
			sId=RandomUtils.randomStr(6, 12);
			entity.setSid(sId);
		}
		surveyReqUrlDao.save(entity);
	}

	public void getByShortId(String shortId){

	}

}
