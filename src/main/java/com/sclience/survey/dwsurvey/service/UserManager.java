package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.common.base.entity.User;
import com.sclience.survey.common.plugs.page.Page;
import com.sclience.survey.common.service.BaseService;

public interface UserManager extends BaseService<User, String>{

	public void adminSave(User entity, String[] userRoleIds);

	public Page<User> findPage(Page<User> page, User entity);

	public void disUser(String id);

	public User findNameUn(String id, String loginName);

	public User findEmailUn(String id, String email);

	public User findByCode(String code);

	public User findByActivationCode(String code);

	public void resetUserGroup(String groupId);

}
