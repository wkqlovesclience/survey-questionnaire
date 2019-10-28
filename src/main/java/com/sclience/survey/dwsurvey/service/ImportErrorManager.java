package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.dwsurvey.entity.ImportError;

/**
 * 导入错误记录
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface ImportErrorManager {

    void save(ImportError importError);

}
