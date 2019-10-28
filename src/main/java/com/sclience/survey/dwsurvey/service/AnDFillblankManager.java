package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.common.plugs.page.Page;
import com.sclience.survey.common.service.BaseService;
import com.sclience.survey.dwsurvey.entity.AnDFillblank;
import com.sclience.survey.dwsurvey.entity.Question;

import java.util.List;

/**
 * 多项填空题
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface AnDFillblankManager extends BaseService<AnDFillblank, String>{
	public List<AnDFillblank> findAnswer(String belongAnswerId, String quId);

	public void findGroupStats(Question question);

	public Page<AnDFillblank> findPage(Page<AnDFillblank> page, String quItemId);

}
