package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.common.plugs.page.Page;
import com.sclience.survey.common.service.BaseService;
import com.sclience.survey.dwsurvey.entity.QuestionBank;

import java.util.List;

/**
 * 题库
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface QuestionBankManager extends BaseService<QuestionBank, String>{
	/**
	 * 根据 最底层对象，得到此对象所在的目录结构
	 * @param surveyDirectory
	 * @return
	 */
	public List<QuestionBank> findPath(QuestionBank questionBank);

	public QuestionBank getBank(String parentId);

	public QuestionBank findByNameUn(String id, String parentId, String bankName);

	public Page<QuestionBank> findPage(Page<QuestionBank> page, QuestionBank entity);

	public void executeBank(String id);

	public void closeBank(String id);

	public List<QuestionBank> newQuestionBank() ;
}
