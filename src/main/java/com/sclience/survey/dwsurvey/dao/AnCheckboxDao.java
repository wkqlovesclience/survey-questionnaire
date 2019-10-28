package com.sclience.survey.dwsurvey.dao;

import com.sclience.survey.common.dao.BaseDao;
import com.sclience.survey.dwsurvey.entity.AnCheckbox;
import com.sclience.survey.dwsurvey.entity.DataCross;
import com.sclience.survey.dwsurvey.entity.Question;

import java.util.List;


/**
 * 多选题数据 interface
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 *
 */
public interface AnCheckboxDao extends BaseDao<AnCheckbox, String>{

	public void findGroupStats(Question question);

	public List<DataCross> findStatsDataCross(Question rowQuestion,
                                              Question colQuestion);

	public List<DataCross> findStatsDataChart(Question question);

}
