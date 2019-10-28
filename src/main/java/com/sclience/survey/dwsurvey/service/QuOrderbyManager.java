package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.common.service.BaseService;
import com.sclience.survey.dwsurvey.entity.QuOrderby;

import java.util.List;

/**
 * 排序题
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface QuOrderbyManager extends BaseService<QuOrderby, String>{

	public List<QuOrderby> findByQuId(String id);

	public QuOrderby upOptionName(String quId, String quItemId, String optionName);

	public List<QuOrderby> saveManyOptions(String quId, List<QuOrderby> quOrderbys);

	public void ajaxDelete(String quItemId);

	public void saveAttr(String quItemId);
}
