package com.sclience.survey.dwsurvey.action.survey;

import com.sclience.survey.common.base.action.CrudActionSupport;
import com.sclience.survey.common.base.service.AccountManager;
import com.sclience.survey.dwsurvey.entity.SurveyStyle;
import com.sclience.survey.dwsurvey.service.SurveyDirectoryManager;
import com.sclience.survey.dwsurvey.service.SurveyStyleManager;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 问卷样式
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 *
 */

@Namespaces({@Namespace("/design")})
@InterceptorRefs({ @InterceptorRef("paramsPrepareParamsStack")})
@Results({})
public class MySurveyStyleAction extends CrudActionSupport<SurveyStyle, String>{

	private String surveyId;
	@Autowired
	private SurveyStyleManager surveyStyleManager;
	@Autowired
	private SurveyDirectoryManager surveyDirectoryManager;
	@Autowired
	private AccountManager accountManager;

	public String save() throws Exception  {
		return NONE;
	}

	public String ajaxGetStyle() throws Exception {
	    return null;
	}


}
