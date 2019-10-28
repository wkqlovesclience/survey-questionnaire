package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.common.service.BaseService;
import com.sclience.survey.dwsurvey.entity.SurveyDetail;

/**
 * 问卷评情
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface SurveyDetailManager extends BaseService<SurveyDetail, String>{

	public SurveyDetail getBySurveyId(String surveyId);

}
