package com.sclience.survey.dwsurvey.service.impl;

import com.sclience.survey.common.base.dao.UserDao;
import com.sclience.survey.common.base.entity.User;
import com.sclience.survey.common.plugs.page.Page;
import com.sclience.survey.common.service.BaseServiceImpl;
import com.sclience.survey.common.utils.security.DigestUtils;
import com.sclience.survey.dwsurvey.service.UserManager;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * 用户管理
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
@Service
public class UserManagerImpl extends BaseServiceImpl<User, String> implements UserManager {

	@Autowired
	private UserDao userDao;

	@Override
	public void setBaseDao() {
		this.baseDao=userDao;
	}

	@Override
	public void adminSave(User entity, String[] userRoleIds) {
		if(entity!=null){

			String pwd=entity.getPwd();
			if(pwd!=null && !"".equals(pwd)){
				//加点盐
//				String salt=RandomUtils.randomWordNum(5);
				String shaPassword = DigestUtils.sha1Hex(pwd);
				entity.setShaPassword(shaPassword);
//				entity.setSalt(salt);
			}
			save(entity);
		}
	}

	public Page<User> findPage(Page<User> page, User entity) {
		List<Criterion> criterions=new ArrayList<Criterion>();
		Integer status = entity.getStatus();
		String loginName = entity.getLoginName();
		if(status!=null && !"".equals(status)){
			criterions.add(Restrictions.eq("status", status));
		}
		if(loginName!=null && !"".equals(loginName)){
			criterions.add(Restrictions.like("loginName", "%"+loginName+"%"));
		}
		return super.findPageByCri(page, criterions);
	}

	/**
	 * 禁用账号
	 */
	@Transactional
	@Override
	public void disUser(String id) {
		User user=get(id);
		int status=user.getStatus();
		if(status==0){
			user.setStatus(1);
		}else{
			user.setStatus(0);
		}
		save(user);
	}

	@Override
	public User findNameUn(String id, String loginName) {
		List<Criterion> criterions=new ArrayList<Criterion>();
		criterions.add(Restrictions.eq("loginName", loginName));
		if(id!=null && !"".equals(id)){
			criterions.add(Restrictions.ne("id", id));
		}
		return userDao.findFirst(criterions);
	}

	@Override
	public User findEmailUn(String id, String email) {
		List<Criterion> criterions=new ArrayList<Criterion>();
		criterions.add(Restrictions.eq("email", email));
		if(id!=null && !"".equals(id)){
			criterions.add(Restrictions.ne("id", id));
		}
		return userDao.findFirst(criterions);
	}

	@Override
	public User findByCode(String code) {
		Criterion criterion=Restrictions.eq("findPwdCode", code);
		return userDao.findFirst(criterion);
	}

	@Override
	public User findByActivationCode(String activationCode) {
		Criterion criterion=Restrictions.eq("activationCode", activationCode);
		return userDao.findFirst(criterion);
	}

	@Override
	public void resetUserGroup(String groupId) {
		userDao.resetUserGroup(groupId);
	}
}
