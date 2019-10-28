package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.dwsurvey.entity.QuestionLogic;

import java.util.List;

/**
 * 题逻辑
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface QuestionLogicManager {

	List<QuestionLogic> findByCkQuId(String quId);

}
