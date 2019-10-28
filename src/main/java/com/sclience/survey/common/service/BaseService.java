package com.sclience.survey.common.service;

import com.sclience.survey.common.base.entity.IdEntity;
import com.sclience.survey.common.plugs.page.Page;
import com.sclience.survey.common.plugs.page.PropertyFilter;
import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.util.List;

/**
 * 业务基类接口
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface BaseService<T extends IdEntity,ID extends Serializable> {

	public void setBaseDao();

	public void save(T t);

	public void delete(T t);

	public void delete(ID id);

	public T get(ID id);

	public T getModel(ID id);

	public Page<T> findPage(Page<T> page, List<PropertyFilter> filters);

	public List<T> findList(List<PropertyFilter> filters);

	public List<T> findAll(Page<T> page, List<PropertyFilter> filters);

	public List<T> findList(Criterion... criterions);

	public Page<T> findPage(Page<T> page, Criterion... criterion);
}
