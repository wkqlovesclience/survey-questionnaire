package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.common.service.BaseService;
import com.sclience.survey.dwsurvey.entity.QuChenOption;

import java.util.List;

/**
 * 矩陈题选项
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface QuChenOptionManager extends BaseService<QuChenOption, String>{
	public List<QuChenOption> findByQuId(String quId);

	public String getContentByQuId(String quId);

	public QuChenOption upOptionName(String quId, String quItemId, String optionName);
}
