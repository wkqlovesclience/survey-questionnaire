package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.common.service.BaseService;
import com.sclience.survey.dwsurvey.entity.AnChenCheckbox;
import com.sclience.survey.dwsurvey.entity.Question;

import java.util.List;

/**
 * 矩陈多选题业务
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */

public interface AnChenCheckboxManager extends BaseService<AnChenCheckbox, String> {
	public List<AnChenCheckbox> findAnswer(String belongAnswerId, String quId);

	public void findGroupStats(Question question);
}
