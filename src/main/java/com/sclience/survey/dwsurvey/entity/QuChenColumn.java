package com.sclience.survey.dwsurvey.entity;

import com.sclience.survey.common.base.entity.IdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 矩陈题-列选项
 * @author wangkeqiang
 * @date 2013下午12:23:26
 *
 * https://github.com/wwangkeqiang/DWSurvey
 * http://dwsurvey.net
 */
@Entity
@Table(name="t_qu_chen_column")
public class QuChenColumn extends IdEntity{

	//题
	private String quId;
	//项
	private String optionName;
	//排序
	private Integer orderById;
	//是否显示  0不显示
	private Integer visibility=1;

	public String getQuId() {
		return quId;
	}
	public void setQuId(String quId) {
		this.quId = quId;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public Integer getOrderById() {
		return orderById;
	}
	public void setOrderById(Integer orderById) {
		this.orderById = orderById;
	}
	public Integer getVisibility() {
		return visibility;
	}
	public void setVisibility(Integer visibility) {
		this.visibility = visibility;
	}

	private int anCount;
	@Transient
	public int getAnCount() {
		return anCount;
	}
	public void setAnCount(int anCount) {
		this.anCount = anCount;
	}

}
