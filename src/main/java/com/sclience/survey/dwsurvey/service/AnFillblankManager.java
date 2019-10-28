package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.common.plugs.page.Page;
import com.sclience.survey.common.service.BaseService;
import com.sclience.survey.dwsurvey.entity.AnFillblank;
import com.sclience.survey.dwsurvey.entity.Question;

/**
 * 填空题
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface AnFillblankManager extends BaseService<AnFillblank, String>{
	public AnFillblank findAnswer(String belongAnswerId, String quId);

	public void findGroupStats(Question question);

	Page<AnFillblank> findPage(Page<AnFillblank> page, String quId);
}
