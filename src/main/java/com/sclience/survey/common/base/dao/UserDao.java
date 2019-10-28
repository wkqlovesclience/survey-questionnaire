package com.sclience.survey.common.base.dao;

import com.sclience.survey.common.base.entity.User;
import com.sclience.survey.common.dao.BaseDao;


/**
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface UserDao extends BaseDao<User, String> {

	public void resetUserGroup(String groupId);

}
