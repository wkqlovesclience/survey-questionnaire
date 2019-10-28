package com.sclience.survey.dwsurvey.action.survey;

import com.sclience.survey.common.base.entity.User;
import com.sclience.survey.common.base.service.AccountManager;
import com.sclience.survey.common.utils.web.Struts2Utils;
import com.sclience.survey.dwsurvey.entity.Question;
import com.sclience.survey.dwsurvey.entity.SurveyDirectory;
import com.sclience.survey.dwsurvey.entity.SurveyStats;
import com.sclience.survey.dwsurvey.service.SurveyDirectoryManager;
import com.sclience.survey.dwsurvey.service.SurveyStatsManager;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 分析报告 action
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 *
 */
@Namespace("/da")
@InterceptorRefs({ @InterceptorRef("paramsPrepareParamsStack")})
@Results({
	@Result(name=SurveyReportAction.DEFAULT_REPORT,location="/WEB-INF/page/content/diaowen-da/default-report.jsp",type=Struts2Utils.DISPATCHER),
	@Result(name=SurveyReportAction.LINE_CHART,location="/WEB-INF/page/content/diaowen-da/line-chart.jsp",type=Struts2Utils.DISPATCHER),
	@Result(name=SurveyReportAction.PIE_CHART,location="/WEB-INF/page/content/diaowen-da/pie-chart.jsp",type=Struts2Utils.DISPATCHER),
})
@AllowedMethods({"defaultReport","lineChart","pieChart","chartData"})
public class SurveyReportAction extends ActionSupport{

	protected final static String DEFAULT_REPORT="default_report";
	protected final static String LINE_CHART="line_chart";
	protected final static String PIE_CHART="pie_chart";

	@Autowired
	private SurveyStatsManager surveyStatsManager;
	@Autowired
	private SurveyDirectoryManager directoryManager;
	@Autowired
	private AccountManager accountManager;

	private SurveyStats surveyStats = new SurveyStats();
	private SurveyDirectory directory = new SurveyDirectory();

	private String surveyId;

	public String defaultReport() throws Exception {
		// 得到频数分析数据
		User user = accountManager.getCurUser();
		if(user!=null){
			directory=directoryManager.getSurveyByUser(surveyId, user.getId());
			if(directory!=null){
				List<Question> questions = surveyStatsManager.findFrequency(directory);
				surveyStats.setQuestions(questions);
			}
		}
		return DEFAULT_REPORT;
	}

	public String lineChart() throws Exception {
		User user = accountManager.getCurUser();
		if(user!=null){
			directory=directoryManager.getSurveyByUser(surveyId, user.getId());
			if(directory!=null){
				List<Question> questions = surveyStatsManager.dataChart1s(directory);
				surveyStats.setQuestions(questions);
			}
		}
		return LINE_CHART;
	}

	public String pieChart() throws Exception {
		User user = accountManager.getCurUser();
		if(user!=null){
			directory=directoryManager.getSurveyByUser(surveyId, user.getId());
			if(directory!=null){
				List<Question> questions = surveyStatsManager.dataChart1s(directory);
				surveyStats.setQuestions(questions);
			}
		}
		return PIE_CHART;
	}

	//取得某一题的统计数据
	public String chartData() throws Exception {
		HttpServletResponse response=Struts2Utils.getResponse();
		//取柱状图数据
		User user = accountManager.getCurUser();
		if(user!=null){
			String questionId=Struts2Utils.getParameter("quId");
			Question question=new Question();
			question.setId(questionId);
			surveyStatsManager.questionDateCross(question);
			response.getWriter().write(question.getStatJson());
		}
		return null;
	}

	public SurveyStats getSurveyStats() {
		return surveyStats;
	}

	public SurveyDirectory getDirectory() {
		return directory;
	}

	public String getSurveyId() {
	    return surveyId;
	}

	public void setSurveyId(String surveyId) {
	    this.surveyId = surveyId;
	}

}
