package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.common.service.BaseService;
import com.sclience.survey.dwsurvey.entity.AnScore;
import com.sclience.survey.dwsurvey.entity.Question;

import java.util.List;

/**
 * 评分题
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface AnScoreManager extends BaseService<AnScore, String>{
	public List<AnScore>  findAnswer(String belongAnswerId, String quId);

	public void findGroupStats(Question question);
}
