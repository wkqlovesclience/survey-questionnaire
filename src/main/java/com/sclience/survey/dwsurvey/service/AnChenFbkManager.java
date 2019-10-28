package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.common.service.BaseService;
import com.sclience.survey.dwsurvey.entity.AnChenFbk;
import com.sclience.survey.dwsurvey.entity.Question;

import java.util.List;

/**
 * 矩陈填空题
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */

public interface AnChenFbkManager extends BaseService<AnChenFbk, String>{
	public List<AnChenFbk> findAnswer(String belongAnswerId, String quId);

	public void findGroupStats(Question question);
}
