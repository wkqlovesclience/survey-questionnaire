package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.common.service.BaseService;
import com.sclience.survey.dwsurvey.entity.QuCheckbox;

import java.util.List;

/**
 * 多选题
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface QuCheckboxManager  extends BaseService<QuCheckbox, String>{

	public List<QuCheckbox> findByQuId(String quId);

	public QuCheckbox upOptionName(String quId, String quItemId, String optionName);

	public List<QuCheckbox> saveManyOptions(String quId, List<QuCheckbox> quCheckboxs);

	public void ajaxDelete(String quItemId);

	public void saveAttr(String quItemId, String isNote);

}
