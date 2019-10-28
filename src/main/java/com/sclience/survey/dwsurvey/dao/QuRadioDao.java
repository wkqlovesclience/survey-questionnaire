package com.sclience.survey.dwsurvey.dao;

import com.sclience.survey.common.dao.BaseDao;
import com.sclience.survey.dwsurvey.entity.QuRadio;

public interface QuRadioDao extends BaseDao<QuRadio, String> {

	public void quOrderByIdDel1(String quId, Integer orderById);

}
