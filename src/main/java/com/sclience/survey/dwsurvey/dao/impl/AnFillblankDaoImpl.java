package com.sclience.survey.dwsurvey.dao.impl;

import com.sclience.survey.common.dao.BaseDaoImpl;
import com.sclience.survey.dwsurvey.dao.AnFillblankDao;
import com.sclience.survey.dwsurvey.entity.AnFillblank;
import com.sclience.survey.dwsurvey.entity.Question;
import org.springframework.stereotype.Repository;

/**
 * 填空 dao
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */

@Repository
public class AnFillblankDaoImpl extends BaseDaoImpl<AnFillblank, String> implements AnFillblankDao{

	@Override
	public void findGroupStats(Question question) {
		String sql="select count(case when answer='' then answer end) emptyCount, count(case when answer!='' then answer end) blankCount from t_an_fillblank where  visibility=1 and  qu_id=?";
		Object[] objs=(Object[]) this.getSession().createSQLQuery(sql).setString(0, question.getId()).uniqueResult();

		question.setRowContent(objs[0].toString());//未回答数
		question.setOptionContent(objs[1].toString());//回答的项数
		question.setAnCount(Integer.parseInt(objs[1].toString()));
	}

}
