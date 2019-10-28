package com.sclience.survey.dwsurvey.service.impl;

import com.sclience.survey.common.plugs.page.Page;
import com.sclience.survey.common.plugs.page.PropertyFilter;
import com.sclience.survey.common.service.BaseServiceImpl;
import com.sclience.survey.dwsurvey.dao.QuChenRowDao;
import com.sclience.survey.dwsurvey.entity.QuChenRow;
import com.sclience.survey.dwsurvey.service.QuChenRowManager;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * 矩陈题行
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
@Service
public class QuChenRowManagerImpl extends BaseServiceImpl<QuChenRow, String>implements QuChenRowManager {

	@Autowired
	private QuChenRowDao quChenRowDao;

	@Override
	public void setBaseDao() {
		this.baseDao=quChenRowDao;
	}

	@Override
	public List<QuChenRow> findByQuId(String quId) {
		Page<QuChenRow> page=new Page<QuChenRow>();
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
			List<QuChenRow> rows=findByQuId(quId);
			for (QuChenRow quChenRow : rows) {
				content+=quChenRow.getOptionName()+"\r\n";
			}
		}
		return content;
	}

	public int getOrderById(String quId){
		Criterion criterion=Restrictions.eq("quId", quId);
		QuChenRow quChenRow=quChenRowDao.findFirst("orderById", false, criterion);
		if(quChenRow!=null){
			return quChenRow.getOrderById();
		}
		return 0;
	}

	public QuChenRow upOptionName(String quId,String quItemId, String optionName){
		if(quItemId!=null && !"".equals(quItemId)){
			QuChenRow quChenRow=quChenRowDao.get(quItemId);
			quChenRow.setOptionName(optionName);
			quChenRowDao.save(quChenRow);
			return quChenRow;
		}else{
			//取orderById
			int orderById=getOrderById(quId);
			//新加选项
			QuChenRow quChenRow=new QuChenRow();
			quChenRow.setQuId(quId);
			quChenRow.setOptionName(optionName);
			//title
			quChenRow.setOrderById(++orderById);
			quChenRowDao.save(quChenRow);
			return quChenRow;
		}
	}

	@Override
	@Transactional
	public void ajaxDelete(String quItemId) {
		QuChenRow quChenRow =get(quItemId);
		quChenRow.setVisibility(0);
		quChenRowDao.save(quChenRow);
	}

}
