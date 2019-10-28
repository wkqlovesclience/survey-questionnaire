package com.sclience.survey.dwsurvey.action.survey;

import com.sclience.survey.common.utils.web.Struts2Utils;
import com.sclience.survey.dwsurvey.entity.SurveyDirectory;
import com.sclience.survey.dwsurvey.service.SurveyDirectoryManager;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URLDecoder;


/**
 * 创建问卷
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 *
 */

@Namespace("/design")
@InterceptorRefs({ @InterceptorRef("paramsPrepareParamsStack")})
@Results({
	@Result(name="design",location="/design/my-survey-design.action?surveyId=${surveyId}",type=Struts2Utils.REDIRECT)
})
public class MySurveyCreateAction extends ActionSupport{
	@Autowired
	private SurveyDirectoryManager directoryManager;

	private String surveyId;

	@Override
	public String execute() throws Exception {
	    return SUCCESS;
	}

	public String save() throws Exception {
		String surveyName=Struts2Utils.getParameter("surveyName");
		SurveyDirectory survey = new SurveyDirectory();
	    try{
	    	survey.setDirType(2);
	    	if(surveyName==null || "".equals(surveyName.trim())){
	    		surveyName="请输入问卷标题";
	    	}else{
	    		surveyName=URLDecoder.decode(surveyName,"utf-8");
	    	}
	 	    survey.setSurveyName(surveyName);
	 	    directoryManager.save(survey);
	 	    surveyId = survey.getId();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    return "design";
	}

	public String getSurveyId() {
	    return surveyId;
	}

}
