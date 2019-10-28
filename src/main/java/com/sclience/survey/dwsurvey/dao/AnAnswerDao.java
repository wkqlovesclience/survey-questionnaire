package com.sclience.survey.dwsurvey.dao;

import com.sclience.survey.common.dao.BaseDao;
import com.sclience.survey.dwsurvey.entity.AnAnswer;
import com.sclience.survey.dwsurvey.entity.Question;

/**
 * 答卷数据 interface
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 *
 */
public interface AnAnswerDao extends BaseDao<AnAnswer, String> {

	public void findGroupStats(Question question);

}
