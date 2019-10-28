package com.sclience.survey.dwsurvey.action.sysuser;

import com.sclience.survey.common.base.action.CrudActionSupport;
import com.sclience.survey.common.utils.web.Struts2Utils;
import com.sclience.survey.dwsurvey.entity.SysLog;
import org.apache.struts2.convention.annotation.*;

/**
 * 系统日志分析 action
 * @author wangkeqiang(wkqsclience118706@163.com)
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 *
 */
@Namespaces({@Namespace("/sy/system"),@Namespace("/sy/system/nosm")})
@InterceptorRefs({ @InterceptorRef("paramsPrepareParamsStack") })
@Results({
	@Result(name=CrudActionSupport.SUCCESS,location="/WEB-INF/page/diaowen-system/log-list.jsp",type=Struts2Utils.DISPATCHER),
	@Result(name=CrudActionSupport.INPUT,location="/WEB-INF/page/diaowen-system/log-list.jsp",type=Struts2Utils.DISPATCHER),
	@Result(name=CrudActionSupport.RELOAD,location="/WEB-INF/page/ref-parent.jsp",type=Struts2Utils.DISPATCHER)
})
public class SysLogAction extends CrudActionSupport<SysLog, String>{

	@Override
	public String input() throws Exception {
		// TODO Auto-generated method stub
		return super.input();
	}

	@Override
	public String list() throws Exception {
		// TODO Auto-generated method stub
		return super.list();
	}

}
