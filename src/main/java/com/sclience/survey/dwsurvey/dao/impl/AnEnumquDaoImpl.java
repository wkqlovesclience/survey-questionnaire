package com.sclience.survey.dwsurvey.dao.impl;


import com.sclience.survey.common.dao.BaseDaoImpl;
import com.sclience.survey.dwsurvey.dao.AnEnumquDao;
import com.sclience.survey.dwsurvey.entity.AnEnumqu;
import com.sclience.survey.dwsurvey.entity.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 枚举 dao
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */

@Repository
public class AnEnumquDaoImpl extends BaseDaoImpl<AnEnumqu, String> implements AnEnumquDao {

	@Override
	public void findGroupStats(Question question) {
		String sql="select answer,count(answer) from t_an_enumqu where  visibility=1 and  qu_id=? GROUP BY answer";
		List<Object[]> list=this.getSession().createSQLQuery(sql).setString(0, question.getId()).list();

		//一共有多少对枚举数
		if(list!=null && list.size()>0){
			question.setAnCount(list.size());
		}
	}

}
