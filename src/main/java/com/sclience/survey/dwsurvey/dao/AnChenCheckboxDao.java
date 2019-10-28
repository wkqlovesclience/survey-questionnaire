package com.sclience.survey.dwsurvey.dao;

import com.sclience.survey.common.dao.BaseDao;
import com.sclience.survey.dwsurvey.entity.AnChenCheckbox;
import com.sclience.survey.dwsurvey.entity.Question;

/**
 * 矩陈多选题数据 interface
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 *
 */
public interface AnChenCheckboxDao extends BaseDao<AnChenCheckbox, String>{

	public void findGroupStats(Question question);

}
