package com.sclience.survey.dwsurvey.dao.impl;

import com.sclience.survey.common.dao.BaseDaoImpl;
import com.sclience.survey.dwsurvey.dao.ImportErrorDao;
import com.sclience.survey.dwsurvey.entity.ImportError;
import org.springframework.stereotype.Repository;

/**
 * 导入错误记录 dao
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */

@Repository
public class ImportErrorDaoImpl  extends BaseDaoImpl<ImportError, String> implements ImportErrorDao {

}
