package com.sclience.survey.dwsurvey.dao;

import com.sclience.survey.common.dao.BaseDao;
import com.sclience.survey.dwsurvey.entity.AnScore;
import com.sclience.survey.dwsurvey.entity.Question;

/**
 * 评分题 interface
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 *
 */
public interface AnScoreDao extends BaseDao<AnScore, String>{

	public void findGroupStats(Question question);

}
