package com.sclience.survey.dwsurvey.dao;

import com.sclience.survey.common.dao.BaseDao;
import com.sclience.survey.dwsurvey.entity.AnChenFbk;
import com.sclience.survey.dwsurvey.entity.Question;

/**
 * 矩陈填空题数据 interface
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 *
 */
public interface AnChenFbkDao extends BaseDao<AnChenFbk, String>{

	void findGroupStats(Question question);

}
