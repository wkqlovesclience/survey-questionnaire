package com.sclience.survey.dwsurvey.action.survey;

import com.sclience.survey.common.base.entity.User;
import com.sclience.survey.common.base.service.AccountManager;
import com.sclience.survey.common.plugs.page.Page;
import com.sclience.survey.common.utils.web.Struts2Utils;
import com.sclience.survey.dwsurvey.entity.Question;
import com.sclience.survey.dwsurvey.entity.SurveyAnswer;
import com.sclience.survey.dwsurvey.entity.SurveyDirectory;
import com.sclience.survey.dwsurvey.service.SurveyAnswerManager;
import com.sclience.survey.dwsurvey.service.SurveyDirectoryManager;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 答卷数据
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 *
 */

@Namespace("/da")
@InterceptorRefs({ @InterceptorRef("paramsPrepareParamsStack")})
@Results({
	@Result(name=MySurveyAnswerAction.SUCCESS,location="/WEB-INF/page/content/diaowen-da/survey-answer-data.jsp",type=Struts2Utils.DISPATCHER),
	@Result(name = MySurveyAnswerAction.RESPONSE_ANSWER, location = "/WEB-INF/page/content/diaowen-answer/response-answer.jsp", type = Struts2Utils.DISPATCHER)
})
@AllowedMethods({"responseAnswer","exportXLS"})
public class MySurveyAnswerAction extends ActionSupport{
	@Autowired
	private SurveyAnswerManager surveyAnswerManager;
	@Autowired
	private SurveyDirectoryManager directoryManager;
	@Autowired
	private AccountManager accountManager;

	protected final static String RESPONSE_ANSWER = "responseAnswer";

	private Page<SurveyAnswer> page=new Page<SurveyAnswer>();
	private String surveyId;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request=Struts2Utils.getRequest();
		User user=accountManager.getCurUser();
    	if(user!=null){
    		SurveyDirectory survey=directoryManager.getSurveyByUser(surveyId, user.getId());
    		if(survey!=null){
    			page=surveyAnswerManager.answerPage(page, surveyId);
    			request.setAttribute("survey", survey);
    		}
    	}

		return SUCCESS;
	}

	public String responseAnswer() throws Exception {
		HttpServletRequest request=Struts2Utils.getRequest();
		String answerId=request.getParameter("answerId");
		List<Question> questions = new ArrayList<Question>();
		try {
			SurveyDirectory directory=new SurveyDirectory();
			if (answerId != null) {
				SurveyAnswer answer = surveyAnswerManager.getModel(answerId);
				questions = surveyAnswerManager.findAnswerDetail(answer);
				User user=accountManager.getCurUser();
		    	if(answer.getSurveyId() != null && user!=null){
		    		SurveyDirectory survey=directoryManager.getSurveyByUser(answer.getSurveyId(), user.getId());
		    		if(survey!=null){
		    			request.setAttribute("questions", questions);
		    			request.setAttribute("directory", directory);
		    		}
		    	}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RESPONSE_ANSWER;
	}


	public String delete() throws Exception {
		HttpServletRequest request=Struts2Utils.getRequest();
		HttpServletResponse response=Struts2Utils.getResponse();
		String result="error";
		try{
			String answerId=request.getParameter("answerId");
			if (answerId != null) {
				SurveyAnswer answer = surveyAnswerManager.getModel(answerId);
				User user=accountManager.getCurUser();
		    	if(answer.getSurveyId() != null && user!=null){
		    		SurveyDirectory survey=directoryManager.getSurveyByUser(answer.getSurveyId(), user.getId());
		    		if(survey!=null){
		    			surveyAnswerManager.delete(answer);
						Integer answerNum = survey.getAnswerNum();
						if(answerNum!=null && answerNum>=1){
							survey.setAnswerNum(answerNum-1);
							directoryManager.save(survey);
						}
		    		}
		    	}
			}
			result="true";
		}catch(Exception e){
			e.printStackTrace();
		}
		response.getWriter().write(result);
		return null;
	}

	public String exportXLS() throws Exception{
		HttpServletRequest request=Struts2Utils.getRequest();
		HttpServletResponse response=Struts2Utils.getResponse();
		try{
			String savePath = request.getSession().getServletContext().getRealPath("/");
			User user=accountManager.getCurUser();
	    	if(user!=null){
	    		SurveyDirectory survey=directoryManager.getSurveyByUser(surveyId, user.getId());
	    		if(survey!=null){
	    			savePath=surveyAnswerManager.exportXLS(surveyId,savePath);
	    			response.sendRedirect(request.getContextPath()+savePath);
	    		}
	    	}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Page<SurveyAnswer> getPage() {
		return page;
	}

	public void setPage(Page<SurveyAnswer> page) {
		this.page = page;
	}

	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}

}
