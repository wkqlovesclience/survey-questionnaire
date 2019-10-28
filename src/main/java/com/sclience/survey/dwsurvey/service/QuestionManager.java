package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.common.service.BaseService;
import com.sclience.survey.dwsurvey.entity.Question;
import com.sclience.survey.dwsurvey.entity.SurveyDirectory;

import java.util.List;

/**
 * 题基础
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
public interface QuestionManager extends BaseService<Question, String>{

	public Question getDetail(String quId);

	public List<Question> find(String belongId, String tag);

	public List<Question> findDetails(String belongId, String tag);

	public void getQuestionOption(Question question);

	public List<Question> findByParentQuId(String parentQuId);

	public List<Question> findByQuIds(String[] quIds, boolean b);

	public void deletes(String[] delQuIds);
	//交接排序位置--前台交换
	public boolean upsort(String prevId, String nextId);

	public void saveBySurvey(String belongId, int tag, List<Question> questions);

	public void saveChangeQu(String belongId, int tag, String[] quIds);

	public List<Question> findStatsRowVarQus(SurveyDirectory survey);

	public List<Question> findStatsColVarQus(SurveyDirectory survey);

	public void update(Question entity);

}
