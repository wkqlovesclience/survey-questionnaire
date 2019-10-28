package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.common.service.BaseService;
import com.sclience.survey.dwsurvey.entity.AnEnumqu;
import com.sclience.survey.dwsurvey.entity.Question;

import java.util.List;

/**
 * 枚举题
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface AnEnumquManager extends BaseService<AnEnumqu, String> {
	public  List<AnEnumqu> findAnswer(String belongAnswerId, String quId);

	public void findGroupStats(Question question);
}
