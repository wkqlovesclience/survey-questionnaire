package com.sclience.survey.dwsurvey.dao.impl;

import com.sclience.survey.common.dao.BaseDaoImpl;
import com.sclience.survey.dwsurvey.dao.AnDFillblankDao;
import com.sclience.survey.dwsurvey.entity.AnDFillblank;
import com.sclience.survey.dwsurvey.entity.QuMultiFillblank;
import com.sclience.survey.dwsurvey.entity.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 多项填空 dao
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */

@Repository
public class AnDFillblankDaoImpl extends BaseDaoImpl<AnDFillblank, String> implements AnDFillblankDao {

	@Override
	public void findGroupStats(Question question) {
		String sql="select qu_item_id,count(*) from t_an_dfillblank where  visibility=1 and  qu_id=? group by qu_item_id";

		List<Object[]> list=this.getSession().createSQLQuery(sql).setString(0, question.getId()).list();
		List<QuMultiFillblank> quMultiFillblanks=question.getQuMultiFillblanks();

		for (QuMultiFillblank quMultiFillblank : quMultiFillblanks) {
			String quMultiFillblankId=quMultiFillblank.getId();
			for (Object[] objects : list) {
				if(quMultiFillblankId.equals(objects[0].toString())){
					quMultiFillblank.setAnCount(Integer.parseInt(objects[1].toString()));
					break;
				}
			}
		}
	}

}
