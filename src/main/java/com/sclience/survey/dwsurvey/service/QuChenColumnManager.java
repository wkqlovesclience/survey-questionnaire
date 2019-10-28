package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.common.service.BaseService;
import com.sclience.survey.dwsurvey.entity.QuChenColumn;

import java.util.List;

/**
 * 矩陈题列
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface QuChenColumnManager extends BaseService<QuChenColumn, String> {

	public List<QuChenColumn> findByQuId(String quId);

	public String getContentByQuId(String quId);

	public QuChenColumn upOptionName(String quId, String quItemId, String optionName);

	public void ajaxDelete(String quItemId);

}
