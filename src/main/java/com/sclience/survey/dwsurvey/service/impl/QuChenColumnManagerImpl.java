package com.sclience.survey.dwsurvey.service.impl;

import com.sclience.survey.common.plugs.page.Page;
import com.sclience.survey.common.plugs.page.PropertyFilter;
import com.sclience.survey.common.service.BaseServiceImpl;
import com.sclience.survey.dwsurvey.dao.QuChenColumnDao;
import com.sclience.survey.dwsurvey.entity.QuChenColumn;
import com.sclience.survey.dwsurvey.service.QuChenColumnManager;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 矩陈题列
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
@Service
public class QuChenColumnManagerImpl extends BaseServiceImpl<QuChenColumn, String> implements QuChenColumnManager {

	@Autowired
	private QuChenColumnDao chenColumnDao;

	@Override
	public void setBaseDao() {
		this.baseDao=chenColumnDao;
	}

	@Override
	public List<QuChenColumn> findByQuId(String quId) {
		Page<QuChenColumn> page=new Page<QuChenColumn>();
		page.setOrderBy("orderById");
		page.setOrderDir("asc");

		List<PropertyFilter> filters=new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("EQS_quId", quId));
		filters.add(new PropertyFilter("EQI_visibility", "1"));
		return findAll(page, filters);
	}

	@Override
	public String getContentByQuId(String quId) {
		String content="";
		if(quId!=null && !"".equals(quId)){
			List<QuChenColumn> columns=findByQuId(quId);
			for (QuChenColumn quChenColumn : columns) {
				content+=quChenColumn.getOptionName()+"\r\n";
			}
		}
		return content;
	}

	public int getOrderById(String quId){
		Criterion criterion=Restrictions.eq("quId", quId);
		QuChenColumn quChenColumn=chenColumnDao.findFirst("orderById", false, criterion);
		if(quChenColumn!=null){
			return quChenColumn.getOrderById();
		}
		return 0;
	}

	@Override
	@Transactional
	public QuChenColumn upOptionName(String quId,String quItemId, String optionName) {
		if(quItemId!=null && !"".equals(quItemId)){
			QuChenColumn quChenColumn=chenColumnDao.get(quItemId);
			quChenColumn.setOptionName(optionName);
			chenColumnDao.save(quChenColumn);
			return quChenColumn;
		}else{
			//取orderById
			int orderById=getOrderById(quId);
			//新加选项
			QuChenColumn quChenColumn=new QuChenColumn();
			quChenColumn.setQuId(quId);
			quChenColumn.setOptionName(optionName);
			//title
			quChenColumn.setOrderById(++orderById);
			chenColumnDao.save(quChenColumn);
			return quChenColumn;
		}
	}


	@Override
	@Transactional
	public void ajaxDelete(String quItemId) {
		QuChenColumn quChenColumn=get(quItemId);
		quChenColumn.setVisibility(0);
		chenColumnDao.save(quChenColumn);
	}

}
