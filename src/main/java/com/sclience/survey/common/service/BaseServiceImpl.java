package com.sclience.survey.common.service;

import com.sclience.survey.common.base.entity.IdEntity;
import com.sclience.survey.common.dao.BaseDao;
import com.sclience.survey.common.plugs.page.Page;
import com.sclience.survey.common.plugs.page.PropertyFilter;
import org.hibernate.criterion.Criterion;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * 业务基类
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * /
 */
@Transactional
public abstract class BaseServiceImpl<T extends IdEntity, ID extends Serializable>
		implements BaseService<T, ID> {

	protected BaseDao<T, ID> baseDao;

	protected BaseDao<T, ID> getBaseDao() {
		if (baseDao == null) {
			setBaseDao();
		}
		return baseDao;
	}

	@Override
	public void save(T t) {
		String id = t.getId();
		if (id != null && "".equals(id)) {
			t.setId(null);
		}
		getBaseDao().save(t);
	}

	@Override
	public void delete(T t) {
		getBaseDao().delete(t);
	}

	public void delete(ID id) {
		getBaseDao().delete(get(id));
	};

	public T get(ID id) {
		return getBaseDao().get(id);
	}

	public T getModel(ID id) {
		return getBaseDao().getModel(id);
	};

	public Page<T> findPage(Page<T> page, List<PropertyFilter> filters) {
		return getBaseDao().findPage(page, filters);
	}

	@Override
	public List<T> findList(List<PropertyFilter> filters) {
		return getBaseDao().find(filters);
	}

	@Override
	public List<T> findAll(Page<T> page, List<PropertyFilter> filters) {
		return getBaseDao().findAll(page, filters);
	}

	@Override
	public List<T> findList(Criterion... criterions) {
		return getBaseDao().find(criterions);
	}

	@Override
	public Page<T> findPage(Page<T> page, Criterion... criterions) {
		return getBaseDao().findPage(page, criterions);
	}

	public Page<T> findPageByCri(Page<T> page, List<Criterion> criterions) {
		return getBaseDao().findPageByCri(page, criterions);
	}
}
