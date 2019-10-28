package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.common.service.BaseService;
import com.sclience.survey.dwsurvey.entity.QuChenRow;

import java.util.List;

/**
 * 矩陈题行
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface QuChenRowManager extends BaseService<QuChenRow, String>{
	public List<QuChenRow> findByQuId(String quId);

	public String getContentByQuId(String quId);

	public QuChenRow upOptionName(String quId, String quItemId, String optionName);

	public void ajaxDelete(String quItemId);
}
