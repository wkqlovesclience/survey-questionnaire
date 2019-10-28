package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.common.service.BaseService;
import com.sclience.survey.dwsurvey.entity.DataCross;
import com.sclience.survey.dwsurvey.entity.Question;
import com.sclience.survey.dwsurvey.entity.SurveyDirectory;
import com.sclience.survey.dwsurvey.entity.SurveyStats;

import java.util.List;

/**
 * 统计报表
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface SurveyStatsManager extends BaseService<SurveyStats, String>{

	public SurveyStats findBySurvey(String surveyId);
	public SurveyStats findBySurvey(SurveyDirectory surveyDirectory);
	public SurveyStats findNewStatsData(SurveyDirectory survey);
	public List<Question> findFrequency(SurveyDirectory survey);
	public List<Question> findRowVarQus(SurveyDirectory survey);
	public List<Question> findColVarQus(SurveyDirectory survey);
	public List<DataCross> findStatsDataCross(String rowQuId, String colQuId);
	public List<DataCross> findDataChart(String quId);
	public List<Question> dataChart1s(SurveyDirectory survey);
	public void questionDateCross(Question question) ;
}
