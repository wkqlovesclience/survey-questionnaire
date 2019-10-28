package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.common.service.BaseService;
import com.sclience.survey.dwsurvey.entity.AnYesno;
import com.sclience.survey.dwsurvey.entity.DataCross;
import com.sclience.survey.dwsurvey.entity.Question;

import java.util.List;

/**
 * 是非题
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface AnYesnoManager extends BaseService<AnYesno, String>{
	public AnYesno findAnswer(String belongAnswerId, String quId);

	public void findGroupStats(Question question);

	public List<DataCross> findStatsDataCross(Question rowQuestion, Question colQuestion);

	public List<DataCross> findStatsDataChart(Question question);
}
