package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.common.base.entity.User;
import com.sclience.survey.common.plugs.page.Page;
import com.sclience.survey.common.service.BaseService;
import com.sclience.survey.dwsurvey.entity.Question;
import com.sclience.survey.dwsurvey.entity.SurveyAnswer;
import com.sclience.survey.dwsurvey.entity.SurveyDetail;
import com.sclience.survey.dwsurvey.entity.SurveyStats;

import java.util.List;
import java.util.Map;

/**
 * 问卷回答
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface SurveyAnswerManager extends BaseService<SurveyAnswer, String>{

	public void saveAnswer(SurveyAnswer surveyAnswer, Map<String, Map<String, Object>> quMaps);

	public List<Question> findAnswerDetail(SurveyAnswer answer);

	public List<SurveyAnswer> answersByIp(String surveyId, String ip);

	public SurveyAnswer getTimeInByIp(SurveyDetail surveyDetail, String ip);

	public Long getCountByIp(String surveyId, String ip);

	public String exportXLS(String surveyId, String savePath);

	public SurveyStats surveyStatsData(SurveyStats surveyStats);

	public Page<SurveyAnswer> joinSurvey(Page<SurveyAnswer> page, User user) ;

	/**
	 * 取出某份问卷的答卷数据
	 * @param page
	 * @param surveyId
	 * @return
	 */
	public Page<SurveyAnswer> answerPage(Page<SurveyAnswer> page, String surveyId);

}
