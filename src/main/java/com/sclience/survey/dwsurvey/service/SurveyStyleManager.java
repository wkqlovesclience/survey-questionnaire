package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.dwsurvey.entity.SurveyStyle;

/**
 * 问卷样式
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface SurveyStyleManager  {

	public SurveyStyle get(String id) ;

	public SurveyStyle getBySurveyId(String surveyId) ;

	public void save(SurveyStyle surveyStyle) ;
}
