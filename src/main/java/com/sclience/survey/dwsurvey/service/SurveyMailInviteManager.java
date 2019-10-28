package com.sclience.survey.dwsurvey.service;

import com.sclience.survey.common.plugs.page.Page;
import com.sclience.survey.dwsurvey.entity.SurveyMailInvite;

public interface SurveyMailInviteManager {

    public void saveNew(String inboxs, SurveyMailInvite surveyMailInvite);

    public Page<SurveyMailInvite> findPage(Page<SurveyMailInvite> page, String surveyId);

    public void sendMailInvite(String string);

    public SurveyMailInvite getById(String mailInviteId);

    public void save(SurveyMailInvite surveyMailInvite);
}
