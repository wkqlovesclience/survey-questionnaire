package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.common.service.BaseService;
import com.sclience.survey.dwsurvey.entity.QuRadio;

import java.util.List;

/**
 * 单选题
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface QuRadioManager  extends BaseService<QuRadio, String>{
	public List<QuRadio> findByQuId(String quId);

	public QuRadio upOptionName(String quId, String quItemId, String optionName);

	public List<QuRadio> saveManyOptions(String quId, List<QuRadio> quRadios);

	public void ajaxDelete(String quItemId);

	public void saveAttr(String quItemId, String isNote);
}
