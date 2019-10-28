package com.sclience.survey.dwsurvey.action.sysuser;

import com.sclience.survey.common.base.action.CrudActionSupport;
import com.sclience.survey.common.utils.web.Struts2Utils;
import com.sclience.survey.dwsurvey.entity.SysEmail;
import com.sclience.survey.dwsurvey.service.SysEmailManager;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 系统邮件集成 action
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 *
 */
@Namespaces({@Namespace("/sy/system"),@Namespace("/sy/system/nosm")})
@InterceptorRefs({ @InterceptorRef("paramsPrepareParamsStack") })
@Results({
	@Result(name=CrudActionSupport.SUCCESS,location="/WEB-INF/page/diaowen-system/email-list.jsp",type=Struts2Utils.DISPATCHER),
	@Result(name=CrudActionSupport.INPUT,location="/WEB-INF/page/diaowen-system/email-input.jsp",type=Struts2Utils.DISPATCHER),
	@Result(name=CrudActionSupport.RELOAD,location="/WEB-INF/page/ref-parent.jsp",type=Struts2Utils.DISPATCHER)
})
public class SysEmailAction extends CrudActionSupport<SysEmail, String>{

	@Autowired
	private SysEmailManager sysEmailManager;

	@Override
	public String input() throws Exception {
		return super.input();
	}

	@Override
	public String list() throws Exception {
		page=sysEmailManager.findPage(page, filters);
		return super.list();
	}

	@Override
	public String save() throws Exception {
		try{
			sysEmailManager.save(entity);
		}catch (Exception e) {
			e.printStackTrace();
		}

		return super.save();
	}

	@Override
	protected void prepareModel() throws Exception {
		entity=sysEmailManager.getModel(id);
	}
}
