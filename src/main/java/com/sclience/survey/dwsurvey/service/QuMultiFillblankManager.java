package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.common.service.BaseService;
import com.sclience.survey.dwsurvey.entity.QuMultiFillblank;

import java.util.List;

/**
 * 多项填空题
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface QuMultiFillblankManager  extends BaseService<QuMultiFillblank, String>{

	public List<QuMultiFillblank> findByQuId(String quId);

	public QuMultiFillblank upOptionName(String quId, String quItemId, String optionName);

	public List<QuMultiFillblank> saveManyOptions(String quId, List<QuMultiFillblank> quMultiFillblanks);

	public void ajaxDelete(String quItemId);

	public void saveAttr(String quItemId);

}
