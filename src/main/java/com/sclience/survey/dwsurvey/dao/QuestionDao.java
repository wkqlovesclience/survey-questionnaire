package com.sclience.survey.dwsurvey.dao;

import com.sclience.survey.common.dao.BaseDao;
import com.sclience.survey.dwsurvey.entity.Question;

/**
 * 题基础 interface
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 *
 */
public interface QuestionDao extends BaseDao<Question, String>{

	public void update(Question entity);
	public void quOrderByIdDel1(String belongId, Integer orderById);
}
