package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.common.service.BaseService;
import com.sclience.survey.dwsurvey.entity.AnCompChenRadio;

import java.util.List;

/**
 * 复合矩陈单选题
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */

public interface AnCompChenRadioManager extends BaseService<AnCompChenRadio, String>{

	public List<AnCompChenRadio> findAnswer(String belongAnswerId, String quId);

}
