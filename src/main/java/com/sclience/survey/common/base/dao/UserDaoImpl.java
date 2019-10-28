package com.sclience.survey.common.base.dao;

import com.sclience.survey.common.base.entity.User;
import com.sclience.survey.common.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;


/**
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User, String> implements UserDao{

	@Override
	public void resetUserGroup(String groupId) {
		String sql="UPDATE t_user SET user_group_id = '' WHERE id = id";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

}
