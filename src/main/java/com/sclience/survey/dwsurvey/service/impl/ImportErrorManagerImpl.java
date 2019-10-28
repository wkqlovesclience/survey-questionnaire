package com.sclience.survey.dwsurvey.service.impl;

import com.sclience.survey.dwsurvey.dao.ImportErrorDao;
import com.sclience.survey.dwsurvey.entity.ImportError;
import com.sclience.survey.dwsurvey.service.ImportErrorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 导入错误记录题
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
@Service
public class ImportErrorManagerImpl implements ImportErrorManager {
    @Autowired
    private ImportErrorDao importErrorDao;
    @Transactional
    public void save(ImportError entity) {
	importErrorDao.save(entity);
    }

}
