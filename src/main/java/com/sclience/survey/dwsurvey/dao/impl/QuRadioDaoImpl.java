package com.sclience.survey.dwsurvey.dao.impl;

import com.sclience.survey.common.dao.BaseDaoImpl;
import com.sclience.survey.dwsurvey.dao.QuRadioDao;
import com.sclience.survey.dwsurvey.entity.QuRadio;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

/**
 * 单选题 dao
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */

//@Repository("quRadioDao")
@Repository
public class QuRadioDaoImpl extends BaseDaoImpl<QuRadio, String> implements QuRadioDao {

	public void quOrderByIdDel1(String quId,Integer orderById){
		if(quId!=null && !"".equals(quId)){
			String sql="update t_qu_radio set order_by_id=order_by_id-1 where qu_id=? and order_by_id>=?";
			//更新排序号
			SQLQuery query=this.getSession().createSQLQuery(sql);
			query.setString(0, quId);
			query.setInteger(1, orderById);
			query.executeUpdate();
		}
	}

}
