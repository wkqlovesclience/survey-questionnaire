package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.common.service.BaseService;
import com.sclience.survey.dwsurvey.entity.AnChenScore;
import com.sclience.survey.dwsurvey.entity.Question;

import java.util.List;

/**
 * 矩陈评分题
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface AnChenScoreManager extends BaseService<AnChenScore, String>{
	public List<AnChenScore> findAnswer(String belongAnswerId, String quId);

	public void findGroupStats(Question question);
}
