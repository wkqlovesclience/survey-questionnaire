package com.sclience.survey.dwsurvey.dao;

import com.sclience.survey.common.dao.BaseDao;
import com.sclience.survey.dwsurvey.entity.AnChenRadio;
import com.sclience.survey.dwsurvey.entity.Question;

/**
 * 矩陈单选题数据 interface
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 *
 */
public interface AnChenRadioDao extends BaseDao<AnChenRadio, String>{

	public void findGroupStats(Question question);

}
