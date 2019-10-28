package com.sclience.survey.common.dao;

import java.io.Serializable;


/**
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface BaseDao<T,ID extends Serializable> extends IHibernateDao<T, ID>{

}
