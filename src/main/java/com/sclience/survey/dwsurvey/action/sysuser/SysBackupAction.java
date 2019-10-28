package com.sclience.survey.dwsurvey.action.sysuser;

import com.sclience.survey.common.base.action.CrudActionSupport;
import com.sclience.survey.common.utils.web.Struts2Utils;
import com.sclience.survey.dwsurvey.entity.SysDbBackup;
import com.sclience.survey.dwsurvey.service.SysDbBackupManager;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 系统备份 action
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 *
 */
@Namespaces({@Namespace("/sy/system"),@Namespace("/sy/system/nosm")})
@InterceptorRefs({ @InterceptorRef("paramsPrepareParamsStack") })
@Results({
	@Result(name=CrudActionSupport.SUCCESS,location="/WEB-INF/page/diaowen-system/backup-list.jsp",type=Struts2Utils.DISPATCHER),
	@Result(name=CrudActionSupport.INPUT,location="/WEB-INF/page/diaowen-system/backup-input.jsp",type=Struts2Utils.DISPATCHER),
	@Result(name=CrudActionSupport.RELOAD,location="/WEB-INF/page/ref-parent.jsp",type=Struts2Utils.DISPATCHER)
})
public class SysBackupAction extends CrudActionSupport<SysDbBackup, String>{

	@Autowired
	private SysDbBackupManager sysDbBackupManager;

	@Override
	public String input() throws Exception {
		return super.input();
	}

	@Override
	public String list() throws Exception {
		page=sysDbBackupManager.findPage(page, filters);
		return super.list();
	}

	@Override
	public String save() throws Exception {
		sysDbBackupManager.save(entity);
		return super.save();
	}

	@Override
	protected void prepareModel() throws Exception {
		entity=sysDbBackupManager.getModel(id);
	}
}
